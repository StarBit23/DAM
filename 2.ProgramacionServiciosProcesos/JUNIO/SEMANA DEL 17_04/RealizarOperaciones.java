import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RealizarOperaciones {
    public static void main(String[] args) throws IOException {
        BufferedReader num1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader simbolo = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader num2 = new BufferedReader(new InputStreamReader(System.in));
        String line1 = "";
        String simb = "";
        String line2 = "";
        int contador = 0;

        while (line2 != null) {
            //Leer una línea de entrada
            System.out.print("Introducir numero 1: ");
            line1 = num1.readLine();

            System.out.print("Introducir simbolo: ");
            simb = simbolo.readLine();

            System.out.print("Introducir numero 2: ");
            line2 = num2.readLine();

            contador++;

            if (line1 == "" || line2== "" || simb == "") {
                //Si se ha introducido línea vacía en cualquier operando, salir del bucle
                break;
            }

            //Proceso que ejecuta el comando que ejecuta un .jar con argumentos
            ProcessBuilder pb = new ProcessBuilder("java", "-cp","calcular.jar","Calcular",line1,simb,line2);
            Process p = pb.start();

            //Enviar la líneasal proceso hijo
            p.getOutputStream().write(line1.getBytes());
            p.getOutputStream().write(simb.getBytes());
            p.getOutputStream().write(line2.getBytes());
            p.getOutputStream().close();

            //Leer salida del proceso hijo y la muestra por pantalla
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String salida = reader.readLine();

            if (salida == null) {
                System.out.println("Has introducido bien los parámetros?");
            } else {
                System.out.println(salida + "\n");
            }
        }
    }
}
