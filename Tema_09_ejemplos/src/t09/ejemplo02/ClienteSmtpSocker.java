package t09.ejemplo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class ClienteSmtpSocker {
    
    private final String HOST_SMTP;
    private final int PUERTO;
    
    public static void main(String[] args) {
        ClienteSmtpSocker clientesmtp = new ClienteSmtpSocker();
        clientesmtp.ejecutar();
    }
    public ClienteSmtpSocker() {
        this.HOST_SMTP = "smtp.gmail.com";
        this.PUERTO = 25;
    }
    private void ejecutar() {
        try {
            //Creo un socket para la comunicación con el servidor
            Socket socket = new Socket(this.HOST_SMTP, this.PUERTO);
            //Abrimos flujo de entreda y salida del socker
            InputStream is = socket.getInputStream();
            //Leemos el bufer, creando un streamReader a partir del inputStream del socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            
            //Buffer de salida del socket lo vamos a mostrar
            OutputStream os = socket.getOutputStream();
            PrintWriter printer = new PrintWriter(os, true);
            
            //Resultado de la solicitud de conexión
            String linea = reader.readLine();
            System.out.println("conn resultado: " + linea);
            
            
            //https://mailtrap.io/es/blog/smtp-commands-and-responses/
            //Mensaje de inicio de sesion
            printer.println("helo " + this.HOST_SMTP);
            linea = reader.readLine();
            System.out.println("helo resultado: " + linea);
            
            //Mensaje de comando 
            printer.println("noop " + this.HOST_SMTP);
            linea = reader.readLine();
            System.out.println("noop resultado: " + linea);
            
            //Mensaje de comando 
            printer.println("RSET " + this.HOST_SMTP);
            linea = reader.readLine();
            System.out.println("rset resultado: " + linea);
            
            
            //Cerrar conexión
            printer.println("quit");
            linea = reader.readLine();
            System.out.println("quit resultado: " + linea);
                       
            
            
        } catch (IOException ex) {
            Logger.getLogger(ClienteSmtpSocker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
