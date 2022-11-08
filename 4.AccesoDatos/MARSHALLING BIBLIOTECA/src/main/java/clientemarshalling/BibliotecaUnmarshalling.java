package clientemarshalling;

import java.io.File;
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
        try {
            Bibliotecas bibliotecas=new Bibliotecas();

            JAXBContext jaxbContext = JAXBContext.newInstance(bibliotecas.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            bibliotecas = (Bibliotecas) jaxbUnmarshaller.unmarshal(new File("bibliotecas.xml"));

            System.out.println("Hay "+bibliotecas.getListaBibliotecas().size()+" bibliotecas, que son:");

            for (Biblioteca biblioteca : bibliotecas.getListaBibliotecas()){
                System.out.println(
                    "\t usuario: "+biblioteca.getUsuario()
                    + " libro:"+biblioteca.getLibro()
                    + " prestamo:"+biblioteca.getPrestamo()
                    + " reseña: "+biblioteca.getResenna());

            }
        } catch (JAXBException ex) {
            Logger.getLogger(BibliotecaMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

