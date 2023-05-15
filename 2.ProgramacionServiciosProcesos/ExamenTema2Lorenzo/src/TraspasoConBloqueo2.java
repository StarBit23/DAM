public class TraspasoConBloqueo2 {
    public static void main(String[] args) {
        Deposito d1 = new Deposito("001", cantidadAleatoria(500, 5000));
        Deposito d2 = new Deposito("002", cantidadAleatoria(500, 5000));
        System.out.println(d1);
        System.out.println(d2);

        Hilo h1 = new Hilo("Jorge Ortega", d1, d2);
        Hilo h2 = new Hilo("Ortega Jorge", d2, d1);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(d1);
        System.out.println(d2);
    }

    public static int cantidadAleatoria(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

class Deposito {
    private String numeroDeposito;
    private double cantidad;

    public Deposito(String numeroDeposito, double cantidad) {
        this.numeroDeposito = numeroDeposito;
        this.cantidad = cantidad;
    }

    public synchronized double getCantidadTotal() {
        return cantidad;
    }

    public synchronized void traspasaCantidad(double cantidad) {
        this.cantidad += cantidad;
    }

    public synchronized double sacarCantidad(double cantidad) {
        if (cantidad <= this.cantidad) {
            this.cantidad -= cantidad;
            return cantidad;
        }
        return 0;
    }

    public String getNumeroDeposito() {
        return numeroDeposito;
    }

    public String toString() {
        return "Deposito " + numeroDeposito + ": " + cantidad + " litros.";
    }
}

class Traspaso {
    private Deposito d1;
    private Deposito d2;

    public Traspaso(Deposito d1, Deposito d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    public static boolean traspasoCantidad(Deposito d1, Deposito d2, double cantidad) {
        synchronized(d1) {
            double cantidadSacada = d1.sacarCantidad(cantidad);
            synchronized(d2) {
                d2.traspasaCantidad(cantidadSacada);
                return true;
            }
        }
    }
}

class Hilo implements Runnable {
    private String nombre;
    private Deposito d1;
    private Deposito d2;

    public Hilo(String nombre, Deposito d1, Deposito d2) {
        this.nombre = nombre;
        this.d1 = d1;
        this.d2 = d2;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            Traspaso.traspasoCantidad(d1, d2, 50);
        }
    }
}