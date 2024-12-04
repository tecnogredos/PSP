package t09.ejemplo01;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * Ejemplo de clase representativa de un cliente FTP. Ejemplo de conexión con un
 * servidor ftp por protocolo no seguro Para la información de los datos del
 * servidor, consultar: <code>https://www.wftpserver.com/onlinedemo.htm</code>
 * Wing FTP Server Online Demo We set up an online demo server for you to
 * explore the new features available in Wing FTP Server. You can explore both
 * Web-based Administration and Web-based Client.
 *
 * Secure Web-based Administration:
 *
 * Location: https://demo.wftpserver.com:5466/ Username: demo-admin Password:
 * demo-admin Secure Web-based Client:
 *
 * Location: https://demo.wftpserver.com/ Username: demo Password: demo Login
 * using your own client with FTP, FTPS, SFTP protocol:
 *
 * Location: demo.wftpserver.com Username: demo Password: demo FTP Port: 21 FTPS
 * Port: 990 SFTP Port: 2222 Note: all the demo accounts are read-only accounts,
 * so you can not change server settings.
 *
 * @author
 */
public class ClienteFTP01 {

    private final String urlFTP;
    private final String usuario;
    private final String pwd;
    private final int FTP_Port;

    public static void main(String[] args) {
        //Instancio la clase
        ClienteFTP01 clienteFtp = new ClienteFTP01();
        //Llamada a la función que ejecuta la lógica de conexión
        clienteFtp.conexionFTP();
    }

    public ClienteFTP01() {
        //Parámetros de conexión
        //Ver info: https://www.wftpserver.com/onlinedemo.htm
        this.urlFTP = "demo.wftpserver.com";
        this.usuario = "demo";
        this.pwd = "demo";
        this.FTP_Port = 21;
    }

    private void conexionFTP() {
        try {
            //Clase java contenida en librería Apache Commons Net
            //https://commons.apache.org/net/download_net.cgi
            //Ver api: https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPClient.html
            FTPClient ftp = new FTPClient();
            //Realizo la conexión y recogo el código de respuesta del servidor
            System.out.println("Estleciendo conexion con el servidor ...");
            ftp.connect(this.urlFTP, this.FTP_Port);
            int codigoRespuesta = ftp.getReplyCode();
            //Según el código de respuesta, informo
            if (!FTPReply.isPositiveCompletion(codigoRespuesta)) {
                System.out.println("Error en la conexión");
                //Puedo lanzar excepción - finalizar
            } else {
                boolean isLoginOK = ftp.login(this.usuario, this.pwd);
                if (isLoginOK) {
                    System.out.println("Cliente logeado en el servidor");
                } else {
                    System.out.println("Usuario o contraseña incorrectas");
                }
                //Finalizo la conexión y desconecto
                ftp.logout();
                System.out.println("... haciendo logout!");
                ftp.disconnect();
                System.out.println("... desconectando del servidor!");
            }
        } catch (IOException ex) {
            Logger.getLogger(ClienteFTP01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
