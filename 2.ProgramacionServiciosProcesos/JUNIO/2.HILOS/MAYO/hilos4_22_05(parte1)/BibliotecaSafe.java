import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BibliotecaSafe {
    public static void main(String[] args) {
        ControlLibro<Integer> recurso = new ControlLibro<Integer>();
        Bibliotecario<Integer> b1, b2;
        b1 = new Bibliotecario<Integer>("Pepe prestamista", false, recurso);
        b2 = new Bibliotecario<Integer>("Paco receptor", true, recurso);

        System.out.println("Voy a lanzar los bibliotecarios");
        b1.start();
        b2.start();
    }
}

class ControlLibro<T> {
    public static int MAX_LIBROS = 3;
    private List<T> libros = new ArrayList<>();
    private int numLibros = 0;

    public int getNumLibros() {
        return numLibros;
    }

    public boolean estanteriaVacia() {
        return (getNumLibros() == 0 ? true : false);
    }

    synchronized public void setNumLibros(int n) {
        numLibros = n;
    }

    synchronized public void decNumLibros() {
        numLibros--;
    }

    synchronized public void addNumLibros() {
        numLibros++;
    }

    synchronized public boolean librosDisponibles(int num) {
        return (getNumLibros() >= num ? true : false);
    }

    public T sacarLibro() throws InterruptedException {
        synchronized (this) {
            System.out.println("    Quiero sacar un libro.......");
            while (this.getNumLibros() == 0) {
                System.out.println("Me tengo que esperar a que haya libro para sacar!!!!!");
                this.wait();
            }
            T libro = libros.remove(0);
            this.decNumLibros();
            System.out.println("---> Se acaba de sacar un libro con ISBN " + libro + ". Hay " + getNumLibros() + " libros");
            this.notifyAll();
            return libro;
        }
    }

    public boolean devolverLibro(T libro) throws InterruptedException {
        synchronized (this) {
            System.out.println("    Quiero devolver un libro.......");
            while (this.getNumLibros() >= MAX_LIBROS) {
                System.out.println("Me tengo que esperar a que haya hueco para devolver mi libro!!!!!");
                this.wait();
            }
            this.libros.add(libro);
            this.addNumLibros();
            System.out.println("<-- Se acaba de devolver un libro con ISBN " + libro + ". Quedan " + getNumLibros() + " libros");
            this.notifyAll();
            return true;
        }
    }
}

class Bibliotecario<T> extends Thread {
    private ControlLibro<T> estanteria;
    public boolean soyReceptor;
    private String nombre;

    public Bibliotecario(String nombre, boolean soyReceptor, ControlLibro<T> estanteria) {
        this.estanteria = estanteria;
        this.soyReceptor = soyReceptor;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        Random r = new Random();
        T isbn;
        while (true) {
            if (soyReceptor) {
                isbn = (T) (Integer) r.nextInt(1000);  // Es un libro que se va a devolver
                try {
                    Thread.sleep(100 + r.nextInt(500 - 100 + 1));
                    estanteria.devolverLibro(isbn);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Me han devuelto un libro con ISBN " + isbn);

            } else {
                isbn = null;
                try {
                    Thread.sleep(100 + r.nextInt(500 - 100 + 1));
                    isbn = estanteria.sacarLibro();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Han sacado un libro con ISBN " + isbn);

            }
        }
    }
}


