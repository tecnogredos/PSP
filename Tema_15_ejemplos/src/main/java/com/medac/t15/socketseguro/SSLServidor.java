package com.medac.t15.socketseguro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/**
 *
 * @author
 */
public class SSLServidor {

    private SSLServerSocket serverSocket;

    /**
     * Constructor del servidor SSL con un puerto determinado.
     * En el constructor se cargan los certificados.
     * 
     * @param port
     * @throws Exception 
     */
    public SSLServidor(int port) throws Exception {
        
        //Cargamos el fichero serverKey.jks, que es un almacén de certificados del servidor
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("./src/main/java/certs/server/serverKey.jks"),
                "servpass".toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "servpass".toCharArray());

        //¿En quién confiamos?
        //Cargamos el almacen las entidades en las que confiamos que están en dicho almacén
        //Es decir, en serverTrustedCerts.jks tenemos
        KeyStore trustedStore = KeyStore.getInstance("JKS");
        trustedStore.load(new FileInputStream(
                "./src/main/java/certs/server/serverTrustedCerts.jks"), "serverpass".toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustedStore);

        //Creamos el contexto de comunicación segura
        SSLContext sc = SSLContext.getInstance("TLS");
        TrustManager[] trustManagers = tmf.getTrustManagers();
        KeyManager[] keyManagers = kmf.getKeyManagers();
        sc.init(keyManagers, trustManagers, null);

        //Creamos el ServerSocket seguro
        SSLServerSocketFactory ssf = sc.getServerSocketFactory();
        serverSocket = (SSLServerSocket) ssf.createServerSocket(port);
    }
    public void arrancarServidor() {
        System.out.println("Servidor SSL Inicializado ....");
      new Thread() {
         @Override
         public void run() {
            try {
               Socket aClient = serverSocket.accept();
               System.out.println("Peticion del Cliente Aceptada...");
               aClient.setSoLinger(true, 1000);
               
               BufferedReader input = new BufferedReader(new InputStreamReader(
                     aClient.getInputStream()));
               String recibido = input.readLine();
               System.out.println("[Servidor] Recibido dato " + recibido);
               
               PrintWriter output = new PrintWriter(aClient.getOutputStream());
               output.println("Saludos desde el __Servidor__, " + recibido);
               output.flush();
               aClient.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

         }
      }.start();
    }
}
