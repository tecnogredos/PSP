package t07.ejemplo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import t07.domain.Constantes;

/**
 *
 */
public class EjemploTCPServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private final int puerto;
    
    public EjemploTCPServer(int puerto) {
        this.puerto = puerto;
    }
    public static void main(String[] args) {
        EjemploTCPServer server = new EjemploTCPServer(Constantes.EJEMPLO_02.PUERTO);
        server.iniciar();
    }
    public void iniciar() {
        
        try {
            //Corre en un ordenador especiífico de la red en un puerto determinado
            serverSocket = new ServerSocket(this.puerto);
            System.out.println("Servidor escuchando peticiones del cliente....");
            
            while(true) {
                //Escuchando el socket por si el cliente realiza la conexión
                clientSocket = serverSocket.accept();
                //Accedemos al outputstream para escribir mensajes al cliente            
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                //Accedemos al input streams para recibir los mensajes del cliente
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));            

                String mensaje = in.readLine();                
                System.out.println(mensaje);
                
                out.println("ejecutando comando ... " + mensaje);
                
            }
        } catch (IOException ex) {
            System.err.println(EjemploTCPServer.class.getName() + ex.getMessage());
        } finally {
            parar();
        }
    }

    public void parar() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException ex) {
            System.err.println(EjemploTCPServer.class.getName() + ex.getMessage());
        }
    }

    
}
