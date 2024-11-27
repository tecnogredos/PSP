package t08.ejemplo02;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class ServidorHTTP {
    
    public static void main(String[] args) {
        try {
            final int PUERTO = 9001;
            /**
             * En el contexto de las redes informáticas, el backlog se refiere 
             * al número máximo de conexiones pendientes que un servidor puede 
             * manejar en un momento dado. Es decir, cuando un servidor recibe 
             * una solicitud de conexión de un cliente, si el servidor ya está 
             * ocupado con el número máximo de conexiones permitido, entonces 
             * la solicitud de conexión se coloca en una cola o backlog
             */
            HttpServer server = HttpServer.create(new InetSocketAddress(PUERTO), 0);
            
            System.out.println("Servidor arrancado ... esperando peticiones");
            
            HttpContext contexto = server.createContext("/");
            
            contexto.setHandler(ServidorHTTP::gestionar);
            
            server.start();
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Función encargada de gestionar el contexto o mapeo de datos de la URL
     * @param exchange 
     */
    private static void gestionar(HttpExchange exchange) {
        try {
            int RESPONSE_COD = 200;
            String response_msg = "Hola mundo desde el servidor";
            
            exchange.sendResponseHeaders(RESPONSE_COD, response_msg.getBytes().length);
            
            OutputStream os = exchange.getResponseBody();
            os.write(response_msg.getBytes());
            os.close();
            
            //leerParametrosEnviados(exchange);
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void leerParametrosEnviados(HttpExchange exchange) {
        System.out.println(exchange.getRequestURI());
    }
    
}
