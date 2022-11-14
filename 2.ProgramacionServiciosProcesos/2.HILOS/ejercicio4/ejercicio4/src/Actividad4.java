import java.util.Random;

public class Actividad4 {
    public static void main(String[] args) {
        Thread hiloRandom = new Thread(new Runnable() {
            @Override
            public void run() {
                Random nRandom = new Random();
                System.out.println("Genero un numero aleatorio");
                NumeroSecreto.random = nRandom.nextInt(100);
            }
        });

        hiloRandom.start();

        //creo todos los hilos
        Thread[] hilos = new Thread[10];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Hilo("H" + String.valueOf(i + 1)));
            hilos[i].start();
        }
        //join todos los hilos
        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

    }
}
    class NumeroSecreto{
        static int random;
        private static int finnish=0;
        public synchronized static int propuestaNumero(int randomm){
            if (finnish==1){
                return -1;
            }else if (randomm=random){
                //nada
            }
            return finnish;
        }
    }

    class Hilo implements Runnable{
        private String nombre;
        public Hilo(String nombre){
            this.nombre = nombre;
        }
        @Override
        public void run() {
            Random rndm = new Random();
            int randomHilo;
            int code=0;

            while (code==0){
                randomHilo = rndm.nextInt(100);
                System.out.println("Soy el hilo "+nombre);
                if (randomHilo==NumeroSecreto.random){
                    code=1;
                }
                if (NumeroSecreto.propuestaNumero()==-1){
                    code=1;
                }
            }

        }
    }


