package com.medac.t15.socketseguro2;

import com.medac.t15.socketseguro.SSLCliente;
import com.medac.t15.socketseguro.SSLServidor;

/**
 *
 * @author 
 */
public class AppSSLServer {
     public static void main(String[] args) {
        try {
            new SSLServidor2(5557).arrancarServidor2();
            new SSLCliente2("localhost",5557).lanzarCliente2();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
