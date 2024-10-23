/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t04.ejemplo02;

/**
 *
 * @author aWa
 */
public class MultiplesHilos {
    
    public static void main(String[] args) {
        HiloSaluda hs1 = new HiloSaluda("Hilo 1", (int)(Math.random()*2000));
        HiloSaluda hs2 = new HiloSaluda("Hilo 2", (int)(Math.random()*2000));
        HiloSaluda hs3 = new HiloSaluda("Hilo 3", (int)(Math.random()*2000));
        
        hs1.start();
        hs2.start();
        hs3.start();
    }
}
