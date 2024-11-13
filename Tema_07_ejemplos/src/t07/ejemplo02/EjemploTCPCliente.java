package t07.ejemplo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 */
public class EjemploTCPCliente {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void iniciarConexion(String ip, int port) {
        try {
            //Para crear el socket cliente necesito la ip y el puerto
            clientSocket = new Socket(ip, port);
            //El input stream del cliente esta conectado al output stream del servidor
            //Así como el input stream del servidor esta contectado al output stream del client
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ex) {
            System.err.println(EjemploTCPCliente.class.getName() + ex.getMessage());            
        }
    }

    public String enviarMensaje(String msg) {
        String resp = "";
        try {
            out.println(msg);
            resp = in.readLine();            
        } catch (IOException ex) {
            System.err.println(EjemploTCPCliente.class.getName() + ex.getMessage());
        }
        return resp;
    }

    public void pararConexion() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException ex) {
            System.err.println(EjemploTCPCliente.class.getName() + ex.getMessage());
        }
    }
}
