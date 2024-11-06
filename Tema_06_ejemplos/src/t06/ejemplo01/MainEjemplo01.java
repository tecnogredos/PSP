package t06.ejemplo01;

/**
 * Ejemplo de uso del modificador synchronized a nivel de método
 *
 */
public class MainEjemplo01 {

    public static void main(String[] args) {

        //Objeto timbre donde solo existe uno para anunciar que 
        //alguien quiere entrar.
        //Solamente un visitante puede tocar el timbre, es decir,
        //dos visitantes no podrían activar el timbre a la vez
        Timbre timbre = new Timbre();

        //Construimos 3 hilos que represntan las visitas que llegan
        Thread visita1 = new Thread(new Visitante(timbre));
        Thread visita2 = new Thread(new Visitante(timbre));
        Thread visita3 = new Thread(new Visitante(timbre));

        //Las visitan están en la puerta y quieren entrar
        //comienza la carrera para tocar el timbre
        visita1.start();
        visita2.start();
        visita3.start();
    }

}
