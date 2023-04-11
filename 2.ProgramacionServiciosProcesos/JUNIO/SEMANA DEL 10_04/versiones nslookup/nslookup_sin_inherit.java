/*
 * @author santi
 * PSP 2022/2023
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/*
 * Ejemplo DEL nslookup, NO comparten la salida ambos procesos.
 * 
 */

public class nslookup_sin_inherit {

    public static void main(String[] args)  {
        ProcessBuilder pb = new ProcessBuilder("nslookup");
        //envia la salida de datos del proceso a la salida estándar heredada
      
        try( //No es necesario hacer un close del BufferedReader
            
            //convierto en flujo de bytes en caracteres
            InputStreamReader isstdin = new InputStreamReader(System.in, "UTF-8");
            //preparo el buffer para leer de la entrada estándar
            BufferedReader brstdin = new BufferedReader(isstdin)) {
            String linea;
            System.out.println("Introducir nombre de dominio");
            while (((linea = brstdin.readLine()) != null) && (linea.length() != 0)){
                Process p = pb.start();
                try ( //No es necesario hacer un close del Flujo de salida

                    //preparo el tunel entre el padre y el hijo, para mandar datos del proceso padre al hijo
                    OutputStream osp = p.getOutputStream(); 
                    //convierto flujo de caracteres en byte
                    OutputStreamWriter oswp = new OutputStreamWriter(osp, "UTF-8");
                    )
                {
                    //escribo el dominio solicitado en el proceso padre en el flujo de entrada del hijo
                    oswp.write(linea);
                   
                }
                try{
                    int codRetorno = p.waitFor();
                     //Ahora queremos leer lo que ha ejecutado el subproceso    
                     InputStream is = p.getInputStream();
                     InputStreamReader isr = new InputStreamReader(is);
                     BufferedReader br = new BufferedReader(isr);
                     String leida;
                     while ( (leida=br.readLine()) != null){
                         System.out.println(leida);
                     }
                    System.out.println("Soy el proceso padre y ha muerte el lookup " + 
                        (codRetorno == 0 ? "(ejecucion del subproceso correctamente)" : "(Error)")
                    );

                } //fin try
                catch ( InterruptedException ex) {
                    System.out.println("Se ha interrumpido el subproceso.");
                }
                System.out.println("Introducir nombre de dominio");

            } //fin while
        } //fin try
        catch (IOException e){
            System.out.println("ERROR: de E/S");
            e.printStackTrace();
        }
    } //fin main
}
