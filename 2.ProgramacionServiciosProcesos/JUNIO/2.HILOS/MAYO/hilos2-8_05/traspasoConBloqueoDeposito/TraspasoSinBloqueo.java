//main
public class TraspasoSinBloqueo {
    public static void main(String[] args) {
        Deposito d1 = new Deposito("001", 5000);
        System.out.println("Deposito d1: " + d1.getCantidad() + "€");
        Deposito d2  = new Deposito("002", 5000);
        System.out.println("Deposito d2: " + d2.getCantidad() + "€");
        Thread h1 = new Thread(new Hilo(d1, d2, "Jorge Ortega"));
        Thread h2 = new Thread(new Hilo(d2, d1, "Ortega Jorge"));
        System.out.println("Prepárate para el bloqueo de los dos hilos");
        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
            System.out.println("¡¡Era broma, he solucionado el interbloqueo ejecutando los hilos en el orden que yo quiera!!");
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
            Traspaso.traspaso(d1, d2, 10);
        }
    }
}

//hacemos la transferencia
class Traspaso {
    public static boolean traspaso (Deposito d1, Deposito d2, double cantidad) {
        Deposito cuentaMenor, cuentaMayor;
        if (d1.getNombre().compareTo(d2.getNombre()) <0){
            cuentaMenor = d1;
            cuentaMayor = d2;
        }else {
            cuentaMenor = d2;
            cuentaMayor = d1;
        }
        synchronized (cuentaMenor){
            if (cuentaMenor.getCantidad() >= cantidad){
                cuentaMenor.sacarCantidad(cantidad);
                cuentaMayor.ingresarCantidad(cantidad);
                return true;
            }
            return false;
        }

    }
}

//recurso compartido
class Deposito {
    private String nombre;
    private int cantidad;

    public Deposito(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public double ingresarCantidad(double cantidad){
        return cantidad+=cantidad;
    }

    public double sacarCantidad(double cantidad){
        return cantidad-=cantidad;
    }

    @Override
    public String toString() {
        return String.format("Número de cuenta: %s\nSaldo: %d€", nombre, cantidad);
    }
}





