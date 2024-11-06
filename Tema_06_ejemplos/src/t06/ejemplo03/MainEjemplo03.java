package t06.ejemplo03;

/**
 * Ejemplo de uso de semaforo
 *
 */
public class MainEjemplo03 {
    public static void main(String[] args) {
        Secuencia secuencia = new Secuencia();
        
        for(int i = 0; i < 100; i++) {
            Thread hilo1 = new Thread(new Hilo(i, secuencia));
            hilo1.start();
        }
    }
}
