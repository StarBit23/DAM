package traspasoConBloqueoDeposito;
//main
public class TraspasoConBloqueo {
    public static void main(String[] args) {
        Deposito d1 = new Deposito("001", 20500);
        System.out.println("Cantidad d1: " + d1.getCantidad() + " litros");

        Deposito d2  = new Deposito("002", 50000);
        System.out.println("Cantidad d2: " + d2.getCantidad() + " litros");

        Thread h1 = new Thread(new Hilo(d1, d2, "Jorge Ortega"));
        Thread h2 = new Thread(new Hilo(d2, d1, "Ortega Jorge"));
        System.out.println("Prepárate para el bloqueo de los dos hilos");
        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
            System.out.println("No podrás ver este mensaje debido al bloqueo, te aguantas");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//ejecutar hilos
class Hilo implements Runnable{
    private Deposito d1;
    private Deposito d2;
    private String nombre;

    public Hilo(Deposito d1, Deposito d2, String nombre) {
        this.d1 = d1;
        this.d2 = d2;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            Transferencia.transferencia(d1, d2, 10);
        }
    }
}

//hacemos la transferencia
class Transferencia {
    public static boolean transferencia (Deposito d1, Deposito d2, double cantidad) {
        if (cantidad > d1.getCantidad())
            return false;
        else {
            synchronized (d1){
                d1.sacarCantidad(cantidad);
                synchronized (d2){
                    d2.ingresarCantidad(cantidad);
                }
            }
            return true;
        }
    }
}

//recurso compartido
class Deposito {
    private String numeroDeposito;
    private int cantidad;

    public Deposito(String numeroDeposito, int cantidad){
        this.numeroDeposito = numeroDeposito;
        this.cantidad = cantidad;
    }

    public String getNumeroCuenta() {
        return numeroDeposito;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void ingresarCantidad(double cantidad){
        this.cantidad += cantidad;
    }

    public void sacarCantidad(double cantidad){
        this.cantidad -= cantidad;
    }

    @Override
    public String toString() {
        return String.format("Número de deposito: %s\nCantidad: %d€", numeroDeposito, cantidad);
    }
}


