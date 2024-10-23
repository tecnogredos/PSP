/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo02;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class LanzarProcesosRuntime {
    
    private void ejecutar(String ruta) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec(ruta);
            
            int exitCode = p.waitFor();
            System.out.println("exitCode: " + exitCode);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LanzarProcesosRuntime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        //1. Probar de manera correcta
        String ruta1 =
                "C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe";
        //2. Probar exepción si no encuentra ejecutable (añado uns 's' a 'exe')
        String ruta2 =
                "C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exeS";
        //3. Probar excepción si el ejecutable no es válido
        String ruta3 =
                "C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\WebResources\\Resource0\\static\\js\\plugins\\aicuc\\images\\themeless_Reader\\img_calendars.png";
        //4. Probar si el no tiene permisos
        String ruta4 =
                "C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe";
        
        
        LanzarProcesosRuntime lpr = new LanzarProcesosRuntime();
        
        lpr.ejecutar(ruta1);
        System.out.println("Finalizado prueba Runtime !!!");
    }
}
