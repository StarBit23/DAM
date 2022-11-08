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
public class ClienteMarshalling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Biblioteca c1 = new Biblioteca(new Usuario("1","Pepe","pepeillo@gmail.com","52648596R",TipoUsuario.ALUMNO), null, null, null);
            
            //Biblioteca c2 = new Biblioteca(87654321, "Juan", "García Pérez",
            //        "juan@sincorreo.es", "+1555654321",
            //        new Direccion(23008, "Paseo", "de la Estación", "44", "", "", ""));
            
            Usuarios clientes = new Usuarios();
            clientes.addCliente(c1);
            
            JAXBContext jaxbContext = JAXBContext.newInstance(clientes.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            //Marshal the employees list in file
            jaxbMarshaller.marshal(clientes, new File("clientes.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(ClienteMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

