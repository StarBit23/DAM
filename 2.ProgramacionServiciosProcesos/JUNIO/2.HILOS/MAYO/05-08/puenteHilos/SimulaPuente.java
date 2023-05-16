package puenteHilos;

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

class Puente {
    private int cochesPasando = 0;
    private int pesoCochesPuente = 0;

    public int getCochesPasando(){
        return cochesPasando;
    }
    synchronized public boolean sePermitePaso(Coche coche){
        if (coche.peso+ pesoCochesPuente <=5000 && cochesPasando<3){
            cochesPasando++;
            pesoCochesPuente +=coche.peso;
            return true;
        } else return false;
    }
    synchronized public void finalizarPaso(Coche coche){
        cochesPasando--;
        pesoCochesPuente -=coche.peso;
    }
}

class Coche extends Thread{
    public int peso;
    final Puente puente;
    public long tiempo;

    public Coche(int peso, Puente puente, long tiempo) {
        this.peso = peso;
        this.puente = puente;
        this.tiempo = tiempo;
    }
    @Override
    public void run(){
        if (puente.sePermitePaso(this)){
            try {
                sleep(tiempo);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            puente.finalizarPaso(this);
            synchronized (this){
                notifyAll();
            }
        }
    }
}



