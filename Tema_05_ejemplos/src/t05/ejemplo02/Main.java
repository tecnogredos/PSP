/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t05.ejemplo02;

/**
 *
 * @author aWa
 */
public class Main {
    public static void main(String[] args) {
        
        
        HiloCuentaAtras hca1 = new HiloCuentaAtras(10);
        HiloCuentaAtras hca2 = new HiloCuentaAtras(10);
        
        //Llamando a la función run()
        System.out.println("--Empiezo--");
        hca1.run();
        System.out.println("--Ejecuto el siguiente--");
        hca2.run();
        
        //Llamando a la función start()
        Thread uno = new Thread(new HiloCuentaAtras(10));
        Thread dos = new Thread(new HiloCuentaAtras(10));
                            
        System.out.println("--Empiezo--");
        uno.start();
        //Llamo a un hilo que ya está en ejecucion // uno.start();
        System.out.println("--Ejecuto el siguiente--");
        dos.start();
        
    }
   
}
