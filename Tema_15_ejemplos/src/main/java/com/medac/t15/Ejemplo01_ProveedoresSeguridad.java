package com.medac.t15;

import java.security.Provider;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * La plataforma Java proporciona un conjunto de proveedores integrados que se
 * pueden ampliar si es necesario.
 *
 * @author
 */
public class Ejemplo01_ProveedoresSeguridad {

    public static void main(String[] args) {
        //https://www.ibm.com/docs/es/semeru-runtime-ce-z/17?topic=guide-installing-security-providers
        Provider[] proveedores = Security.getProviders();
        boolean isBouncyCastle = false;
        for (Provider p : proveedores) {
            System.out.println(String.format("Proveedor [%s] %s", p.getName(), p.getInfo()));
            isBouncyCastle = p.getInfo().startsWith("BouncyCastle");
        }
        System.out.println(
                String.format("Proveedor BouncyCastle Security %s",
                        (isBouncyCastle ? "AÑADIDO" : "NO AÑADIDO")));

        System.out.println("==========");
        //Añadimos proveedor para seguridad BouncyCastle
        /* BouncyCastle
         * The Bouncy Castle Crypto package is a Java implementation of 
         * cryptographic algorithms. This jar contains JCE provider and 
         * lightweight API for the Bouncy Castle Cryptography APIs for JDK 1.5 and up
         */
        //En un proyecto maven, añado la dependencia del jar en pom.xml
        Security.addProvider(new BouncyCastleProvider());
        proveedores = Security.getProviders();
        for (Provider p : proveedores) {
            System.out.println(String.format("Proveedor [%s] %s", p.getName(), p.getInfo()));
            isBouncyCastle = p.getInfo().startsWith("BouncyCastle");
        }
        System.out.println(
                String.format("Proveedor BouncyCastle Security %s",
                        (isBouncyCastle ? "AÑADIDO" : "NO AÑADIDO")));
    }

}
