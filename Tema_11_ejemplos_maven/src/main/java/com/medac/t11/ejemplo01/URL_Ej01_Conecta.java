package com.medac.t11.ejemplo01;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Clase con ejemplo de uso de la clase <code>java.net.URL</code> y 
 * <code>java.net.URI</code> de Java.
 * 
 * Conecta con url 
 *  https://fp.3630.es/dam/index.html
 *  https://fp.3630.es/dam/pages/pagina1.html
 *  https://fp.3630.es/dam/pages/destino.html?usuario=dato+a+enviar
 * 
 * @author 
 */
public class URL_Ej01_Conecta {
    
    public static void main(String... args) {
        URL_Ej01_Conecta urlEjemplo = new URL_Ej01_Conecta();
        //urlEjemplo.usandoURL();
        urlEjemplo.usandoURI();
    }
    /**
     * Función que recibe un objeto java.net.URL y muestra los datos.
     * 
     * @param miURL 
     */
    private void imprimeDatos(URL miURL) {
        System.out.println("Protocolo: " + miURL.getProtocol());
        System.out.println("Host: " + miURL.getHost());
        System.out.println("Archivo: " + miURL.getFile());
    }
    /**
     * Función para ejecutar un ejemplo de conexión con los constructores de la 
     * clase URL. (Nota: deprecated)
    */
    private void usandoURL() {
        try {
            //URL(URL baseURL, String relativeURL)  -- https://docs.oracle.com/javase/tutorial/networking/urls/creatingUrls.html
            URL baseURL = new URL("https://fp.3630.es/dam/");
            System.out.println("=== Datos de URL 'https://fp.3630.es/dam/' ===");
            imprimeDatos(baseURL);
            
            URL index1URL = new URL(baseURL, "index.html");
            System.out.println("=== Datos de URL 'https://fp.3630.es/dam/index.html' ===");
            imprimeDatos(index1URL);
            
            URL pagina1URL = new URL(baseURL, "pages/pagina1.html");
            System.out.println("=== Datos de URL 'https://fp.3630.es/dam/pages/pagina1.html' ===");
            imprimeDatos(pagina1URL);

        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Mismo que la función anterior pero utilizando la clase URI para obtener
     * la URL. De esta forma evitamos los constructores deprecated:
     * 'The syntax of URL is defined by RFC 2396: Uniform Resource Identifiers (URI): Generic Syntax, ...'
     */
    private void usandoURI() {
        try {
            //URL(URL baseURL, String relativeURL)  -- https://docs.oracle.com/javase/tutorial/networking/urls/creatingUrls.html
            URI baseURI = new URI("https://fp.3630.es/dam/");
            
            URL baseURL = baseURI.toURL();
            
            System.out.println("=== Usando URI. Datos de URL 'https://fp.3630.es/dam/' ===");
            imprimeDatos(baseURL);
            
            URL index1URL = new URI("https://fp.3630.es/dam/index.html").toURL();
            System.out.println("=== Usando URI. Datos de URL 'https://fp.3630.es/dam/index.html' ===");
            imprimeDatos(index1URL);
            
            URL pagina1URL = new URI("https://fp.3630.es/dam/pages/pagina1.html").toURL();
            System.out.println("=== Usando URI. Datos de URL 'https://fp.3630.es/dam/pages/pagina1.html' ===");
            imprimeDatos(pagina1URL);

        } catch (MalformedURLException | URISyntaxException ex) {
           System.out.println(ex.getMessage());
        }
    }
}
