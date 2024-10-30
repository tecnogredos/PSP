package t05.ejemplo01;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://codegym.cc/es/groups/posts/es.250.una-explicacion-de-las-expresiones-lambda-en-java-con-ejemplos-y-tareas-parte-1
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach6
 * @author aWa
 */
public class CrearHiloUsandoLambda {
    public static void main(String[] args) {
        //(parameters) -> {method body}
        Runnable runnable = () -> {System.out.println("Hola desde el hilo creado con Lambda ");};
        Thread hilo = new Thread( runnable);
        hilo.start();
        
    }
}
