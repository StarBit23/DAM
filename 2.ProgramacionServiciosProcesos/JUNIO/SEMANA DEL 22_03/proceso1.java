import java.io.BufferedReader;
import java.io.InputStreamReader;

public class proceso1 {
    public void ejecutarProceso(String file){
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder().command("cat", file);
            Process proceso = pb.start();
            System.out.println("Soy el proceso padre y crearé el cat");
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea=br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        String fichero="/tmp/msg";
        proceso1 p = new proceso1();
        p.ejecutarProceso(fichero);
        System.out.println("Finalizado");
    }
}
