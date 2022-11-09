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
            Usuarios usuarios = new Usuarios();
            usuarios.addUsuario(new Usuario("1","Pepe","pepeillo@gmail.com","52648596R",TipoUsuario.ADMINISTRADOR));
            usuarios.addUsuario(new Usuario("2","Lola","lolalolita@gmail.com","63284755R",TipoUsuario.PROFESOR));

            Libros libros = new Libros();
            libros.addLibro(new Libro("9568632594756","El Quijote","Miguel de Cervantes","Aventura, Comedia"));
            libros.addLibro(new Libro("6435928173164","En tu puerta me cagué","Pepe Pérez","Romance, Drama"));

            Prestamos prestamos = new Prestamos();
            prestamos.addPrestamo(new Prestamo("501","19-marzo"));
            prestamos.addPrestamo(new Prestamo("502","1-febrero"));

            Resennas resennas = new Resennas();
            resennas.addResenna( new Resenna(7,"Mu' chulo"));
            resennas.addResenna(new Resenna(10,"Una de las historias más emotivas que he leido"));

            Biblioteca biblio = new Biblioteca(usuarios,libros,prestamos,resennas);

            //MARSHALLER XML
            JAXBContext jaxbContext = JAXBContext.newInstance(biblio.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(biblio, new File("biblioteca.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(BibliotecaMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
        //MARSHALLER JSON

    }
    
}

