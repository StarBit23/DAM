import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExamenOperacion {
    public static void main(String[] args) {
        String[] paramentros = {"java", "-cp", "calcular.jar", "Calcular.java"};
        ProcessBuilder pb = new ProcessBuilder(paramentros);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        Scanner sc = new Scanner(System.in);

        try {
            Process p = pb.start();
            

            try {
                int code = p.waitFor();
                sc.nextLine();
                if (code != 0)
                    System.out.println("Ha ocurrido un error inesperado");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            PrintWriter pw = new PrintWriter(p.getOutputStream());
            pw.println(sc.nextLine());

            Scanner scIn = new Scanner(p.getInputStream());
            while (scIn.hasNextLine()){
                String lineaEntrada = scIn.nextLine();
                System.out.println(lineaEntrada);
            }
            scIn.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
