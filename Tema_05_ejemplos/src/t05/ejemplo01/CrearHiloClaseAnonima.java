/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t05.ejemplo01;

/**
 *
 * @author aWa
 */
public class CrearHiloClaseAnonima {
    public static  void main(String... args) {
        Runnable a = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hola desde el hilo creado con clase anonima! ");
            }
        };
        Thread hilo = new Thread(a);
        hilo.start();
                
           
    }
}
