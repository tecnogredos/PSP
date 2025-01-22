package com.medac.t13;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 
 */
public class ExpresionesRegulares {
    
    /**
     * Función que retorna true si el párametro de entrada concuerda con:
     *  - 8 dígitos seguidos.
     *  - Una letra en mayúsculas.
     * 
     * @param entrada Cadena de texto a evaluar
     * @return true si el parámetro de entrada concuerda con el patrón
     */
    public boolean validaDNI(String entrada) {        
        boolean resultado = Boolean.FALSE;//Retorno de la función
        //Comprobación de parámetro de entrada
        if(Objects.isNull(entrada) || "".equals(entrada)) {
            throw new IllegalArgumentException("Parámetro de entrada no válido");
        }
        
        // Compilar la expresión regular en un patrón
        //Pattern pattern = Pattern.compile("\\d{8}[A-Z]");
        Pattern pattern = Pattern.compile("^[0-9]{8}[A-Z]$");
        // Crear un matcher que comparará el patrón con el texto
        Matcher matcher = pattern.matcher(entrada);

        // Validar si hay una coincidencia
        if (matcher.find()) {
            System.out.println("Coincidencia encontrada");
            resultado = Boolean.TRUE;
        } else {
            System.out.println("No hay coincidencia");
        }
        return resultado;
    }
    
    public boolean validaTelefono(String entrada) {        
         boolean resultado = Boolean.FALSE;//Retorno de la función
        //Comprobación de parámetro de entrada
        if(Objects.isNull(entrada) || "".equals(entrada)) {
            throw new IllegalArgumentException("Parámetro de entrada no válido");
        }
        
        // Compilar la expresión regular en un patrón
        //Pattern pattern = Pattern.compile("\\d{8}[A-Z]");
        Pattern pattern = Pattern.compile("^(\\+34)?[0-9]{9}$");
        // Crear un matcher que comparará el patrón con el texto
        Matcher matcher = pattern.matcher(entrada);

        // Validar si hay una coincidencia
        if (matcher.find()) {
            System.out.println("Coincidencia encontrada");
            resultado = Boolean.TRUE;
        } else {
            System.out.println("No hay coincidencia");
        }
        return resultado;
    }
}
