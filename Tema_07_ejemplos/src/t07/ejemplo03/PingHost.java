package t07.ejemplo03;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Clase que usa InetAddress apra realizar un ping a un host remoto.
 * De esta forma podemos verificar que exista una conexión.
 */
public class PingHost {

    public static final String HOST = "www.google.com";

    public static void main(String[] args) {
        PingHost ph = new PingHost();
        
        ph.ping("www.google.com");
        ph.ping("www.googssss.es");
        
    }
    public void ping(String host) {
        try {
            System.out.println("Haciendo ping a ... " + host);
            
            //Usamos InetAddress para hacer ping a un host
            InetAddress direccion = InetAddress.getByName(host);
            
            //Con el método podemos saber si se puede acceder despues de un tiempo determinado
            boolean alcanzable = direccion.isReachable(5000);

            if (alcanzable) {
                System.out.println("Direccion accesible!");
            } else {
                System.out.println("La dirección indicada es inaccesible");
            }

        } catch (UnknownHostException ex) {
            System.err.println(PingHost.class.getName() + ex.getMessage());
        } catch (IOException ex) {
            System.err.println(PingHost.class.getName() + ex.getMessage());
        }
    }
}
