public class Coche extends Thread{
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

