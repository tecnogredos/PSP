package t06.ejemplo02;

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
     * Utilizamos synchronized a nivel de bloque.
     * Al utilizar synchronized(this) {... obtengo el mismo resultado
     * que sincronizando a nivel de función ya que this representa la instancia
     * de la clase timbre
     */
    public void tocar() {
        //System.out.println("Este codigo no es critico - No esta en bloque sincronizado");
        synchronized(this) { /***ver línea 19 de Visitante **/
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
}
