import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Propuesta3_md5sum {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ProcessBuilder pb = new ProcessBuilder("md5sum");
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        System.out.println("Introduce un texto para calcular su hash:");
        String line;
        while ((line = sc.nextLine()) != null && line.length() != 0) {
            Process p = pb.start();

            //escribo la linea en la entrada del proceso
            try (PrintWriter in = new PrintWriter(p.getOutputStream())) {
                in.println(line);
            }
            //leo la salida del proceso y la escribo en el fichero
            try (
                    Scanner out = new Scanner(p.getInputStream());
                    PrintWriter pw = new PrintWriter(new FileWriter(new File("FILES/md5sum.txt"),true));
            ) {
                while (out.hasNextLine()) {
                    String outLine = out.nextLine();
                    System.out.println(outLine.substring(0, outLine.indexOf(" ")));
                    pw.write(outLine.substring(0, outLine.indexOf(" ")) + "\n");
                }
            }
        }
        sc.close();
    }
}
