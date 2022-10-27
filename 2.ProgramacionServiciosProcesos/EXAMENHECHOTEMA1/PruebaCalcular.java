import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * javac Calcular.java
 * jar -cf calcular.jar .\Calcular.class
 * javac PruebaCalcular.java
 * java PruebaCalcular
 **/
public class PruebaCalcular {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] command = {"java", "-cp", "calcular.jar", "Calcular"};
        ProcessBuilder pb = new ProcessBuilder(command);

        String oper;
        do {
            System.out.println("Introduce una operacion matematica");
            System.out.println("Solo se admite los operadores (+ - * :)");
            oper = sc.nextLine();
        } while (!oper.matches("(\\d+)([+]|[-]|[*]|[:])(\\d+)"));

        Process p = pb.start();
        try (PrintWriter in = new PrintWriter(p.getOutputStream())) {
            in.println(oper);
        }

        try {
            int num = p.waitFor();
            System.out.println(num == 0 ? "" : "Ha ocurrido algun error");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (Scanner out = new Scanner(p.getInputStream())) {
            while (out.hasNextLine()) {
                String line = out.nextLine();
                System.out.println(line);
            }
        }
    }
}
