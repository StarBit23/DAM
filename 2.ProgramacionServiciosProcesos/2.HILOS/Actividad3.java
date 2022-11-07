import java.util.Random;

//hilo1
class hilo1 implements Runnable {
    private final String nombre;

    hilo1(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.printf("Hola soy el hilo %s\n", this.nombre);
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            int pausa = 10 + r.nextInt(500 - 10);
            System.out.printf("Hilo: %s , hace una pausa de %d milisegundos hilo 1\n", this.nombre, pausa);
            try {
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                System.out.printf("Hilo %s interrumpido \n,", this.nombre);
            }
        }
        System.out.printf("Hilo %s terminado \n", this.nombre);
    }
}

//hilo2
class hilo2 implements Runnable {
    private final String nombre;

    hilo2(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.printf("Hola soy el hilo %s\n", this.nombre);
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            int pausa = 10 + r.nextInt(500 - 10);
            System.out.printf("Hilo: %s , hace una pausa de %d milisegundos, hilo 2\n", this.nombre, pausa);
            try {
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                System.out.printf("Hilo %s interrumpido \n,", this.nombre);
            }
        }
        System.out.printf("Hilo %s terminado \n", this.nombre);
    }
}

public class Actividad3 {
    public static void main(String[] args) {
        int c1 = 0;
        Thread[] hilos = new Thread[4];

        String n1 , n2;

        for (int i = 0; i < 4; i++) {
            int rnd = (int) Math.round(Math.random()*1);
            if (rnd == 1){
                c1++;
                n1="H"+c1;
                Thread h1 = new Thread(new hilo1(n1));
                h1.start();

                try {
                    h1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else {
                c1++;
                n2 = "H"+c1;
                Thread h2 = new Thread(new hilo2(n2));
                h2.start();

                try {
                    h2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Hilo principal terminado.");
    }
}
