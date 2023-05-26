import java.util.Random;

public class PingPong {
    public static void main(String[] args) {
        TicTacTener ticTacTener = new TicTacTener();

        HiloTic hiloTic1 = new HiloTic(ticTacTener);
        HiloTac hiloTac2 = new HiloTac(ticTacTener);

        Thread hiloTic = new Thread(hiloTic1);
        Thread hiloTac = new Thread(hiloTac2);

        hiloTic.start();
        hiloTac.start();

        try {
            // Esperar a que los hilos terminen su ejecución
            hiloTic.join();
            hiloTac.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tenemos ganador!");
        if (ticTacTener.getGanador()) {
            System.out.println("El ganador es Santi!");
        }else{
            System.out.println("El ganador es Gabriel!");
        }
        
    }
}

class TicTacTener {
    private String estado;
    private boolean terminar;
    private boolean finalGanador;

    public TicTacTener() {
        estado = "";
        terminar = false;
    }

    public synchronized void Tic(boolean corriendo) throws InterruptedException {
        if (terminar) {
            return;
        }

        if (corriendo) {
            estado = "ticmarcado";
            System.out.println("Zip (Santi)");
            notify();
            while (!estado.equals("tacmarcado")) {
                wait();
                if (terminar) {
                    return;
                }
            }
        }

        if (!corriendo) {
            terminar = true;
            notify();
            return;
        }
    }

    public synchronized void Tac(boolean corriendo) throws InterruptedException {
        if (terminar) {
            return;
        }

        if (corriendo) {
            estado = "tacmarcado";
            System.out.println("Zap (Gabriel)");
            notify();
            while (!estado.equals("ticmarcado")) {
                wait();
                if (terminar) {
                    return;
                }
            }
        }

        if (!corriendo) {
            terminar = true;
            notify();
            return;
        }
    }

    public boolean crearGanador() {
        Random random = new Random();
        int ganador = random.nextInt(10) + 1;
        if (ganador%2 == 0) {
            finalGanador=true;
            return true;
        }
        else{
            finalGanador=false;
           return false; 
        }
    }

    public boolean getGanador() {
        return finalGanador;
    }
}

class HiloTic implements Runnable {
    Random random = new Random();
    private TicTacTener ticTacTener;

    public HiloTic(TicTacTener ticTacTener) {
        this.ticTacTener = ticTacTener;
    }

    public void run() {
        
        try {
            for (int contador = 0; contador < 5; contador++) {
                ticTacTener.Tic(true);
                Thread.sleep(random.nextInt(2000) + 1);
            }
            ticTacTener.Tic(false);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class HiloTac implements Runnable {
    Random random = new Random();
    private TicTacTener ticTacTener;

    public HiloTac(TicTacTener ticTacTener) {
        this.ticTacTener = ticTacTener;
    }

    public void run() {
        int num=0;
        try {
            if (ticTacTener.getGanador()) {
                num=1;
            }
            for (int contador=num; contador < 5; contador++) {
                ticTacTener.Tac(true);
                Thread.sleep(random.nextInt(2000) + 1);
            }
            ticTacTener.Tac(false);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
