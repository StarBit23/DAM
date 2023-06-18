import java.util.Random;

public class HilosAdivinarNumero {

    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(1000 - 0 + 1) + 0;

        //genero 5 hilos
        HiloAdivinar[] hilos = new HiloAdivinar[5];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloAdivinar("Hilo-" + (i + 1), randomNumber);
            hilos[i].start();
        }

        //les hago un join para que no se superpongan
        for (HiloAdivinar thread : hilos) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //aqui creo los hilos que deben adivinar el número
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

        //metodo que genera el numero aleatorio para que sea el mismo para todos los hilos
        private int numeroAleatorio() {
            Random random = new Random();
            return random.nextInt(1000 - 0 + 1) + 0;
        }
    }
}

