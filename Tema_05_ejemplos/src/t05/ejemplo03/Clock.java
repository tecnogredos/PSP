
package t05.ejemplo03;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://codegym.cc/es/quests/lectures/es.questmultithreading.level05.lecture06
 * @author aWa
 */
public class Clock implements Runnable {

    @Override
    public void run() {
        try {
            Thread hiloactual = Thread.currentThread();
            while (!hiloactual.isInterrupted()) {
                Thread.sleep(1000);
                System.out.println("Tick!");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
