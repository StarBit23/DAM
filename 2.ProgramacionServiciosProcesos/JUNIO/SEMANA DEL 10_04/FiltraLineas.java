import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltraLineas {

    public static void main(String[] args) throws IOException {
        String stringBuscar = args[0];


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int contador = 0;

        while (line != null) {
            //Leer una línea de entrada
            System.out.print("Introducir línea: ");
            line = br.readLine();
            contador++;

            if (line == null || line.isEmpty() || contador==6) {
                //Si se ha introducido línea vacía o se ha alcanzado el límite de 6 líneas salir del bucle
                break;
            }

            //Proceso que ejecuta el comando grep para buscar la cadena en la línea actual
            ProcessBuilder pb = new ProcessBuilder("grep", stringBuscar);
            Process p = pb.start();

            //Enviar la línea actual al proceso hijo
            p.getOutputStream().write(line.getBytes());
            p.getOutputStream().close();

            //Leer salida del proceso hijo para saber si la cadena se encontró o no en la línea
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String salida = reader.readLine();

            if (salida == null) {
                System.out.println(line + " NO contiene la línea buscada " + stringBuscar);
            } else {
                System.out.println(line + " SI contiene la línea buscada " + stringBuscar);
            }
        }
    }
}