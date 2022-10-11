import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class tarea6 {
    public static void main(String[] args) throws IOException {

        File fichero = new File ("/home/manana/Escritorio/SEGUNDO/2.ProgramacionServiciosProcesos/1.MULTITAREA JAVA/fichero.txt");
        if(fichero.createNewFile()){
            System.out.println("fichero.txt se ha creado");
        }else System.out.println("fichero.txt ya existe");
        
        try 
        {
            Process p = Runtime.getRuntime().exec("ls -l > fichero.txt");

            
            //BUFFER READER / INPUT
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            

        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
    }

    
    

    
}
