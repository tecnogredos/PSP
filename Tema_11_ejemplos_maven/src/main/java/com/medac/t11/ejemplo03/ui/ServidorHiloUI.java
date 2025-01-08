
package com.medac.t11.ejemplo03.ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author 
 */
public class ServidorHiloUI extends Thread {

    Socket socket;
    DataOutputStream dos;//si quiero hacer un write
    DataInputStream dis;//si quiero hacer un read
    javax.swing.JTextArea textArea;

    public ServidorHiloUI(Socket socket, DataOutputStream dos, DataInputStream dis, javax.swing.JTextArea textArea) {
        this.socket = socket;
        this.dos = dos;
        this.dis = dis;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        String info = String.format("[SERVIDOR][HILO %s] --> Nuevo hilo del cliente creado ...", Thread.currentThread().getName());
        this.textArea.append("\n" + info);
        try {
            boolean finalizar = false;
            while (!finalizar) {
                //Leo el comando enviado por parámetro
                String comando = dis.readUTF();
                System.out.println(String.format("[SERVIDOR][HILO %s]--> Recibido comando del cliente: %s", Thread.currentThread().getName(), comando));
                this.textArea.append("\n" + String.format("[SERVIDOR][HILO %s]--> Recibido comando del cliente: %s", Thread.currentThread().getName(), comando));
                
                switch (comando) {
                    case "generar" -> {
                        int aleatorio = (int) (Math.random() * 100) + 1;
                        String datoenviar = String.format("[SERVIDOR] --> %s(%d)", "Numero aleatorio generado" , aleatorio);
                        //Envio texto al cliente con un numero aleatorio
                        this.dos.writeUTF(datoenviar);
                        System.out.println(String.format("[SERVIDOR]\t--> %s(%d)", "El Servidor ha geneardo un Numero aleatorio" , aleatorio));
                        this.textArea.append("\n" + String.format("[SERVIDOR][HILO %s]\t--> %s(%d)",Thread.currentThread().getName(), "El Servidor ha geneardo un Numero aleatorio" , aleatorio));
                    }
                    case "salir" -> {
                        //Si se recibe el comando salir se debe finalizar la conexión
                        finalizar = true;
                        String datoenviar = String.format("[SERVIDOR]\t--> El cliente %s ordena SALIR ...", this.socket);
                        //Debo contestar algo, sino se queda esperando
                        this.dos.writeUTF(datoenviar);
                        System.out.println(datoenviar);    
                        System.out.println("[SERVIDOR] \t--> Cerrando conexion ...");
                        this.textArea.append("\n" + "[SERVIDOR][HILO " + Thread.currentThread().getName() + "]\t--> Cerrando conexion ...");
                        this.socket.close();
                    }
                    default -> {
                        String datoenviar = "[SERVIDOR][HILO " + Thread.currentThread().getName() + "]\t--> Opcion enviada incorrecta ..."; 
                        //Debo contestar algo, sino se queda esperando
                        this.dos.writeUTF(datoenviar);
                        System.out.println(datoenviar);
                        this.textArea.append("\n" + datoenviar);
                    }
                }//fin del switch
            }//fin del while
            
            //Cerramos conexiones de los flujos
            this.dis.close();
            this.dos.close();
            
            
        } catch (IOException ex) {
             System.out.println("[SERVIDOR] \t--> ERROR en el Servidor ..." + ex.getMessage());
        }
    }

}
