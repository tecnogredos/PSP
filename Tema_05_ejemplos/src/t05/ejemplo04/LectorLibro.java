/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t05.ejemplo04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class LectorLibro implements Runnable {
    
    /*
    Un objeto usado como monitor, o como memoria compartida entre hilos, 
    debería ser de tipo final, porque si se le asigna un nuevo valor quedan 
    si efecto todos los bloqueos que existan sobre dicho objeto. Un objeto de 
    tipo final una vez que se ha creado y se le ha asignado un valor no se le 
    puede asignar un nuevo valor.
    */
    private final Libro libro;
    
    public LectorLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public void run() {
        /*
        El hilo que llama a wait(), notify() o notifyAll() debe tener el 
        bloqueo del monitor del objeto sobre el que se llama. Si no lo tiene, 
        se lanzará una excepción de tipo java.lang.IllegalMonitorStateException. 
        Por lo tanto, estos métodos deben ser llamados desde un bloque 
        sincronizado.
        */
        synchronized (libro) {
            System.out.println(Thread.currentThread().getName() + 
                    " esperando a que sea escrito el libro: " + this.libro.getTitulo());
            try {
                if (!libro.isCompleted()) {
                    libro.wait();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(LectorLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println(Thread.currentThread().getName() + 
                    " El libro ha sido escrito. Lo lee! ");
        }
    }
    
}
