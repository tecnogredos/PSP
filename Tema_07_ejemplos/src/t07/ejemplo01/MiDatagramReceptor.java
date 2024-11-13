package t07.ejemplo01;

import t07.domain.Constantes;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Clase representativa del receptor de los datagramas. Se queda escuchando en
 * el puerto <code>Constantes.EJEMPLO_01.PUERTO</code> Cuando recibe un mensaje,
 * lo imprime en la consola
 *
 */
public class MiDatagramReceptor {

    public static void main(String[] args) {
        
        try {
            System.out.println("Receptor escuchando .... ");
            //Clase servidor basado en DatagramSocket para recibir datos
            DatagramSocket ds = new DatagramSocket(Constantes.EJEMPLO_01.PUERTO);
            
            while (Boolean.TRUE) { //Por siempre
                //Recogemos el paquete de datos
                //Constructor de DatagramPacket para recibir paquetes de una longitud
                DatagramPacket pack = new DatagramPacket(
                        new byte[Constantes.EJEMPLO_01.NUM_BYTES], 
                        Constantes.EJEMPLO_01.NUM_BYTES);
                //Recibe un paquete datagram desde el socket
                ds.receive(pack);
                //Muesta los datos por consola
                System.out.println(new String(pack.getData()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
