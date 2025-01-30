package com.medac.t14;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Clase creada para probar todos los algoritmos de MessageDigest
 *
 * @see
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest">MessageDigest
 * Algorithms</a>
 *
 * @author
 */
public class MessageDigestAlgorithms {

    //https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest
    private final List<String> algoritmos = Arrays.asList(new String[]{
        "MD2",
        "MD5",
        "SHA-1",
        "SHA-224",
        "SHA-256",
        "SHA-384",
        "SHA-512",
        "SHA-512/224",
        "SHA-512/256"
    });

    public MessageDigestAlgorithms() {
    }

    /**
     * Función encargadad de obtener un resumen o hash para un texto enviado
     * como parámetro.
     *
     * @param texto Cadena representativa del texto plano del que se quiere
     * obtener la función hash
     * @param algoritmo Cadena de texto representativo del algoritmo con el que
     * se quiere obtener el resumen o hash
     * @return Cadena de texto representativa del resumen obtenido con el
     * algoritmo descrito en la función
     */
    private String obtenerHash(String texto, String algoritmo) {
        //Cadena de texto con el hash o resumen a retornar
        String hash = "";

        //Comprobación de parámetro de entrada
        if (Objects.isNull(texto) || "".equals(texto)) {
            throw new IllegalArgumentException("Parámetro de entrada no válido");
        }
        //Realizamos el resumen de la cadena enviada como parámetro
        try {
            // Paso 1: pasamos a bytes el mensaje del que queremos obtener el hast
            byte[] texto_en_bytes = texto.getBytes();
            // Paso 2: Creamos el objeto MessageDigest utilizando getInstance
            MessageDigest messageDigest = MessageDigest.getInstance(algoritmo);
            // Paso 3: Pasamos al objeto MessageDigest los bytes del texto
            messageDigest.update(texto_en_bytes);
            // Paso 4: Lanzamos la funcion hash para crear el resumen
            byte[] digest = messageDigest.digest();
            // Paso 5: Convertiomos los bytes del hash a cadena de texto
            hash = bytesToHex(digest);
            System.out.println(String.format("Resumen HASH con algortimo [%s] --> %s --> %s", algoritmo, hash, texto));

        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }
        return hash;
    }

    /**
     * Algoritmo MD2 definido en RFC 1319
     *
     * @see https://datatracker.ietf.org/doc/html/rfc1319
     * @param texto Cadena representativa del texto plano del que se quiere
     * obtener la función hash
     * @return Cadena de texto representativa del resumen obtenido con el
     * algoritmo descrito en la función
     */
    public String hash_MD2(String texto) {
        //Algoritmo MD2
        //String algoritmo = algoritmos.get(0);
        return obtenerHash(texto, "MD2");
    }

    /**
     * Algoritmo MD5 definido en RFC 1321
     *
     * @see https://datatracker.ietf.org/doc/html/rfc1321
     * @param texto Cadena representativa del texto plano del que se quiere
     * obtener la función hash
     * @return Cadena de texto representativa del resumen obtenido con el
     * algoritmo descrito en la función
     */
    public String hash_MD5(String texto) {
        //Algoritmo MD5
        //String algoritmo = algoritmos.get(1);
        return obtenerHash(texto, "MD5");
    }

    /**
     * Algoritmo SHA-1
     *
     * @param texto Cadena representativa del texto plano del que se quiere
     * obtener la función hash
     * @return Cadena de texto representativa del resumen obtenido con el
     * algoritmo descrito en la función
     */
    public String hash_SHA_1(String texto) {
        //Algoritmo SHA-1
        //String algoritmo = algoritmos.get(2);
        return obtenerHash(texto, "SHA-1");
    }

    /**
     * Algoritmo SHA-256
     *
     * @param texto Cadena representativa del texto plano del que se quiere
     * obtener la función hash
     * @return Cadena de texto representativa del resumen obtenido con el
     * algoritmo descrito en la función
     */
    public String hash_SHA_256(String texto) {
        //Algoritmo SHA-256
        return obtenerHash(texto, "SHA-256");
    }

    /**
     * Algoritmo SHA-512
     *
     * @param texto Cadena representativa del texto plano del que se quiere
     * obtener la función hash
     * @return Cadena de texto representativa del resumen obtenido con el
     * algoritmo descrito en la función
     */
    public String hash_SHA_512(String texto) {
        //Algoritmo SHA-512
        return obtenerHash(texto, "SHA-512");
    }

    /**
     * Función encargada de convertir un array de bytes a una cadena de texto.
     * Recorre cada byte de la matriz y calcula su equivalente hexadecimal.
     *
     * @param bytes Array de bytes a convertir
     * @return Cadena de texto correspondiente a ese array de bytes
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder out = new StringBuilder();
        for (byte b : bytes) {
            out.append(String.format("%02X", b));
        }
        return out.toString();
    }

}
