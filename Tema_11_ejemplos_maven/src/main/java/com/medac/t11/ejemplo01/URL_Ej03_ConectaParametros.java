package com.medac.t11.ejemplo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Conectamos con una URL enviando una solicitud con parámetros. Para ello
 * utilizamos la clase URLConnection
 *
 * @author 
 */
public class URL_Ej03_ConectaParametros {

    public static void main(String[] args) {
        URL_Ej03_ConectaParametros ejemplo = new URL_Ej03_ConectaParametros();
        //ejemplo.leerRecurso();
        ejemplo.escribirPeticion();
    }

    /**
     * Pasos: 
     * <ul>
     *  <li>Crear un URL.</li>
     *  <li>Obtener el objeto URLConnection.</li>
     *  <li>Establecer capacidad de envío(output) en el URLConnection.</li>
     * </ul>
     */
    private void escribirPeticion() {
        try {
            String dataToSend = "?usuario="+URLEncoder.encode("Juan García Muñoz", "UTF-8");
            String urlCompleta = String.format("https://fp.3630.es/dam/pages/formulario.php%s", dataToSend);
            System.out.println(urlCompleta);
            
            //<li>Crear un URL.</li>
            URL phpForm = new URI(urlCompleta).toURL();
            //<li>Obtener el objeto URLConnection.</li>
            URLConnection connection = phpForm.openConnection();
            // Establecemos algunas propiedas de envió, como es el User-Agent
            // Para conocer el useragent del navegador visitar (https://www.whatismybrowser.com/es/detect/what-is-my-user-agent/)
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36");
            
            //<li>Establecer capacidad de envío(output) en el URLConnection.</li>
            // Es importante establecemos la capacidad de envió.
            connection.setDoOutput(true);
                        
            //Leemos los datos de la página formulario.php, tiene un formulario
            InputStreamReader aux2 = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(aux2);

            String response;
            while ((response = reader.readLine()) != null) {
                System.out.println(response);
            }
            reader.close();
            
        } catch (MalformedURLException | URISyntaxException ex) {
            System.out.println(URL_Ej03_ConectaParametros.class.getName() + ex.getMessage());
        } catch (IOException ex) {
            System.out.println(URL_Ej03_ConectaParametros.class.getName() + ex.getMessage());
        }
    }

    private void leerRecurso() {
        try {
            //Creamos la URL
            URL index1URL = new URI("https://fp.3630.es/dam/index.html").toURL();
            /**
             * El siguiente código hace lo mismo que el ejemplo
             * <code>URL_Ej02_Reader.java</code>, pero usando la clase
             * <code>java.net.URLConnection</code> pueden usadas, no obstante,
             * tiene sus ventajas usar URLConnection, por ejemplo, que podemos
             * realizar otras acciones además de leer, como es escribir a esa
             * URL(como enviar datos a un formulario POST, ver más abajo).
             */
            URLConnection connection = index1URL.openConnection();

            //Leemos los datos de la página index.html, tiene un formulario
            InputStreamReader aux = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(aux);

            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();

        } catch (MalformedURLException | URISyntaxException ex) {
            System.out.println(URL_Ej03_ConectaParametros.class.getName() + ex.getMessage());
        } catch (IOException ex) {
            System.out.println(URL_Ej03_ConectaParametros.class.getName() + ex.getMessage());
        }
    }
}
