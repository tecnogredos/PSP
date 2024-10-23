/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t04.ejemplo02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class HiloSaluda extends Thread {
    private String nombre;
    private int delay;
    
    public HiloSaluda(String n, int d) {
        this.nombre = n;
        this.delay = d;
    }
    @Override
    public void run() {
        try {
            sleep(this.delay);
            System.out.println("Hola desde " + this.nombre + " " + this.delay + " ms");
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloSaluda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
