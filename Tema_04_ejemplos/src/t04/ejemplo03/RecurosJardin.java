/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t04.ejemplo03;

/**
 *
 * @author aWa
 */
class RecurosJardin {
    private int cuenta = 0;
    public RecurosJardin() {
        this.cuenta = 100;
    }
    //public synchronized void incrementa() {
    public void incrementa() {
        System.out.println("Hilo " + Thread.currentThread().getName());
        this.cuenta = this.cuenta + 1;
        System.out.println(this.cuenta + " en el jardin " + Thread.currentThread().getName());
    }
    //public synchronized void decrementa() {
    public void decrementa() {
        System.out.println("Hilo " + Thread.currentThread().getName());
        this.cuenta = this.cuenta - 1;
        System.out.println(this.cuenta + " en el jardin " + Thread.currentThread().getName());
    }
}
