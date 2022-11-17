public class Actividad1Hilos{
     public static void main(String[] args) {
        Thread actual = Thread.currentThread();
        System.out.println("¿Estaré vivo? "+actual.isAlive());
        System.out.println("¿Cual es mi hilo actual?: "+actual.currentThread());
        System.out.println("¿Que id tengo?" + actual.getId());
        System.out.println("¿Cual es mi nombre? "+actual.getName());
        System.out.println("¿Cual es mi estado? "+actual.getState());
        
    }
    
}