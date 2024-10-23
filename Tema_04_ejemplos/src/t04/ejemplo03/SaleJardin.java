/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t04.ejemplo03;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class SaleJardin extends Thread {

    private final RecurosJardin jardin;

    public SaleJardin(String n, RecurosJardin rj) {
        this.setName(n);
        this.jardin = rj;
    }

    @Override
    public void run() {
//synchronized (jardin) {     

        /*try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EntraJardin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        jardin.decrementa();
//}    
    }
}
