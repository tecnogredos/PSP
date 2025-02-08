package com.medac.t15;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

/**
 * CIFRADO SIMÉTRICO necesitamos una clave, para ello utilizamos
 * <code>KeyGenerator</code>
 *
 * Clase que utiliza <code>KeyGenerator</code> para generar una clave y luego
 * cifrar un texto con dicha clave.
 *
 * Para cifrar hacemos uso de la clase <code>Cipher</code>
 *
 * @see https://docs.oracle.com/javase/8/docs/api/java/security/Key.html
 * @see https://docs.oracle.com/javase/8/docs/api/javax/crypto/KeyGenerator.html
 * @see https://docs.oracle.com/javase/8/docs/api/javax/crypto/Cipher.html
 *
 * @author
 */
public class Ejemplo03_CriptoClaveSimetrica {

    /**
     * Cifrado de un texto con AES Usando ECB. No se recomienda el modo ECB,
     * porque hace posible ver repeticiones y utilizar este conocimiento para
     * descifrar.
     */
    private void caso1_UsandoECB(String texto) {
        //Comprobación de parámetro de entrada
        if (Objects.isNull(texto) || "".equals(texto)) {
            throw new IllegalArgumentException("Parámetro de entrada no válido");
        }

        try {

            //Obtenermos la clave, para ello usamos KeyGenerator
            KeyGenerator keygen = KeyGenerator.getInstance("AES");

            //https://docs.oracle.com/javase/8/docs/api/javax/crypto/KeyGenerator.html#init-int-
            keygen.init(256); //Initializes this key generator for a certain keysize.

            //Generamos la clave secreta
            //Opción 1 - 
            Key key = keygen.generateKey();
            //Opción 2 -
            //SecretKey key = keygen.generateKey();
            
//Proceso de ENCRIPTACIÓN de un texto, usando Cipher con una clave secreta key
            //Realizamos el cifrado usando la clase Cipher
            String algoritmoCifrado = "AES/ECB/PKCS5Padding";
            //Instanciamos la clase según el algotritmo de cifrado escogido
            Cipher cipher = Cipher.getInstance(algoritmoCifrado);

            //Inicializamos el cifrador con la clave privada que hemos obtenido
            //Es decir, vamos a encriptar con esa clave
            cipher.init(Cipher.ENCRYPT_MODE, key);

            //La funcion doFinal ... concluye la operación
            //https://docs.oracle.com/javase/8/docs/api/javax/crypto/Cipher.html#doFinal-byte:A-
            byte[] encrypted = cipher.doFinal(texto.getBytes());
            //Convertimos los bytes para poder mostrarlos como texto
            //https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/DatatypeConverter.html
            System.out.println(DatatypeConverter.printHexBinary(encrypted));

//Proceso de DESENCRIPTACIÓN de un texto, usando Cipher con una clave secreta key    
            //Inicializamos el cifrador con la clave privada que hemos obtenido
            //Es decir, vamos a desencriptar el texto encriptado con esa clave
            cipher.init(Cipher.DECRYPT_MODE, key);
            String result = new String(cipher.doFinal(encrypted));
            System.out.println(result);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Cifrado de un texto con AES Usando CBC. Para evitar la repetición en este
     * caso, debe utilizar otro modo: Cipher Block Chaining (CBC). Necesitamos
     * un vector de inicialización (representado por la clase IvParameterSpec)
     */
    private void caso2_UsandoCBC(String texto) {

        //Comprobación de parámetro de entrada
        if (Objects.isNull(texto) || "".equals(texto)) {
            throw new IllegalArgumentException("Parámetro de entrada no válido");
        }
        try {
            //Vector de inicialización
            //Cuanta más aleatorio sea, mejor.
            SecureRandom random = SecureRandom.getInstanceStrong();
            byte[] rnd = new byte[16];
            random.nextBytes(rnd);
            //Este vector de inicialización lo usaremos para encriptar y desencriptar
            IvParameterSpec ivSpec = new IvParameterSpec(rnd);
            
            //Generamos la clave secreta
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(256);
            SecretKey key = keygen.generateKey();
            
//Proceso de ENCRIPTACIÓN de un texto, usando Cipher con una clave secreta key   
            //Realizamos el cifrado usando la clase Cipher
            String algoritmoCifrado = "AES/CBC/PKCS5Padding";
            //Instanciamos la clase según el algotritmo de cifrado escogido
            Cipher cipher = Cipher.getInstance(algoritmoCifrado);
            //Inicializamos el cifrador con la clave privada que hemos obtenido
            //y el ventor de inicialización. Es decir, vamos a encriptar con esa clave
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

            //La funcion doFinal ... concluye la operación            
            byte[] encrypted = cipher.doFinal(texto.getBytes());
            //Convertimos los bytes para poder mostrarlos como texto            
            System.out.println(DatatypeConverter.printHexBinary(encrypted));

//Proceso de DESENCRIPTACIÓN de un texto, usando Cipher con una clave secreta key    
            //Inicializamos el cifrador con la clave privada que hemos obtenido
            //Es decir, vamos a desencriptar el texto encriptado con esa clave
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
            String result = new String(cipher.doFinal(encrypted));
            System.out.println(result);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        //Texto que quiero encriptar
        String texto1 = "Texto secreto que debo encriptar";
        String texto2 = "Texto secreto que debo encriptar. Otra cosa";

        var claveSimetrica = new Ejemplo03_CriptoClaveSimetrica();

        claveSimetrica.caso1_UsandoECB(texto1);
        claveSimetrica.caso2_UsandoCBC(texto2);
    }
}
