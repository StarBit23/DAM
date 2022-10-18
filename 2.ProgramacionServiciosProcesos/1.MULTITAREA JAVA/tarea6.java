import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class tarea6 {
    public static void main(String[] args) throws IOException {
        

        try {
            File fichero = new File("/home/manana/fichero.txt");
            if (fichero.createNewFile()) {
                System.out.println("fichero.txt se ha creado");
            } else {
                System.out.println("el fichero ya existe");
            }
            
            Process p = Runtime.getRuntime().exec("ls -l");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            FileWriter fw = new FileWriter(fichero);
            String linea;
        
            while((linea=br.readLine()) != null){
                System.out.println(linea);         
                fw.write(linea);
           }
           fw.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}