/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo04;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class MiProcessTerminarTeclado {
    
    public static void main(String[] args) {
        MiProcessTerminarTeclado mpb2 = new MiProcessTerminarTeclado();
        
        mpb2.ejecutar();
    }
    
    private void ejecutar() {
        try {
            //String command = "cmd";
            String ruta = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            
            ProcessBuilder pb = new ProcessBuilder(ruta);
                       
            
            System.out.println("Terminar proceso ? (S/N)");
            Scanner teclado = new Scanner(System.in);
            
            Process p = pb.start();
            
            if(teclado.nextLine().toUpperCase().charAt(0) == 'S') {
                p.waitFor(3, TimeUnit.SECONDS);
                p.destroy();
                //p.onExit().defaultExecutor().execute(() -> System.out.println("Fin proceso 1"));
                System.out.println("destruir ....");
            }
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MiProcessTerminarTeclado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
