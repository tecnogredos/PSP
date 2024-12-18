package t10.ejemplo03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class ServidorUDP {

    private final String HOST = "localhost";
    private final int PUERTO = 6666;

    public static void main(String[] args) {
        new ServidorUDP().ejecutar();
    }

    private void ejecutar() {

        try {
            

            byte[] buffer = new byte[1000];
            System.out.println("[Servidor UDP] arrancado ....");

            /**
             * Mensaje que entra en la clase
             */
            DatagramSocket socketUDP = new DatagramSocket(this.PUERTO);
            //Constructor de DatagramPacket para recibir paquetes de una longitud
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            
                        
            //Leemos la peticion
            socketUDP.receive(paqueteRecibido);

            //Wrapper los datos a cadena de texto
            String mensaje = new String(paqueteRecibido.getData());

            //Mostramos mensaje
            System.out.println("[Servidor UDP] recibe: '" + mensaje + "'");

            /**
             * Mensaje de respuesta que envía la clase
             */
            String respuesta = "Hola " + new String(paqueteRecibido.getData());//String.format("[Servidor UDP] envia ... '(%s)'", "Enviado desde el servidor");

            //Constructor de DatagramPacket para enviar paquetes de una longitud
            InetAddress address = paqueteRecibido.getAddress();
            int puerto = paqueteRecibido.getPort();
            DatagramPacket paqueteEnviar = new DatagramPacket(respuesta.getBytes(), respuesta.getBytes().length, address, puerto);

            //Enviamos el mensaje
            socketUDP.send(paqueteEnviar);
            System.out.println("[Servidor UDP] envia: " + respuesta);

            socketUDP.close();

        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
