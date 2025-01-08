package com.medac.t11.ejemplo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author 
 */
public class URL_Ej02_Reader {
    
    public static void main(String[] args) {
        URL_Ej02_Reader ejemplo = new URL_Ej02_Reader();
        //ejemplo.leerContenidoURL();
        ejemplo.leerContenidoURLLocalhost();
    }
    /**
     * Función que se contecta a una URL en concreto (https://fp.3630.es/dam/pages/pagina1.html) 
     * y lee su contenido.
     */
    private void leerContenidoURL() {
        
        try {
            URL pagina1URL = new URI("https://fp.3630.es/dam/pages/pagina1.html").toURL();
            
            System.out.println(String.format("=== Conectando con %s ===",pagina1URL.toString()));
            InputStreamReader aux = new InputStreamReader(pagina1URL.openStream());
            BufferedReader reader = new BufferedReader(aux);
                        
            String linea;
            while( (linea = reader.readLine()) != null ) {
                    System.out.println(linea);
            }
        } catch (URISyntaxException | MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    private void leerContenidoURLLocalhost() {
        //para probar este ejemplo debemos lanzar la clase <code>ServidorHTTP.java</code>
        try {
            URL pagina1URL = new URI("http://localhost:9001").toURL();
            
            System.out.println(String.format("=== Conectando con %s ===",pagina1URL.toString()));
            InputStreamReader aux = new InputStreamReader(pagina1URL.openStream());
            BufferedReader reader = new BufferedReader(aux);
                        
            String linea;
            while( (linea = reader.readLine()) != null ) {
                    System.out.println(linea);
            }
        } catch (URISyntaxException | MalformedURLException ex) {
            System.out.println(URL_Ej01_Conecta.class.getName() + ex.getMessage());
        } catch (IOException ex) {
            System.out.println(URL_Ej01_Conecta.class.getName() + ex.getMessage());
        }
        
    }
}
