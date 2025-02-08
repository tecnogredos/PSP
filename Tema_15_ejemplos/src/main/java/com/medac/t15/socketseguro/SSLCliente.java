package com.medac.t15.socketseguro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/**
 *
 * @author 
 */
public class SSLCliente {
    private final SSLSocket client;

   public SSLCliente(String address, int port) throws Exception {

      KeyStore keyStore = KeyStore.getInstance("JKS");
      keyStore.load(new FileInputStream("./src/main/java/certs/client/clientKey.jks"),
            "clientpass".toCharArray());

      KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      kmf.init(keyStore, "clientpass".toCharArray());

      KeyStore trustedStore = KeyStore.getInstance("JKS");
      trustedStore.load(new FileInputStream(
            "./src/main/java/certs/client/clientTrustedCerts.jks"), "clientpass"
            .toCharArray());

      TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      tmf.init(trustedStore);

      SSLContext sc = SSLContext.getInstance("TLS");
      TrustManager[] trustManagers = tmf.getTrustManagers();
      KeyManager[] keyManagers = kmf.getKeyManagers();
      sc.init(keyManagers, trustManagers, null);

      SSLSocketFactory ssf = sc.getSocketFactory();
      client = (SSLSocket) ssf.createSocket(address, port);
      client.startHandshake();
   }
   public void lanzarCliente() {
       System.out.println("Cliente SSL comienza ...");
      new Thread() {
         @Override
         public void run() {
            try {
                
               PrintWriter output = new PrintWriter(client.getOutputStream());
               output.println("Juan Francisco");
               output.flush();
               
               System.out.println("[Cliente] - enviando 'Juan Francisco'");
               BufferedReader input = new BufferedReader(new InputStreamReader(
                     client.getInputStream()));
               String received = input.readLine();
               System.out.println("Recibido en [Cliente] : " + received);
               client.close();
               
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
         }
      }.start();
   }
}
