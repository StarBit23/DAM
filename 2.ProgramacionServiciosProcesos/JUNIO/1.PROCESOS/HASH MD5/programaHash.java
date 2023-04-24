import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class programaHash {
   public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    
    if (args.length < 1) {
        System.out.println("Error, pasa el nomobre del fichero");
        System.exit(-1);
    }
    String nombreUsuario = args[0];

    //crear fichero
    //ProcessBuilder pb = new ProcessBuilder("hashsum","./data/  usuario.dat");
    ProcessBuilder pb = new ProcessBuilder("fsutil","file","createnew","./data/"+nombreUsuario+".dat","1000");
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
            System.out.println("Error al crear fichero");
        }
    } catch (IOException e) {
        System.out.println("Error inesperado al ejecutar el comando");
    }


    //mostrar hash md5 del fichero ya creado
    ProcessBuilder pb2 = new ProcessBuilder("certutil","-hashfile","./data/"+nombreUsuario+".dat","MD5");
    pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);

    try {
        Process p2 = pb2.start();
        p2.waitFor();
        //conseguir respuesta
        InputStream is = p2.getInputStream();
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
}
