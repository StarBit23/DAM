import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicherosTxt {
    public static void main(String[] args) {
        crearFichero("Jorge", "Ortega", "secreto");

        leerFichero("Jorge");

        editarFichero("Jorge");

        encontrarLinea("Jorge.txt", "Nueva linea");
    }

    public static void crearFichero(String nombre, String apellidos, String passwd) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombre+".txt"))) {
            bw.write("nombre: "+ nombre +",\napellidos: "+ apellidos +",\npasswd: " + passwd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerFichero(String nombreFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero+".txt"))){
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void editarFichero(String nombreFichero) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero+".txt", true))){
            bw.newLine();
            bw.write("Nueva linea");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encontrarLinea(String archivoOriginal, String lineaBuscar) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal)))
{

             String linea;
             int contador = 0;
             while ((linea = br.readLine()) != null) {
                contador++;
                if (linea.equals(lineaBuscar)) {
                    System.out.println("Texto \"" + lineaBuscar + "\" encontrado en linea: " + contador);
                }
             }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}