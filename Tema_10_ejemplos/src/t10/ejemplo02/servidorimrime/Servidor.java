package t10.ejemplo02.servidorimrime;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author aWa
 */
public class Servidor {
    
    public static void main(String[] args) {
        new Servidor(6666).iniciar();
    }

    private final int puerto;
    
    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public void iniciar() {

        try {
            //escuchando();
            //Puesto a la escucha
            ServerSocket servidor = new ServerSocket(this.puerto);
            System.out.println("[Servidor] escuchando...");

            while (Boolean.TRUE) {//Por siempre

                //Aceptamos la comunicación
                Socket misocket = servidor.accept();

                //Flujo de entrada
                InputStream aux = misocket.getInputStream();
                DataInputStream flujoEntradaServidor = new DataInputStream(aux);

                String mensaje = flujoEntradaServidor.readUTF();

                System.out.println("[Servidor] " + mensaje);

                misocket.close();

            }//fin del while

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
