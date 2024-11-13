package t07.ejemplo02;

import java.util.logging.Level;
import java.util.logging.Logger;
import t07.domain.Constantes;

/**
 * Clase principal con la isntancia de las clases necesarias para una conexión
 * entre cliente y servidor TCP
 */
public class MainEjemploTCP {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            EjemploTCPCliente cliente = new EjemploTCPCliente();
            cliente.iniciarConexion(
                    Constantes.EJEMPLO_02.HOST,
                    Constantes.EJEMPLO_02.PUERTO);
            String response = cliente.enviarMensaje(" comando " + i);
            System.out.println(response);
            cliente.pararConexion();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainEjemploTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
