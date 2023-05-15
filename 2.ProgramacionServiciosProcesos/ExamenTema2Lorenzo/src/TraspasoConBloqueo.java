
public class TraspasoConBloqueo {
    public static void main(String[] args) {
        Deposito d1 = new Deposito(4000);
        Deposito d2 = new Deposito(4000);

        Traspaso hilo1 = new Traspaso(d1, d2, 100);
        Traspaso hilo2 = new Traspaso(d2, d1, 200);

        Thread thread1 = new Thread(hilo1);
        Thread thread2 = new Thread(hilo2);

        thread1.setName("001");
        thread2.setName("002");

        thread1.start();
        thread2.start();
    }
}

class Traspaso implements Runnable {
    private Deposito origen;
    private Deposito destino;
    private int cantidad;

    public Traspaso(Deposito origen, Deposito destino, int cantidad) {
        this.origen = origen;
        this.destino = destino;
        this.cantidad = cantidad;
    }

    public void run() {
        while (cantidad > 0){
            try {
                origen.traspasaCantidad(cantidad, destino);
                System.out.println(Thread.currentThread().getName() + " transfiriendo " + cantidad + " al " + destino);
                cantidad = 0;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Hilo " + Thread.currentThread() + " interrumpido");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Hilo " + Thread.currentThread() + " interrumpido");
            }
            
        }
        if (cantidad == 0) {
            System.out.println("La transferencia entre depositos ha finalizado: " + Thread.currentThread().getName());
        }
    }


}

class Deposito {
    private int cantidad;

    public Deposito(int cantidadInicial) {
        this.cantidad = cantidadInicial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public synchronized void traspasaCantidad(int cantidadTraspasar, Deposito destino) throws InterruptedException {
        while (cantidadTraspasar > cantidad) {
            System.out.println(Thread.currentThread().getName() + " esperando cantidad suficiente para traspasar " + cantidadTraspasar + " al " + destino);
            wait();
        }
        cantidad -= cantidadTraspasar;
        destino.agregaCantidad(cantidadTraspasar);
        System.out.println(Thread.currentThread().getName() + " transfiriendo " + cantidadTraspasar + " al " + destino);
        notifyAll();
    }

    public synchronized void agregaCantidad(int cantidadAgregar) {
        cantidad += cantidadAgregar;
        notifyAll();
    }
}
