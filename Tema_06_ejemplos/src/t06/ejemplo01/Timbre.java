package t06.ejemplo01;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase representativa de un recurso.
 * La instancia de este recurso es un monitor.
 * 
 */
public class Timbre {
    
    /**
     * Función del objeto Timbre que hace sonar.
     * Esto se representa con dos mensajes por consola, un Ding... Dong...
     * Pasan 2 seguntos entre el Ding... y el Dong...
     * Utilizamos synchronized a nivel de función.
     * Probar a.- sin synchronized y b.- con synchronized 
     */
    //public void tocar() {
    public synchronized void tocar() {
        System.out.print("Ding ...");
        try {
            //Espera 2 segundos
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Timbre.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Dong ...");
    }
}
