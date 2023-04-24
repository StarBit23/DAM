public class ProcessDemo2 {
    public static void main(String[] args) {
    try {
        //creo nuevo proceso
        System.out.println("Creando proceso...");
        Process p = Runtime.getRuntime().exec("notepad.exe");

        //espero 10 segundos
        System.out.println("Esperando...");
        Thread.sleep(10000);

        //destruimos el proceso
        p.destroy();
        System.out.println("Proceso destruido");

    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }
    
}
