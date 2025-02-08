package com.medac.t15.cifrado;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

/**
 * Clase utilizada para encriptar y desencriptar un texto.
 *
 * @author
 */
public class StringEncrypt {

    // Defino el tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String algoritmo = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String algoritmoCifrado = "AES/CBC/PKCS5Padding";

    /**
     * Funcion encargada de encriptar el texto plano introducido como argumento
     * en el parámetro "texto". Para ello, utiliza la clave secreta y el vector
     * de inicialización pasados como argumentos.
     *
     * @param claveSecreta Cadena representativa de la clave secreta a utilizar
     * @param iv Array de bytes representativos del vector de inicialización a utilizar
     * @param textoPlano Cadena de texto representativa del texto plano que se quiere
     * encriptar
     * @return Cadena de texto con el texto plano encriptado. Puede retornar
     * null
     */
    public String encriptar(String claveSecreta, byte[] iv, String textoPlano) {

        //Comprobación de parámetros de entrada
        if (Objects.isNull(claveSecreta) || "".equals(claveSecreta)
                || Objects.isNull(iv) 
                || Objects.isNull(textoPlano) || "".equals(textoPlano)) {
            throw new IllegalArgumentException("Parámetros de entrada no válidos");
        }
        String retorno = null;
        try {
            //Construimos la clave secreta a partir del texto enviado
            /**
             * https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/SecretKeySpec.html
             */
            //SecretKeySpec secretKey = new SecretKeySpec(claveSecreta.getBytes(), algoritmo);

            //Let’s define a method for generating the AES key from a given password with 65,536 iterations and a key length of 256 bits:
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(claveSecreta.toCharArray(), "12345678".getBytes(), 65536, 256);
            SecretKey secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
            
            //Vector de inicializacion a partir del texto de entrada
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

//Proceso de ENCRIPTACIÓN de un texto, usando Cipher con una clave secreta key             
            //Instanciamos la clase según el algotritmo de cifrado escogido
            Cipher cipher = Cipher.getInstance(algoritmoCifrado);
            //Inicializamos el cifrador con la clave privada que hemos obtenido
            //y el ventor de inicialización. Es decir, vamos a encriptar con esa clave
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

            //La funcion doFinal ... concluye la operación            
            byte[] encrypted = cipher.doFinal(textoPlano.getBytes());

            //Convertimos los bytes para poder mostrarlos como texto  
            //Utilizamos Apache Commons Codec
            retorno = new String(encodeBase64(encrypted));            

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(StringEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * Funcion encargada de desencriptar el texto plano introducido como
     * argumento en el parámetro "textoencriptado". Para ello, utiliza la clave
     * secreta y el vector de inicialización pasados como argumentos.
     *
     * @param claveSecreta Cadena representativa de la clave secreta a utilizar
     * @param iv Array de bytes representativos del vector de inicialización a utilizar
     * @param textoencriptado Cadena de texto representativa del texto
     * encriptado que se quiere desencriptar
     * @return Cadena de texto con el texto desencriptado. Puede retornar null
     */
    public String desencriptar(String claveSecreta, byte[] iv, String textoencriptado) {

        //Comprobación de parámetros de entrada
        if (Objects.isNull(claveSecreta) || "".equals(claveSecreta)
                || Objects.isNull(iv) 
                || Objects.isNull(textoencriptado) || "".equals(textoencriptado)) {
            throw new IllegalArgumentException("Parámetros de entrada no válidos");
        }
        String retorno = null;
        try {
            //Construimos la clave secreta a partir del texto enviado
            /**
             * https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/SecretKeySpec.html
             */
            //SecretKeySpec secretKey = new SecretKeySpec(claveSecreta.getBytes(), algoritmo);
            //Let’s define a method for generating the AES key from a given password with 65,536 iterations and a key length of 256 bits:
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(claveSecreta.toCharArray(), "12345678".getBytes(), 65536, 256);
            SecretKey secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

            //Vector de inicializacion a partir del texto de entrada
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

//Proceso de DESENCRIPTACIÓN de un texto, usando Cipher con una clave secreta key             
            //Instanciamos la clase según el algotritmo de cifrado escogido
            Cipher cipher = Cipher.getInstance(algoritmoCifrado);
            //Inicializamos el cifrador con la clave privada que hemos obtenido
            //y el ventor de inicialización. Es decir, vamos a encriptar con esa clave
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            //La funcion doFinal ... concluye la operación
            //Utilizamos Apache Commons Codec. Decodificamos lo codificado en Base64
            byte[] enc = Base64.decodeBase64(textoencriptado);
            byte[] decrypted = cipher.doFinal(enc);

            retorno = new String(decrypted);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(StringEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
