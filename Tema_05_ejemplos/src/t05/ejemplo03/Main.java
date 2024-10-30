/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t05.ejemplo03;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class Main {
    public static void main(String[] args) {
        try {
            Clock reloj = new Clock();
            
            Thread hilo = new Thread(reloj);
            hilo.start();
            //Quiero interrumpit la ejecución del hilo después de 10 segundos
            Thread.sleep(10000);
            hilo.interrupt();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
