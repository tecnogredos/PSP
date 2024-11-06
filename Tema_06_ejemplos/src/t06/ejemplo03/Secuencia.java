package t06.ejemplo03;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que contiene el número de la secuencia que es una variable
 * compartida por todos los hilos que la usen, pero utiliza 
 * la clase Semáforo para gestionar su acceso
 * 
 */
public class Secuencia {
    
    //Valor que se va a ir incrementando
    private int valor = 0;
    
    //Objeto semaforo binario para que se modifique el valor nada mas
    private final Semaphore semaforo = new Semaphore(1);
    
    public int getSiguiente() {
        try {
            //Si un hilo ha aquirido permiso del semáforo,
            //el siguiente hilo se queda esperando aquí hasta 
            //que se produce una semaforo.release
            semaforo.acquire();
            //Esta modificación de la variable se realiza
            //en exclusión mutua ya que adquiero el permito 
            //en la sentencia anterior con semaforo. acquire()
            valor = valor + 1;
        } catch (InterruptedException ex) {
            Logger.getLogger(Secuencia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Liberar el permito
            semaforo.release();
        }
        return valor;
    }
}
