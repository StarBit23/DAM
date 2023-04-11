/*
 * @author santi
 * PSP 2022/2023
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class nslookup_sin_inherit_actualizados {

    public static void main(String[] args)  {
        ProcessBuilder pb = new ProcessBuilder("nslookup");

        try{
            Scanner sc = new Scanner(System.in);
            String linea;
            System.out.println("Introducir nombre de dominio");
            while (((linea = sc.nextLine()) != null) && (linea.length() != 0)){
                Process p = pb.start();  //lanzo el proceso
                OutputStream osp = p.getOutputStream(); //preparo el tunel entre el padre y el hijo, para mandar datos del proceso padre al hijo
                PrintWriter pw = new PrintWriter(osp);
                pw.println(linea); //escribo el dominio solicitado en el proceso padre en el flujo de entrada del hijo
                pw.close();//tremendamente importante cerrar el flujo de salida. //sino lo cierro, SE BLOQUEA EL PADRE.

                try{
                    int codRetorno = p.waitFor();  //el proceso padre, se espera a que finalize el subproceso     
                    InputStream is = p.getInputStream();//Ahora queremos leer lo que ha ejecutado el subproceso    
                    Scanner scSub = new Scanner(is);
                    String leida; 
                    while (scSub.hasNextLine()){  //mientras tengamos líneas que leer.
                        System.out.println(scSub.nextLine());
                        
                    }
                    //comprobamos que ha hecho el subproceso mediante el retorno.
                    System.out.println("Soy el proceso padre y ha muerte el lookup " + 
                        (codRetorno == 0 ? "(ejecucion del subproceso correctamente)" : "(Error en su ejecución)")
                    );
                } 

                catch ( InterruptedException ex) {
                    System.out.println("Se ha interrumpido el subproceso.");
                }

                catch (NoSuchElementException e){
                    System.out.println("Algún tipo de error en el iterator nextLine");
                    e.printStackTrace();
                }
                
                System.out.println("Introducir nuevo dominio:");
            } //fin while
        }//fin try

        catch (IOException e){  
            //Siempre que creamos flujos, debemos de capturar esta posible excepción
            System.out.println("ERROR: de E/S");
            e.printStackTrace();
        }
    }  //fin main
}//fin clase