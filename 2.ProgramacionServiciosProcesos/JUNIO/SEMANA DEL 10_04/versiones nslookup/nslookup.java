import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/*
 * Ejemplo DEL nslookup, compartiendo la salida del proceso y subproceso.
 */
public class nslookup {

    public static void main(String[] args) throws UnsupportedEncodingException {
        ProcessBuilder pb = new ProcessBuilder("nslookup"); 
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);  //envia la salida de datos del proceso a la salida estándar heredada

        //convierto en flujo de bytes en caracteres
        try(
            /*Al cerrarse el bloque dentro del try (), se cierra el blujo de entrada. No es necesario hacer un close*/
            InputStreamReader isstdin = new InputStreamReader(System.in, "UTF-8");
            //preparo el buffer para leer de la entrada estándar
            BufferedReader brstdin = new BufferedReader(isstdin);
            )
        {
            String linea;
            System.out.println("Introducir nombre de dominio");
            while (((linea = brstdin.readLine()) != null) && (linea.length() != 0)){
                 Process p = pb.start();

                try (
                        /*
                        Al cerrarse el bloque dentro del try (), se cierra el blujo de salida
                        */
                        OutputStream osp = p.getOutputStream();
                        OutputStreamWriter oswp = new OutputStreamWriter(osp, "UTF-8");//convierto flujo de caracteres en byte
                    )
                {
                        //escribo el dominio solicitado en el proceso padre en el flujo de entrada del hijo
                    oswp.write(linea);
                } //fin try

                try{
                    p.waitFor(); //el proceso padre, se espera a que finalize el subproceso
                } 

                catch ( InterruptedException ex) {
                    //convierto en flujo de bytes en caracteres
                }

                System.out.println("Introducir nombre de dominio");
            }//fin while

        } //fin try

        catch (IOException e){
            System.out.println("ERROR: de E/S");
            e.printStackTrace();
        }
    } //fin main
} //fin while
