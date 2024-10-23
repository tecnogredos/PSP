/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t04.ejemplo01;

/**
 *
 * @author aWa
 */
public class EjemploCrearHiloRunnable implements Runnable{
    public static void main(String[] args) {
        // Creamos un hilo        
        EjemploCrearHiloThread ech = new EjemploCrearHiloThread();
        Thread hilo = new Thread(ech);
        
        hilo.start();
    }
    @Override
    public void run() {
        System.out.println("Hola desde el hilo creado con Runnable!!");
    }
}
