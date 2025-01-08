package com.medac.t11.ejemplo02;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

/**
 * Ejemplo de conexión SFTP(FTP con comunicación segura) usando liberías
 * externas.
 *
 * En este ejemplo, la librería necesaria para realizar un conexión SFTP es:
 * SSHJ
 *
 * <dependency>
 * <groupId>com.hierynomus</groupId>
 * <artifactId>sshj</artifactId>
 * <version>0.38.0</version>
 * </dependency>
 *
 *
 *
 * @see https://www.baeldung.com/java-file-sftp
 *
 * @author
 */
public class SFTPConexionSSHJ {

    private final String host = "home278398733.1and1-data.host";
    private final String user = "u52614463-TIC";
    private final String pasw = "#EdFpMc@2023";

    public static void main(String[] args) {
        SFTPConexionSSHJ ejemplo = new SFTPConexionSSHJ();
        ejemplo.conecta();
    }

    private void conecta() {
        subirFichero();
        descargarFichero();
    }

    /**
     * Función que retorna una clase representativa del cliente FTP necesario
     * para la conexión con el servidor
     *
     * @return objeto ChannelSftp
     * @throws JSchException
     */
    private SSHClient abrirConexion() throws IOException {
        SSHClient client = new SSHClient();
        client.addHostKeyVerifier(new PromiscuousVerifier());
        client.connect(host);
        client.useCompression();
        client.authPassword(user, pasw);
        return client;
    }

    public void subirFichero() {
        try {
            SSHClient sshClient = abrirConexion();
            SFTPClient sftpClient = sshClient.newSFTPClient();

            String localFile = "C:\\Users\\aWa\\Documents\\NetBeansProjects\\Tema_11_ejemplos_maven\\src\\main\\java\\com\\medac\\t11\\ejemplo02\\recursos\\sample.txt";
            String remoteDir = "dam/";

            sftpClient.put(localFile, remoteDir + "prueba2.txt");

            sftpClient.close();
            sshClient.disconnect();

        } catch (IOException ex) {
            System.out.println(SFTPConexionSSHJ.class.getName() + ex.getMessage());
        }
    }

    public void descargarFichero() {
        try {
            SSHClient sshClient = abrirConexion();
            SFTPClient sftpClient = sshClient.newSFTPClient();
            
            String remoteFile = "dam/pages/pagina1.html";
            String localDir = "C:\\Users\\aWa\\Documents\\NetBeansProjects\\Tema_11_ejemplos_maven\\src\\main\\java\\com\\medac\\t11\\ejemplo02\\recursos\\";

            sftpClient.get(remoteFile, localDir + "sshjFile.html");

            sftpClient.close();
            sshClient.disconnect();

        } catch (IOException ex) {
            System.out.println(SFTPConexionSSHJ.class.getName() + ex.getMessage());
        }
    }
}
