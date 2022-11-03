import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Propuesta1_PingGrep_sin {
    public static void main(String[] args) throws IOException {
        String[] ping = {"ping", "www.google.es", "-c4"};
        String[] grep = {"grep", "rtt"};
        ProcessBuilder pbPing = new ProcessBuilder(ping);
        ProcessBuilder pbGrep = new ProcessBuilder(grep);

        //inicio el proceso PING
        Process pPing = pbPing.start();

        //compruebo que PING ha terminado correctamente
        try {
            int codResult = pPing.waitFor();
            System.out.println(codResult == 0 ? "" : "Error de cojones");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // inicio el proceso GREP
        Process pGrep = pbGrep.start();
        Scanner read = new Scanner(pPing.getInputStream());
        PrintWriter in = new PrintWriter(pGrep.getOutputStream());
        //leo la salida del proceso PING y la mando a la entrada de GREP
        while (read.hasNextLine()){
            in.println(read.nextLine());
        }
        //cierro los flujos de salida y de entrada
        read.close();
        in.close();

        //leo la salida del proceso GREP
        Scanner out = new Scanner(pGrep.getInputStream());
        while (out.hasNextLine()){
            System.out.println(out.nextLine());
        }
        out.close();
    }
}
