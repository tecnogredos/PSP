package t10.ejemplo02.clienteimprime;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 
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
            System.out.println("[Servidor] arrancado...");

            int cnt = 0;
            while (Boolean.TRUE) {//Por siempre

                //Aceptamos la comunicación
                Socket misocket = servidor.accept();

                //Flujo de entrada
                OutputStream aux = misocket.getOutputStream();
                DataOutputStream flujoSalidaServidor = new DataOutputStream(aux);

                System.out.println("\t[Servidor] enviando... " + cnt + " mensajes");
                flujoSalidaServidor.writeUTF("Mensaje " + cnt + ", desde el servidor");


                misocket.close();
                cnt = cnt  + 1;//contador

            }//fin del while

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
