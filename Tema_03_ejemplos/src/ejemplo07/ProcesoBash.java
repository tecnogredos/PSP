/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class ProcesoBash {

    public static void main(String[] args) {
        ProcesoBash pbash = new ProcesoBash();
        pbash.ejecutar();
    }

    private void ejecutar() {

        String comando = "cmd";

        ProcessBuilder pb = new ProcessBuilder(comando);
        //pb.command().add("/c");
		
        //pb.command().add("ping www.google.com");

        try {
            Process hijo = pb.start();

            //Leo lo que está en el stream del hijo
            final Scanner in = new Scanner(hijo.getInputStream());
            new Thread() {
                @Override
                public void run() {
                    while(in.hasNextLine()) {
                        System.out.println(in.nextLine());
                    }
                }
            }.start();
            
            //Envío comandos al hijo
            //Obtenemos la salida del hijo
            PrintWriter salida = new PrintWriter(hijo.getOutputStream());
            for(int i = 0; i < 10; i++) {
                salida.println("echo hola " + 0);
                salida.flush();
            }
            salida.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ProcesoBash.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
