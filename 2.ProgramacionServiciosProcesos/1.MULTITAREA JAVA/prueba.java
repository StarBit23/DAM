import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.swing.InputMap;

public class prueba {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("nslookup");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try{
            InputStreamReader iStreamReader = new InputStreamReader(System.in);
            BufferedReader bReader = new BufferedReader(iStreamReader);

            String linea;
            System.out.println("Introducir nombre del dominio");
            while ((linea = bReader.readLine())!= null && linea.length() != 0){
                Process p = pb.start();
                try {
                    OutputStream osp = p.getOutputStream();
                }

            }
        }
    }
    
}
