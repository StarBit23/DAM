import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class programaHash {
   public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    int intControlador=0;
    
    System.out.println("Introduce un nombre de usuario");
    String nombreUsuario = sc.nextLine();
    

    if (nombreUsuario!=null) {
        //crear fichero
        File fichero = new File ("./data",nombreUsuario+".dat");
        try {
            intControlador=1;
            if (fichero.createNewFile())
                System.out.println("El fichero se ha creado correctamente");
            else
                System.out.println("El fichero " + nombreUsuario+".dat " + "ya existe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try {
        //     String [] cmd = {"CertUtil", "-hashfile", "C:\\Users\\Usuario\\Desktop\\SEGUNDO\\2.ProgramacionServiciosProcesos\\JUNIO\\HASH MD5\\data\\"+nombreUsuario+".dat", "MD5"};
        //     Runtime.getRuntime().exec(cmd);
        // } catch (IOException ioe) {
        //     System.out.println (ioe);
        // }


    }else{
        System.out.println("No has introducido nada, vuelve a intentarlo");
    }

if (intControlador==1) {
    //crear hash md5
    ProcessBuilder pb = new ProcessBuilder("CertUtil", "-hashfile", "./data/"+nombreUsuario+".dat", "MD5"); 
    pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

    try {
        Process p = pb.start();
        p.waitFor();
        //conseguir respuesta
        InputStream is = p.getInputStream();
        int hash = 0;
        try {
            while((hash = is.read()) != -1){
                System.out.println((char)hash);
            }
        } catch (IOException e) {
            System.out.println("Error del hash, no ha devuelto nada");
        }
    } catch (IOException e) {
        System.out.println("Error inesperado al ejecutar el comando");
    }
}

    intControlador=0;
    

    
   }
}
