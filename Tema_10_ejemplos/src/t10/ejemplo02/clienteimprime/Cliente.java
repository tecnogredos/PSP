package t10.ejemplo02.clienteimprime;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author aWa
 */
public class Cliente {
    public static void main(String[] args) {
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                new Cliente().ejecutar();
            }
        }, 1000, 1000);
        
        
        
    }
    
    public void ejecutar() {
        try {
            
            //Construimos el Socket para la comunicación
            Socket socket = new Socket("localhost", 6666);
            
            //Flujo de datos desde el servidor
            InputStream aux = socket.getInputStream();
            DataInputStream flujoEntradaCliente = new DataInputStream(aux);//Flujo de salida
            
             String mensaje = flujoEntradaCliente.readUTF();
             System.out.println("[Cliente] " + mensaje);
            
            socket.close();
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}