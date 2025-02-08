package com.medac.t15;

import java.security.Security;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author
 */
public class Ejemplo02_AlgoritmosCifrado {

    public static void main(String[] args) {
        Set<String> keyGenerators = Security.getAlgorithms("KeyGenerator");
        System.out.println("Generadores de claves soportados: " + keyGenerators.stream().sorted().collect(Collectors.joining(",")));

        Set<String> secretKeyFactories = Security.getAlgorithms("SecretKeyFactory");
        System.out.println("Factoria de Generadores de claves soportadas: " + secretKeyFactories.stream().sorted().collect(Collectors.joining(",")));

        Set<String> chipers = Security.getAlgorithms("Cipher");
        System.out.println("Cifradores soportados: " + chipers.stream().sorted().collect(Collectors.joining(",")));

    }
}
