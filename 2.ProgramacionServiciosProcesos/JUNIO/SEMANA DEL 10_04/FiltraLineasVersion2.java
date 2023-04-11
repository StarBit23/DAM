import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FiltraLineasVersion2 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("grep");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            int contador=0;

         while (line != null) {
            System.out.print("Introducir línea: ");
            Process p = pb.start();
            contador++;

            OutputStream os = p.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");

            osw.write(line);
            osw.close();
            try {
                
            } catch (InterruptedException ex) {
                System.out.println("Proceso interrumpido");
            }
         }

        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida");
            e.printStackTrace();
        }
        
    }
}
