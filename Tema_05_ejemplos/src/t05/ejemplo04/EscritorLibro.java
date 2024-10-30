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
public class EscritorLibro implements Runnable {
    private final Libro libro;
    public EscritorLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public void run() {
        synchronized (libro) {
            System.out.println("[Escritor] El escritor comienza el libro: " + libro.getTitulo());
            try {
                Thread.sleep(7000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EscritorLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
            libro.setCompleted(true);
            System.out.println("[Escritor] El escritor finaliza el libro!!! ");
            libro.notify(); //notifica 
            //libro.notifyAll(); //notifica 
            System.out.println("[Escritor] Notificacion al lector");
        }
    }
}
