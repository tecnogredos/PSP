package com.medac.t15.socketseguro2;

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
public class SSLCliente2 {
    private final SSLSocket client;

   public SSLCliente2(String address, int port) throws Exception {

      KeyStore keyStore = KeyStore.getInstance("JKS");
      keyStore.load(new FileInputStream("./src/main/java/certs2/cliente/certificadoCliente.jks"),
            "123456".toCharArray());

      KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      kmf.init(keyStore, "123456".toCharArray());

      KeyStore trustedStore = KeyStore.getInstance("JKS");
      trustedStore.load(new FileInputStream(
            "./src/main/java/certs2/cliente/clientTrustedCerts.jks"), "123456"
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
   public void lanzarCliente2() {
       System.out.println("Cliente Prueba 2 SSL comienza ...");
      new Thread() {
         @Override
         public void run() {
            try {
                
               PrintWriter output = new PrintWriter(client.getOutputStream());
               output.println("===Dato enviado===");
               output.flush();
               
               System.out.println("[Cliente] - enviando '===Dato enviado==='");
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