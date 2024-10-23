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
public class EntraJardin extends Thread {

    private final RecurosJardin jardin;
    
    public EntraJardin(String n, RecurosJardin rj) {
        this.setName(n);
        this.jardin = rj;
    }
    @Override
    public void run() {
//synchronized (jardin) {        
        
            jardin.incrementa();
            
//}
    }
}
