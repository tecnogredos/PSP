/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t04.ejemplo01;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class EjemploCrearHiloThread extends Thread {

    private final List<String> infoList = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos un hilo
        EjemploCrearHiloThread ech = new EjemploCrearHiloThread();
        ech.start();
    }
    public EjemploCrearHiloThread() {
        infoList.add("Informacion uno");
        infoList.add("Mensaje dos");
        infoList.add("Informacion tres");
        infoList.add("Informacion importante");
    }
    @Override
    public void run() {
        System.out.println("Hola desde el hilo creado con Thread!!");
        
        infoList.forEach( info -> {
            try { 
                Thread.sleep(1000);
                System.out.println(info);
            } catch (InterruptedException ex) {
                Logger.getLogger(EjemploCrearHiloThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
