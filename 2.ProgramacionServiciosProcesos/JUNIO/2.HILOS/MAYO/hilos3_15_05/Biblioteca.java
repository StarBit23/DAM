import java.util.Random;

public class Biblioteca {
        public static void main(String[] args) {
            Estanteria estanteria = new Estanteria();
            
            BibliotecarioPrestamo bibliotecarioPrestamo = new BibliotecarioPrestamo(estanteria);
            BibliotecarioRecepcion bibliotecarioRecepcion = new BibliotecarioRecepcion(estanteria);
            
            Thread hiloPrestamo = new Thread(bibliotecarioPrestamo);
            Thread hiloRecepcion = new Thread(bibliotecarioRecepcion);
            
            hiloPrestamo.start();
            hiloRecepcion.start();
        }
    }

class Estanteria {
    private int libros;
    
    public Estanteria() {
        this.libros = 0;
    }

    public synchronized void prestarLibros(String bibliotecario) throws InterruptedException {
        Random random = new Random();
        int numLibrosPrestar = random.nextInt(3) + 1;  // Número aleatorio entre 1 y 3
        
        while (libros < numLibrosPrestar) {
            System.out.println("Bloqueo: No hay suficientes libros en la estantería para prestar");
            wait();
        }
        
        libros -= numLibrosPrestar;
        System.out.println(bibliotecario + " prestó " + numLibrosPrestar + " libros");
        
        notifyAll();
    }
    
    public synchronized void recibirLibros(String bibliotecario) throws InterruptedException {
        Random random = new Random();
        int numLibrosRecibir = random.nextInt(3) + 1;  // Número aleatorio entre 1 y 3
        
        while (libros + numLibrosRecibir > 15) {
            System.out.println("Bloqueo: La estantería está llena, no se pueden recibir más libros");
            wait();
        }
        
        libros += numLibrosRecibir;
        System.out.println(bibliotecario + " recibió " + numLibrosRecibir + " libros");
        
        notifyAll();
    }
}

class BibliotecarioPrestamo implements Runnable {
    private Estanteria estanteria;
    
    public BibliotecarioPrestamo(Estanteria estanteria) {
        this.estanteria = estanteria;
    }
    
    public void run() {
        try {
            while (true) {
                estanteria.prestarLibros("Luis Manuel García");
                Thread.sleep(2000);  // Tiempo de espera para apreciar la operación
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class BibliotecarioRecepcion implements Runnable {
    private Estanteria estanteria;
    
    public BibliotecarioRecepcion(Estanteria estanteria) {
        this.estanteria = estanteria;
    }
    
    public void run() {
        try {
            while (true) {
                estanteria.recibirLibros("Pepe Perez");
                Thread.sleep(2000);  // Tiempo de espera para apreciar la operación
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


