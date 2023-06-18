import java.util.Random;

public class HilosAdivinarNumero {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 1000;

    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;

        //genero 5 hilos
        HiloAdivinar[] hilos = new HiloAdivinar[5];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloAdivinar("Hilo-" + (i + 1), randomNumber);
            hilos[i].start();
        }

        //les hago un join para que no de errores
        for (HiloAdivinar thread : hilos) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class HiloAdivinar extends Thread {
        private final String nombreHilo;
        private final int randomNumber;

        public HiloAdivinar(String name, int randomNumber) {
            this.nombreHilo = name;
            this.randomNumber = randomNumber;
        }

        @Override
        public void run() {
            int intentos = 0;
            while (true) {
                int solucion = numeroAleatorio();
                intentos++;
                if (solucion == randomNumber) {
                    System.out.println(nombreHilo + " ha adivinado el número " + randomNumber + " después de " + intentos + " intentos.");
                    break;
                }
            }
        }

        //en u n método genero el numero aleatorio para que sea el mismo para todos los hilos
        private int numeroAleatorio() {
            Random random = new Random();
            return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        }
    }
}

