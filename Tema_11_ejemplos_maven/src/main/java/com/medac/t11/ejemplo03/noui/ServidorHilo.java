package com.medac.t11.ejemplo03.noui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author
 */
public class ServidorHilo extends Thread {

    Socket socket;
    DataOutputStream dos;//si quiero hacer un write
    DataInputStream dis;//si quiero hacer un read

    public ServidorHilo(Socket socket, DataOutputStream dos, DataInputStream dis) {
        this.socket = socket;
        this.dos = dos;
        this.dis = dis;
    }

    @Override
    public void run() {
        String info = String.format("[SERVIDOR][HILO %s] --> Nuevo hilo del cliente creado ...", Thread.currentThread().getName());
        System.out.println(info);
        try {
            boolean finalizar = false;
            while (!finalizar) {
                //Leo el comando enviado por parámetro
                String comando = dis.readUTF();
                System.out.println(String.format("[SERVIDOR]\t--> Recibido comando del cliente: %s", comando));  
                
                switch (comando) {
                    case "generar" -> {
                        int aleatorio = (int) (Math.random() * 100) + 1;
                        String datoenviar = String.format("[SERVIDOR] --> %s(%d)", "Numero aleatorio generado" , aleatorio);
                        //Envio texto al cliente con un numero aleatorio
                        this.dos.writeUTF(datoenviar);
                        System.out.println(String.format("[SERVIDOR]\t--> %s(%d)", "El Servidor ha geneardo un Numero aleatorio" , aleatorio));
                    }
                    case "salir" -> {
                        //Si se recibe el comando salir se debe finalizar la conexión
                        finalizar = true;
                        String datoenviar = String.format("[SERVIDOR]\t--> El cliente %s ordena SALIR ...", this.socket);
                        //Debo contestar algo, sino se queda esperando
                        this.dos.writeUTF(datoenviar);
                        System.out.println(datoenviar);    
                        System.out.println("[SERVIDOR] \t--> Cerrando conexion ...");
                        this.socket.close();
                    }
                    default -> {
                        String datoenviar = "[SERVIDOR]\t--> Opcion enviada incorrecta ..."; 
                        //Debo contestar algo, sino se queda esperando
                        this.dos.writeUTF(datoenviar);
                        System.out.println(datoenviar);
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
