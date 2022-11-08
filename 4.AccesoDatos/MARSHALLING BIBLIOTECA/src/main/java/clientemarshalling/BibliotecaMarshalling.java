package clientemarshalling;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Administrador
 */
public class BibliotecaMarshalling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Biblioteca b1 = new Biblioteca(new Usuario("1","Pepe","pepeillo@gmail.com","52648596R",TipoUsuario.ADMINISTRADOR),
                    new Libro("9568632594756","El Quijote","Miguel de Cervantes","Aventura, Comedia"), new Prestamo("501","19-marzo"),
                    new Resenna(7,"Mu' chulo"));

            Biblioteca b2 = new Biblioteca(new Usuario("2","Lola","lolalolita@gmail.com","63284755R",TipoUsuario.ADMINISTRADOR),
                    new Libro("6435928173164","En tu puerta me cagué","Pepe Pérez","Romance, Drama"), new Prestamo("502","1-febrero"),
                    new Resenna(10,"Una de las historias más emotivas que he leido"));;
            
            Bibliotecas bibliotecas = new Bibliotecas();
            bibliotecas.addBiblioteca(b1);
            bibliotecas.addBiblioteca(b2);
            
            JAXBContext jaxbContext = JAXBContext.newInstance(bibliotecas.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            //Marshal the employees list in file
            jaxbMarshaller.marshal(bibliotecas, new File("bibliotecas.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(BibliotecaMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

