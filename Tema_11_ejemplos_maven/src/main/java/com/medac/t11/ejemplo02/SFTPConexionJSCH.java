package com.medac.t11.ejemplo02;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * Ejemplo de conexión SFTP(FTP con comunicación segura) usando liberías externas.
 * 
 * En este ejemplo, la librería necesaria para realizar un conexión SFTP es:
 * JSch
 * 
 <dependency>
    <groupId>com.github.mwiede</groupId>
    <artifactId>jsch</artifactId>
    <version>0.2.16</version>
 </dependency>
 * 
 * 
 *
 * @see https://www.baeldung.com/java-file-sftp
 *
 * @author
 */
public class SFTPConexionJSCH {

    private final String host = "home278398733.1and1-data.host";
    private final String user = "u52614463-TIC";
    private final String pasw = "#EdFpMc@2023";

    public static void main(String[] args) {
        SFTPConexionJSCH jsch = new SFTPConexionJSCH();
        jsch.subirFichero();
        jsch.descargarFichero();
    }
    
    /**
     * Función que retorna una clase representativa del cliente FTP necesario
     * para la conexión con el servidor 
     * @return objeto ChannelSftp
     * @throws JSchException 
     */
    private ChannelSftp abriConexion() throws JSchException {
        JSch jsch = new JSch();
        //Ver (https://vlade.medium.com/ssh-en-sistemas-windows-d2db3b81069f)
        //Ejecutar el comando: ssh-keyscan -H -t rsa home278398733.1and1-data.host >> known_hosts
        jsch.setKnownHosts("C:\\Users\\MEDAC\\known_hosts");
        Session jschSession = jsch.getSession(user, host);
        jschSession.setPassword(pasw);
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }

    public void subirFichero()  {
        try {
            ChannelSftp channelSftp = abriConexion();
            channelSftp.connect();
            
            String localFile = "C:\\Users\\aWa\\Documents\\NetBeansProjects\\Tema_11_ejemplos_maven\\src\\main\\java\\com\\medac\\t11\\ejemplo02\\recursos\\sample.txt";
            String remoteDir = "dam/";
            //Subir el fichero
            channelSftp.put(localFile, remoteDir + "mifichero.txt");
            
            channelSftp.exit();
            
        } catch (JSchException | SftpException ex) {
            System.out.println(SFTPConexionJSCH.class.getName() + ex.getMessage());
        }
    }
    public void descargarFichero()  {
        try {
            ChannelSftp channelSftp = abriConexion();
            channelSftp.connect();
            
            String remoteFile = "dam/pages/formulario.php";
            String localDir = "\\src\\main\\java\\com\\medac\\t11\\ejemplo02\\recursos\\";
            
            //dercargar el fichero
            channelSftp.get(remoteFile, localDir + "mifichero.php");
            
            channelSftp.exit();
            
        } catch (JSchException | SftpException ex) {
            System.out.println(SFTPConexionJSCH.class.getName() + ex.getMessage());
        }
    }

    
}
