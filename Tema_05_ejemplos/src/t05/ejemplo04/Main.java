/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t05.ejemplo04;

/**
 *
 * @author aWa
 */
public class Main {
    public static void main(String[] args) {
        Libro libro  = new Libro("Don Quijote");
        
        LectorLibro lector1 = new LectorLibro(libro);
        LectorLibro lector2 = new LectorLibro(libro);
        
        Thread lector1Hilo = new Thread(lector1, "[Lector 1]");
        Thread lector2Hilo = new Thread(lector2, "[Lector 2]");
        
        lector1Hilo.start();
        lector2Hilo.start();
        
        
        EscritorLibro escritor = new EscritorLibro(libro);
        
        Thread escritorHilo = new Thread(escritor);
        
        escritorHilo.start();
        
    }
}
