public class ProcessDemo {
    public static void main(String[] args) {
        try {
            //creamos un proceso nuevo
            System.out.println("Creando proceso...");
            Process p = Runtime.getRuntime().exec("notepad.exe");

            //El proceso se detiene hasta que proceso p termine
            p.waitFor();

            //cuando cierras notepad.exe manualmente el programa continua aquí
            System.out.println("Se acabó esperar");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
