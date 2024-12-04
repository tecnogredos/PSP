
package t09.ejemplo01;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * @see 
 * @author 
 */
public class ClienteFTP02 {
    private final String urlFTP;
    private final String usuario;
    private final String pwd;
    private final int FTP_Port;

    public static void main(String[] args) {
        //Instancio la clase
        ClienteFTP02 clienteFtp = new ClienteFTP02();
        //Llamada a la función que ejecuta la lógica de conexión
        //Listar ficheros del servidor
        clienteFtp.listarFicheros();
    }
    public ClienteFTP02() {
        //Parámetros de conexión
        //Ver info: https://www.wftpserver.com/onlinedemo.htm
        this.urlFTP = "demo.wftpserver.com";
        this.usuario = "demo";
        this.pwd = "demo";
        this.FTP_Port = 21;
    }
    private void listarFicheros() {
        try {
            //Clase java contenida en librería Apache Commons Net
            //https://commons.apache.org/net/download_net.cgi
            //Ver api: https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPClient.html
            FTPClient ftp = new FTPClient();
            //Realizo la conexión y recogo el código de respuesta del servidor
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
                    
                    //Listamos los ficheros
                    FTPFile[] files = ftp.listFiles("/upload");
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    for(FTPFile file: files) {
                        String desc = file.getName();
                        if(file.isDirectory()) {
                            desc = String.format("[ %s ]", desc);
                        }
                        //desc = desc + "\t\t" + file.getSize();
                        desc = df.format(file.getTimestamp().getTime()) + "\t" + desc ;
                        System.out.println(desc);
                    }
                    
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
