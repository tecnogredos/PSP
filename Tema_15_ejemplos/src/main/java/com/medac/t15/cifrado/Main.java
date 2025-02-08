package com.medac.t15.cifrado;

import java.security.SecureRandom;

/**
 *
 * @author 
 */
public class Main {
    public static void main(String[] args) {
        String clavePrivada = "en1LugarD3LaMancha";
        
        String textoPlano = "Esto es un texto con datos privados";
        
        //String iv = "0123456789ABCDEF";
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);        
        
        
        var util = new StringEncrypt();
        String textoEncriptado = util.encriptar(clavePrivada, iv, textoPlano);
        String resultado = String.format("Texto encriptado {%s}", textoEncriptado);
        System.out.println(resultado);
        
        String textoDesencriptado = util.desencriptar(clavePrivada, iv, textoEncriptado);
        String resultado2 =String.format("Texto plano {%s}", textoDesencriptado); 
        System.out.println(resultado2);
        
                
    }
}
