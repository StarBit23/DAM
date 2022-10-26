import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConvertirMayusculasPrincipal {
    public static void main(String[] args) {
        String[] paramentros = {"java", "-cp", "convertir.jar", "ConvertirMayusculas"};
        ProcessBuilder pb = new ProcessBuilder(paramentros);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce lo que vas a convertir a mayúsculas");
        String lineaTeclado = sc.nextLine();
        sc.close();

        try {
            Process p = pb.start();
            PrintWriter pw = new PrintWriter(p.getOutputStream());
            pw.println(lineaTeclado);
            pw.close();

            try {
                int code = p.waitFor();
                if (code != 0)
                    System.out.println("Ha ocurrido un error inesperado");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

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
