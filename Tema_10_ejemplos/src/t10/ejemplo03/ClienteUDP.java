package t10.ejemplo03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

/**
 *
 * @author 
 */
public class ClienteUDP {
    private final int PUERTO = 6666;
    private final String HOST = "localhost";
 
    public static void main(String[] args) {
         new ClienteUDP().ejecutar();
        
    }
    private void ejecutar() {
        try {
            //Enviamos mensaje al servidor
            DatagramSocket socketUDP = new DatagramSocket();
            
            //Mensaje a enviar
            String mensajeaenviar = String.format("Cliente [%d] ", (new Random()).nextInt(100)+1);   //String.valueOf("Cliente: " + (new Random()).nextInt(100)+1)
            byte[] mensaje = mensajeaenviar.getBytes();
            
            InetAddress address = InetAddress.getByName(this.HOST);
            
            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, address, this.PUERTO);
            
            socketUDP.send(peticion);
            
            //Recibimos mensaje del servidor
            byte[] buffer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(respuesta);
            String recibido = new String(respuesta.getData());
            System.out.println("[Cliente UDP] recibe: " + recibido);
            
            socketUDP.close();
            
            
            //ds.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
