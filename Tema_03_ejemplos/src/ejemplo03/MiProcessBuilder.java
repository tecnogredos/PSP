/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class MiProcessBuilder {
    
    public static void main(String[] args) {
        MiProcessBuilder mpb = new MiProcessBuilder();
        mpb.ejecutar();
    }
    
    private void ejecutar() {
        
        try {
            //String[] command2 = {"cmd.exe", "/c", "start"};
            String[] command = {"cmd"};
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.command().add("/c");
            pb.command().add("start");
            pb.command().add("dir");
            //Directorio de trabajo
            //=== 1. Establecemos el directorio nosotros
            //pb.directory(new File("C:\\Users\\Public"));
            //=== 2. Utilizamos las variables de entorno
            /*
            Map<String, String> env = pb.environment();
            for (var entry : env.entrySet()) {
                System.out.println("key: " + entry.getKey() + " valor: " + entry.getValue());
            }
            pb.directory(new File(env.get("TMP")));
            */
            //=== 2.1. Utilizamos las variables de entorno
            //=== Establecemos nuestra variable
            Map<String, String> env = pb.environment();
            env.put("mi_directorio", "test");
            for (var entry : env.entrySet()) {
                System.out.println("key: " + entry.getKey() + " valor: " + entry.getValue());
            }
            pb.directory(new File(env.get("mi_directorio")));
            
            /*
            2.2.2 Acceso al proceso una vez en ejecución
            Los métodos de la clase Process pueden ser usados para realizar 
            operaciones de E/S desde el proceso, para comprobar su estado, 
            su valor de retorno, para esperar a que termine de ejecutarse y 
            para forzar la terminación del proceso. Sin embargo estos métodos 
            no funcionan sobre procesos especiales del SO como pueden ser 
            servicios, shell scripts, demonios, etc.
            https://psp2dam.github.io/psp_pages/es/unit2/processbuilder.html
            */
           
            
            
            Process p = pb.start();
            
            //Thread.sleep(3000);
            boolean waitFor = p.waitFor(3, TimeUnit.SECONDS);
            System.out.println("Fin!");
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MiProcessBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
