import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Propuesta1_PingGrep_con {
    public static void main(String[] args) throws FileNotFoundException {

        String[] ping = {"ping", "www.google.es", "-c4"};
        String[] grep = {"grep", "rtt"};
        File file = new File("ping.txt");
        ProcessBuilder pbPing = new ProcessBuilder(ping);
        ProcessBuilder pbGrep = new ProcessBuilder(grep);

        String line;

        try {
            //redirijo la salida del proceso PING a un fichero
            pbPing.redirectOutput(file);
            //inicio el proceso PING
            Process pPing = pbPing.start();
            //compruebo que se ha ejecutado correctamente
            try {
                int codResult = pPing.waitFor();
                System.out.println((codResult == 0 ? "" : "Error de cojones"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //inicio el proceso GREP
            Process pGrep = pbGrep.start();
            //leo el fichero con la salida de PING y lo escribo en la entrada de GREP
            try(
                    PrintWriter pw = new PrintWriter(pGrep.getOutputStream());
                    Scanner read = new Scanner(file)
                ){
                while (read.hasNextLine()) {
                    line = read.nextLine();
                    pw.println(line);
                }
            }

            //leo la salida del proceso GREP y la muestro en pantalla
            Scanner out = new Scanner(pGrep.getInputStream());
            while (out.hasNextLine()){
                System.out.println(out.nextLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
