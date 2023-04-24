import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FiltraLineasVersion2 {
    public static void main(String[] args) {
        String stringBuscar = args[0];
        ProcessBuilder pb = new ProcessBuilder("grep", stringBuscar);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            String line = "";
            int contador=0;
            System.out.println("Introducir línea: ");

         while ((((line = br.readLine()) != null) && (line.length() != 0)) || contador<6){
            if (line == null || line.isEmpty() || contador==6) {
                //Si se ha introducido línea vacía o se ha alcanzado el límite de 6 líneas salir del bucle
                break;
            }
             Process p = pb.start();

             OutputStream os = p.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");

             osw.write(line);
             osw.close();
            try {
                int codRetorno = p.waitFor();
                InputStream is = p.getInputStream();
                BufferedReader br2 = new BufferedReader(new InputStreamReader(is));
                String leer;
                while ( (leer=br2.readLine()) != null){
                    System.out.println(leer);
                }

               System.out.println("Soy el proceso padre y ha muerto el grep " + 
                   (codRetorno == 0 ? "(coincidencia: SI)\n" : "(coincidencia: NO)\n")
               );
            }catch ( InterruptedException ex) {
                    System.out.println("Se ha interrumpido el subproceso.\n");
                }
                System.out.println("Introducir línea");
                contador++;
                line = "";
         }

        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida");
            e.printStackTrace();
        }
        
    }
}

