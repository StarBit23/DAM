package ejercicio1;

public class Ejercicio1 {
    public static void main(String[] args) {
        Thread hilo = Thread.currentThread();
        System.out.println("¿Estoy vivo?: " + hilo.isAlive());
        System.out.println("¿Cuál es mi hilo actual?: " + hilo.currentThread());
        System.out.println("¿Qué id tengo como hilo?: " + hilo.getId());
        System.out.println("¿Cuál es mi nombre como hilo: " + hilo.getName());
        System.out.println("¿Cuál es mi estado como hilo?: " + hilo.getState());
    }
}
