public class Semaforo {
    public static void main(String[] args) {
        ControlSemaforo controlSemaforo = new ControlSemaforo();
        
        Coche coche1 = new Coche("Coche 1", controlSemaforo);
        Coche coche2 = new Coche("Coche 2", controlSemaforo);
        
        Thread hiloCoche1 = new Thread(coche1);
        Thread hiloCoche2 = new Thread(coche2);
        
        hiloCoche1.start();
        hiloCoche2.start();
        
        Thread hiloRojo = new Thread(() -> {
            try {
                while (true) {
                    controlSemaforo.cambiarSemaforo(false);
                    Thread.sleep(5000); // Cambiar a rojo cada 5 segundos
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        hiloRojo.start();
        
        Thread hiloVerde = new Thread(() -> {
            try {
                while (true) {
                    controlSemaforo.cambiarSemaforo(true);
                    Thread.sleep(3000); // Cambiar a verde cada 3 segundos
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        hiloVerde.start();
    }
}

class ControlSemaforo {
    private boolean verde;
    
    public ControlSemaforo() {
        this.verde = false;
    }
    
    public synchronized void pasar() throws InterruptedException {
        while (!verde) {
            System.out.println("Bloqueo: Semáforo en rojo, esperando para pasar");
            wait();
        }
    }
    
    public synchronized void cambiarSemaforo(boolean estado) {
        if (verde != estado) {
            verde = estado;
            if (verde) {
                System.out.println("Semáforo cambiado a VERDE");
            } else {
                System.out.println("Semáforo cambiado a ROJO");
            }
            notifyAll();
        }
    }
}

class Coche implements Runnable {
    private String nombre;
    private ControlSemaforo controlSemaforo;
    
    public Coche(String nombre, ControlSemaforo controlSemaforo) {
        this.nombre = nombre;
        this.controlSemaforo = controlSemaforo;
    }
    
    public void run() {
        try {
            while (true) {
                // Coche se acerca al cruce
                System.out.println(nombre + " se acerca al cruce");
                
                // Esperar a que el semáforo esté en verde para pasar
                controlSemaforo.pasar();
                
                // Pasar por el cruce
                System.out.println(nombre + " pasa por el cruce");
                Thread.sleep(2000); // Tiempo de paso
                
                // Coche se aleja del cruce
                System.out.println(nombre + " se aleja del cruce");
                
                Thread.sleep(2000); // Tiempo de espera entre pasadas
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
