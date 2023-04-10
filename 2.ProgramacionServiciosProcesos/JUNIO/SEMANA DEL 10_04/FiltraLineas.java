import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;



public class FiltraLineas {

    public static void main(String[] args) throws IOException {

        String searchString = args[0];



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";

        int contador = 0;



        while (line != null) {

            // Leer una línea de entrada del usuario

            System.out.print("Introducir línea: ");

            line = br.readLine();

            contador++;

            

            if (line == null || line.isEmpty() || contador==6) {

                // Si se ha introducido una línea vacía o se ha alcanzado el límite de 6 líneas, salir del bucle

                break;

            }



            // Crear un proceso que ejecute el comando grep de Linux para buscar la cadena en la línea actual

            ProcessBuilder pb = new ProcessBuilder("grep", searchString);

            Process p = pb.start();



            // Enviar la línea actual al proceso hijo

            p.getOutputStream().write(line.getBytes());

            p.getOutputStream().close();



            // Leer la salida del proceso hijo para determinar si la cadena se encontró o no en la línea

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String output = reader.readLine();



            if (output == null) {

                System.out.printf("\"%s\" no contiene la línea buscada %s%n", line, searchString);

            } else {

                System.out.printf("\"%s\" contiene la línea buscada %s%n", line, searchString);

            }

        }

    }

}