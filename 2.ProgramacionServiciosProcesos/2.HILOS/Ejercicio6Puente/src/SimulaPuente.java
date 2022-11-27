import java.util.Random;

public class SimulaPuente {
    public static void main(String[] args) {
        Puente puente = new Puente();
        int pesoMin = 800;
        int pesoMax = 1500;
        int tiempoLlegadaMinimo = 1;
        int tiempoLlegadaMax = 30;
        int tiempoMinPasar = 20;
        int tiempoMaxPasar = 30;

        //int contador = 0;

        while (true){
            int peso = (int) Math.round(Math.random()*(pesoMax-pesoMin)+pesoMin);
            long tiempoPasar = Math.round(Math.random()*(tiempoMaxPasar-tiempoMinPasar)+tiempoMinPasar);

            Coche coche = new Coche(peso,puente,tiempoPasar);

            try {
                int tiempoLlegadaPuente = (int) Math.round(Math.random()*(tiempoLlegadaMax-tiempoLlegadaMinimo)+tiempoLlegadaMinimo);
                Thread.sleep(tiempoLlegadaPuente);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            coche.start();
            if (puente.getCochesPasando() == 1){
                System.out.println("Hay " +puente.getCochesPasando()+ " coche en el puente");
            }else if (puente.getCochesPasando() != 0 && puente.getCochesPasando()>1){
                System.out.println("Hay " +puente.getCochesPasando()+ " coches en el puente");
            }

            //contador++;
        }
    }
}
