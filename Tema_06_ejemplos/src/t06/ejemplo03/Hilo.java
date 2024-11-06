package t06.ejemplo03;

/**
 * Clase representativa de una tarea que utilizará la secuencia para 
 * incrementar su valor llamando a getSiguiente() de la clase Secuencia.
 * 
 */
public class Hilo implements Runnable {
    
    private final Secuencia secuencia;
    private final int id;
    public Hilo(int id, Secuencia recursoCompartido) {
        this.id = id;
        this.secuencia = recursoCompartido;
    }

    @Override
    public void run() {
        System.out.println("Id hilo [" + this.id + "]" +
                " valor secuencia: " + secuencia.getSiguiente());
                
    }
    
    
}
