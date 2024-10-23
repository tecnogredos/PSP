/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t04.ejemplo03;

/**
 *
 * @author aWa
 */
public class BloqueSincronizado {
    public static void main(String[] args) {
        RecurosJardin jardin = new RecurosJardin();
        
        for(int i = 1; i <= 10; i++) {
            EntraJardin ej = new EntraJardin("Entra " + i, jardin);
            ej.start();
        }
        for(int j = 1; j <= 15; j++) {
            SaleJardin sj = new SaleJardin("Sale " + j, jardin);
            sj.start();
        }
    }
}
