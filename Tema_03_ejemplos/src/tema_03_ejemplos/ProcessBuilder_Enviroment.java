/*
 * Clase representativa de un proceso en Java.
 * Process (https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Process.html)
 * 
 * Creación de un proceso usando ProcessBuilder
 */
package tema_03_ejemplos;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Propiedades del sistema - Variables del sistema.
 * @author aWa
 */
public class ProcessBuilder_Enviroment {
    
    public static void main(String... args) {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        Map<String, String> env = pb.environment();    
        for(var e: env.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        
        try {
            Process p = pb.start();
            System.out.println(p.isAlive());
            
            int estado = p.waitFor();
            
            System.out.println("Estado del proceso: "+ estado);
            
            p.destroy();
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ProcessBuilder_Enviroment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end main
     
     
}
