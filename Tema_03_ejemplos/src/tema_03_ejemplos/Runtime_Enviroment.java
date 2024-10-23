/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema_03_ejemplos;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class Runtime_Enviroment {

    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("notepad.exe");

            Map<String, String> env = System.getenv();
            for (var e : env.entrySet()) {
                System.out.println(e.getKey() + " " + e.getValue());
            }

            System.out.println(p.isAlive());

            int estado = p.waitFor();

            System.out.println("Estado del proceso: " + estado);

            p.destroy();

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Runtime_Enviroment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end main

}
