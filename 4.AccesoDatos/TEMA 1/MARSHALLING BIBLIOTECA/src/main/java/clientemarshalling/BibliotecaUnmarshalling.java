package clientemarshalling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;;

/**
 *
 * @author Administrador
 */
public class BibliotecaUnmarshalling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Biblioteca biblio=new Biblioteca();
        unmarshalingXML(biblio);
        System.out.println("\n//////////////////////////\n");
        unmarshalingJSON(biblio);
        
    }

    private static void unmarshalingXML(Biblioteca biblio) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(biblio.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            biblio = (Biblioteca) jaxbUnmarshaller.unmarshal(new File("biblioteca.xml"));

            System.out.println("Hay "+biblio.getUsuarios().getSize()+" usuarios, que son:");
            for (Usuario usuario : biblio.getUsuarios().getListaUsuarios()){
                System.out.println(usuario.toString());
            }
            System.out.println("\n");
            System.out.println("Hay "+biblio.getLibros().getSize()+" libros, que son:");
            for (Libro libro : biblio.getLibros().getListaLibros()){
                System.out.println(libro.toString());
            }
            System.out.println("\n");
            System.out.println("Hay "+biblio.getPrestamos().getSize()+" prestamoss, que son:");
            for (Prestamo prestamo : biblio.getPrestamos().getListaPrestamos()){
                System.out.println(prestamo.toString());
            }
            System.out.println("\n");
            System.out.println("Hay "+biblio.getResennas().getSize()+" reseñas, que son:");
            for (Resenna resenna : biblio.getResennas().getListaResennas()){
                System.out.println(resenna.toString());
            }

        } catch (JAXBException ex) {
            Logger.getLogger(BibliotecaMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void unmarshalingJSON(Biblioteca biblio) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Reader reader = new FileReader("biblioteca.json")) {

            // Convert JSON to JsonElement, and later to String
            JsonElement json = gson.fromJson(reader, JsonElement.class);

            String jsonInString = gson.toJson(json);

            System.out.println(jsonInString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

