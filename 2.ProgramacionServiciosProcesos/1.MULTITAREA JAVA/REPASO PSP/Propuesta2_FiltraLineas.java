import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Propuesta2_FiltraLineas {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        System.out.println("Introduce un parametro a buscar");
        String param = sc.nextLine();
        ProcessBuilder pb = new ProcessBuilder("grep", param);
        String line;
        String outText = null;

        while (counter <= 6) {
            Process p = pb.start();
            PrintWriter pw = new PrintWriter(p.getOutputStream());
            Scanner out = new Scanner(p.getInputStream());

            //leo la palabra para pasar al proceso y se la mando
            System.out.println("Introduce una palabra para buscar coincidencias:");
            line = sc.nextLine();
            pw.println(line);
            pw.close();

            //recojo la salida del proceso y la muestro en pantalla
            while (out.hasNextLine()) {
                outText = out.nextLine();
                System.out.println(outText);
            }
            out.close();

            //si grep devuelve un string es por que hay coincidencias, asi que lo muestro
            if (outText != null && outText.contains(param)) {
                System.out.println("la palabra " + outText + " contiene " + param + "\n");
            }else {
                System.out.println("No hay coincidencias \n");
            }

            //aumento el contador y pongo la variable de salida a null
            counter++;
            outText = null;
        }
        sc.close();
    }
}