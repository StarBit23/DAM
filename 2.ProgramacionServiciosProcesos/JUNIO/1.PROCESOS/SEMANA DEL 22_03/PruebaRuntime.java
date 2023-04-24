import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PruebaRuntime {
    //En este ejemplo creamos un proceso nuevo, al que le pedimos que abra cmd y ejeute el comando "/c dir",
    //el cual nos mostrará un listado de carpetas que tenemos en dicha ruta
    //Pagina 18
    public PruebaRuntime(){
        try {
            Process p = Runtime.getRuntime().exec("cmd /c dir");
    
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
    
            String aux = br.readLine();
    
            while (aux != null) {
                System.out.println(aux);
                aux = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new PruebaRuntime();
    }
}

