public class Reloj {
    public static void main(String[] args) {
        TicTacTener ticTacTener = new TicTacTener();

        HiloTic hiloTic1 = new HiloTic(ticTacTener);
        HiloTac hiloTac2 = new HiloTac(ticTacTener);
        
        Thread hiloTic = new Thread(hiloTic1);
        Thread hiloTac = new Thread(hiloTac2);

        hiloTic.start();
        hiloTac.start();
    }
}

class TicTacTener {
    private String estado;
    
    public TicTacTener() {
        estado = "";
    }

    public synchronized void Tic(boolean corriendo) throws InterruptedException {
        if (corriendo) {
            estado = "ticmarcado";
            System.out.print("Tic");
            notify();
            while (estado!="tacmarcado") {
                wait();
            }
        }
        if (!corriendo) {
            notify();
            return;
        }
        
    }

    public synchronized void Tac(boolean corriendo) throws InterruptedException {
        if (corriendo) {
            estado = "tacmarcado";
            System.out.println("Tac\n");
            notify();
            while (estado!="ticmarcado") {
                wait();
            }
        }
        if (!corriendo) {
            return;
        }
    }
}


class HiloTic implements Runnable {
    private TicTacTener ticTacTener;

    public HiloTic(TicTacTener ticTacTener) {
        this.ticTacTener = ticTacTener;
    }

    public void run() {
        try {
            for (int contador = 0; contador < 5; contador++) {
                ticTacTener.Tic(true);
                Thread.sleep(500);
            }
            ticTacTener.Tic(false);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class HiloTac implements Runnable {
    private TicTacTener ticTacTener;

    public HiloTac(TicTacTener ticTacTener) {
        this.ticTacTener = ticTacTener;
    }

    public void run() {
        try {
            for (int contador = 0; contador < 5; contador++) {
                ticTacTener.Tac(true);
                Thread.sleep(2000);
            }
            ticTacTener.Tac(false);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
