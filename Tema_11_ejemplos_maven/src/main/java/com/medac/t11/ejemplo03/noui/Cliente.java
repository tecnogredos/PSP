package com.medac.t11.ejemplo03.noui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author 
 */
public class Cliente {
    
    public static void main(String[] args) {
        
        try {
            
            InetAddress ip = InetAddress.getByName("localhost");
            int puerto = 6666;
            
            //Construimos el Socket para la comunicación
            System.out.println(String.format("Cliente --> Conectando con %s:%d", ip.getHostName() ,puerto));
            Socket socket = new Socket(ip, puerto);
            
            //Flujos de entrada y salida
            //  Si quiero hacer un write o enviar un mensaje, utilizo el outputSteam
            OutputStream aux1 = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(aux1);
            
            //  Si quiero hacer un read o recibir un mensaje, utilizo el inputStream
            InputStream aux2 = socket.getInputStream();
            DataInputStream dis = new DataInputStream(aux2);
            
            //Primer mensaje y primera respuesta del servidor
            String textoenviar = String.format("Cliente: Enviando el texto ... %d", (int) (Math.random() * 100) + 1);
            
            dos.writeUTF(textoenviar);
            String mensajeRecibido = dis.readUTF();
            System.out.println("--> " + mensajeRecibido);
            
            //Segundo mensaje y segunda respuesta del servidor                        
            dos.writeUTF("generar");
            mensajeRecibido = dis.readUTF();
            System.out.println("--> " + mensajeRecibido);
            
            //Tercer mensaje y tercera respuesta del servidor
            dos.writeUTF("generar");
            mensajeRecibido = dis.readUTF();
            System.out.println("--> " + mensajeRecibido);
            
            //Cuarto mensaje y cuarta respuesta del servidor
            dos.writeUTF("salir");
            mensajeRecibido = dis.readUTF();
            System.out.println("--> " + mensajeRecibido);
                        
            //Cierro la conexion
            socket.close();
                       
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
