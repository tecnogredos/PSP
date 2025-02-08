package com.medac.t15.socketseguro;

/**
 *
 * @author 
 */
public class Main {
    public static void main(String[] args) {
        try {
            new SSLServidor(5557).arrancarServidor();
            new SSLCliente("localhost",5557).lanzarCliente();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
