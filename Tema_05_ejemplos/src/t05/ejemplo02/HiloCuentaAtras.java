/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t05.ejemplo02;

/**
 *
 * @author aWa
 */
public class HiloCuentaAtras implements Runnable {
    private int cuenta = 10;
    private int id = 0;
    
    public HiloCuentaAtras(int c) {
        this.cuenta = c;
        this.id = (int)(Math.random() * 101); // 0 to 100
    }
    @Override
    public void run() {
        while(this.cuenta > 0) {
            System.out.println("#" + id + "# valor (" + this.cuenta + ") " +
                    " Hilo en ejecucion: " + Thread.currentThread().getName());
            this.cuenta = this.cuenta - 1;
        }
    }
    
}
