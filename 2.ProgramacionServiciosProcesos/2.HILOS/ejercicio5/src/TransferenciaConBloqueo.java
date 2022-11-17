//main
public class TransferenciaConBloqueo {
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta("ES388388433883838388484", 20500);
        System.out.println("Saldo c1: " + c1.getSaldo() + "€");
        Cuenta c2  = new Cuenta("ES99090499388484889399", 50000);
        System.out.println("Saldo c2: " + c2.getSaldo() + "€");
        Thread h1 = new Thread(new Hilo(c1, c2, "Jorge Ortega"));
        Thread h2 = new Thread(new Hilo(c2, c1, "Ortega Jorge"));
        System.out.println("Prepárate para el bloqueo de los dos hilos");
        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
            System.out.println("No podrás ver este mensaje, te chinchas >:)");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//ejecutar hilos
class Hilo implements Runnable{
    private Cuenta c1;
    private Cuenta c2;
    private String nombre;

    public Hilo(Cuenta c1, Cuenta c2, String nombre) {
        this.c1 = c1;
        this.c2 = c2;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            Transferencia.transferencia(c1, c2, 10);
        }
    }
}

//hacemos la transferencia
class Transferencia {
    public static boolean transferencia (Cuenta c1, Cuenta c2, double cantidad) {
        if (cantidad > c1.getSaldo())
            return false;
        else {
            synchronized (c1){
                c1.sacarCantidad(cantidad);
                synchronized (c2){
                    c2.ingresarCantidad(cantidad);
                }
            }
            return true;
        }
    }
}

//recurso compartido
class Cuenta {
    private String numeroCuenta;
    private int saldo;

    public Cuenta(String numeroCuenta, int saldo){
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public double ingresarCantidad(double cantidad){
        return saldo+cantidad;
    }

    public double sacarCantidad(double cantidad){
        return saldo-cantidad;
    }

    @Override
    public String toString() {
        return String.format("Número de cuenta: %s\nSaldo: %d€", numeroCuenta, saldo);
    }
}






