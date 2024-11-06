package t06.ejemplo01;

/**
 * Clase representativa de un visitante que usará el timbre
 * Implemnta Runnable
 */
public class Visitante implements Runnable{
    //Recurso que será utilizado. Debe ser final
    final Timbre timbre;
    
    public Visitante(Timbre t) {
        this.timbre = t;
    }

    @Override
    public void run() {
        //Usa el recurso compartido Timbre para hacerlo sonar 
        //y anunciar que el visitante ha llegado
        timbre.tocar();
    }
    
}
