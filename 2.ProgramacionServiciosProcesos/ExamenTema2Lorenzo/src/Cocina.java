import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cocina {
    public static void main(String[] args) {
        List<Thread> cocineros = new ArrayList<>();
        AguaFria aguaFria = new AguaFria();
        AguaCaliente aguaCaliente = new AguaCaliente();

        for (int i = 0; i < 6; i++) {
            cocineros.add(new Thread(new Cocinero("C" + (i + 1), aguaCaliente, aguaFria)));
        }

        cocineros.forEach(Thread::start);

        cocineros.forEach(c -> {
            try {
                c.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.printf("En el deposito de agua caliente quedan %d cl de agua\n", aguaCaliente.getAgua());
        System.out.printf("En el deposito de agua fria quedan %d cl de agua\n", aguaFria.getAgua());
    }
}


class AguaFria {
    private int agua = 60000;

    /**
     * devuelve la cantidad de agua que queda en el deposito
     * @return cantidad de agua en cl
     */
    public int getAgua() {
        return agua;
    }

    /**
     *
     * @param cantidad la cantidad de agua que se desea sacar
     * @return true si queda agua suficiente para sacar
     */
    public synchronized boolean puedeSacar(int cantidad) {
        return agua + cantidad > 0;
    }

    /**
     * consulta si la cantidad de agua es mayor que 0
     * @return true si hay mas de 0 de agua
     */
    public synchronized boolean hayAgua() {
        return agua > 0;
    }

    /**
     * resta una cantidad de agua al deposito
     * @param cantidad la cantidad que se va a restar
     */
    public synchronized void sacarAgua(int cantidad) {
        agua -= cantidad;
    }

}


class AguaCaliente {
    private int agua = 30000;

    /**
     * devuelve la cantidad de agua que queda en el deposito
     * @return cantidad de agua en cl
     */
    public int getAgua() {
        return agua;
    }

    /**
     *
     * @param cantidad la cantidad de agua que se desea sacar
     * @return true si queda agua suficiente para sacar
     */
    public synchronized boolean puedeSacar(int cantidad) {
        return agua + cantidad > 0;
    }

    /**
     * consulta si la cantidad de agua es mayor que 0
     * @return true si hay mas de 0 de agua
     */
    public synchronized boolean hayAgua() {
        return agua > 0;
    }

    /**
     * resta una cantidad de agua al deposito
     * @param cantidad la cantidad que se va a restar
     */
    public synchronized void sacarAgua(int cantidad) {
        agua -= cantidad;
    }
}


class Cocinero implements Runnable {
    private String nombre;
    private AguaCaliente aguaCaliente;
    private AguaFria aguaFria;
    private int cantidadFria;
    private int cantidadCaliente;

    public Cocinero(String nombre, AguaCaliente aguaCaliente, AguaFria aguaFria) {
        this.nombre = nombre;
        this.aguaCaliente = aguaCaliente;
        this.aguaFria = aguaFria;
        this.cantidadFria = 0;
        this.cantidadCaliente = 0;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (aguaCaliente.hayAgua() || aguaFria.hayAgua()) {
            boolean caliente;
            if (!aguaCaliente.hayAgua()) {
                caliente = false;
            } else {
                caliente = rnd.nextBoolean();
            }


            if (caliente) {
                synchronized (aguaCaliente){
                    int cantidad = (int) Math.round((Math.random() * 1975) + 25);
                    int espera = (int) Math.round(Math.random() * 500);

                    while (!aguaCaliente.puedeSacar(cantidad)) {
                        try {
                            System.out.printf("El cocinero %s  esta esperando por agua caliente...\n", this.nombre);
                            aguaCaliente.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.printf("%s ya puede coger agua caliente\n", this.nombre);
                    }

                    try {
                        Thread.sleep(espera);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (aguaCaliente.getAgua() < cantidad) {
                        cantidad = aguaCaliente.getAgua();
                    }

                    aguaCaliente.sacarAgua(cantidad);
                    cantidadCaliente += cantidad;

                    System.out.printf("El cocinero %s ha sacado %d cl de agua caliente\n", this.nombre, cantidad);

                aguaCaliente.notify();
                }

            } else {
                synchronized (aguaFria){
                    int cantidad = (int) Math.round((Math.random() * 1975) + 25);
                    int espera = (int) Math.round(Math.random() * 500);

                    while (!aguaFria.puedeSacar(cantidad)) {
                        System.out.printf("El cocinero %s esta esperando por agua fria\n", this.nombre);
                        try {
                            aguaFria.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.printf("%s ya puede coger agua fria", this.nombre);
                    }

                    try {
                        Thread.sleep(espera);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                    if (aguaFria.getAgua() < cantidad) {
                        cantidad = aguaFria.getAgua();
                    }

                    aguaFria.sacarAgua(cantidad);

                    cantidadFria += cantidad;

                    System.out.printf("El cocinero %s ha sacado %d cl de agua fria\n", this.nombre, cantidad);
                    aguaFria.notifyAll();
                }
            }
        }
        System.out.printf("El cocinero %s ha sacado en total %d de agua fria y %d de agua caliente\n", this.nombre, this.cantidadFria, this.cantidadCaliente);
    }
}