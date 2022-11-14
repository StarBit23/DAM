import java.util.Random;

public class Actividad4 {
    public static void main(String[] args) {
        Thread hiloRandom = new Thread(new Runnable() {
            @Override
            public void run() {
                Random nRandom = new Random();
                NumeroSecreto.random = nRandom.nextInt(100);
                System.out.println("NUMERO A ADIVINAR: "+NumeroSecreto.random);
            }
        });

        hiloRandom.start();

        //creo todos los hilos
        Thread[] hilos = new Thread[10];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Hilo("H" + (i + 1)));
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
        static int finnish;
        public synchronized static int propuestaNumero(){
            if (finnish==1){
                return -1;
            }
            return 0;
        }

    }

    class Hilo implements Runnable{
        private String nombre;
        int code;
        public Hilo(String nombre){
            this.nombre = nombre;
        }

        @Override
        public void run() {
            Random rndm = new Random();
            int randomHilo;
            while (code==0){
                randomHilo = rndm.nextInt(100);
                System.out.println("Soy el hilo "+nombre+", mi numero es "+randomHilo);
                if (randomHilo==NumeroSecreto.random){
                    NumeroSecreto.finnish=1;
                    System.out.println("GANADOR: HILO "+nombre+", NUMERO "+randomHilo);
                }

                if (NumeroSecreto.propuestaNumero()==-1){
                    code=1;
                }
            }

        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }


