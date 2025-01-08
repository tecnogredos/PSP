package com.medac.t11.ejemplo03.noui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class Servidor {

    public static void main(String[] args) {

        try {
            int puerto = 6666;
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println(String.format("[SERVIDOR] --> Escuchando en localhost:%d", puerto));

            while (Boolean.TRUE) {//Por siempre
                
                //Aceptamos la comunicación
                Socket misocket = null;

                //Aceptamos la comunicación
                misocket = servidor.accept();

                System.out.println("[SERVIDOR] --> Cliente conectado ...");

                //Flujos de entrada y salida
                //  Si quiero hacer un write o enviar un mensaje, utilizo el outputSteam
                OutputStream aux1 = misocket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(aux1);

                //  Si quiero hacer un read o recibir un mensaje, utilizo el inputStream
                InputStream aux2 = misocket.getInputStream();
                DataInputStream dis = new DataInputStream(aux2);
                
                //Creamos el hilo que atiende a la petición realizada
                Thread hilo = new ServidorHilo(misocket, dos, dis);
                hilo.start();

            }//fin del while(true)

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
