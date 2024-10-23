/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo06;


/**
 *
 * @author aWa
 */
public class ProcesoHijo2 {
   public int sumar(int inicio, int fin) {
        int total = 0;
        for(int i = inicio; i <= fin; i++) {
            System.out.println("total: " + total + " valor a sumar: " + i);
            total = total + i;
        }
        return total;
    }
    public static void main(String[] args) {
        int nInicio,nFin;
        
        if(args.length == 0 || args.length > 2) {
            nInicio = Integer.parseInt("0");
            nFin    = Integer.parseInt("0");
        } else {
            nInicio = Integer.parseInt(args[0]);
            nFin    = Integer.parseInt(args[1]);
        }
        
        ProcesoHijo2 ph = new ProcesoHijo2();
        int resultado = ph.sumar(nInicio, nFin);
        
        System.out.println("v2 - Resultado version 2: " + resultado);
    } 
}
