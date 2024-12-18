
package t10.ejemplo02.servidorimrime;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author aWa
 */
public class Cliente extends Thread {
    
    public static void main(String[] args) {
        new Cliente().ejecutar();
    }
    
    public void ejecutar() {
        try {
            String texto = "Mensaje desde el cliente";
            System.out.println("[Cliente] ejecutado");
            //Construimos el Socket para la comunicación
            Socket socket = new Socket("localhost", 6666);
            
            //Flujo de datos hacia el servidor
            OutputStream aux = socket.getOutputStream();
            DataOutputStream flujoSalidaCliente = new DataOutputStream(aux);//Flujo de salida
            
            flujoSalidaCliente.writeUTF(texto + "\n");
            
            socket.close();
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
