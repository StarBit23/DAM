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
public class ClienteUnmarshalling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Clientes clientes=new Clientes();

            JAXBContext jaxbContext = JAXBContext.newInstance(clientes.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            clientes = (Clientes) jaxbUnmarshaller.unmarshal(new File("clientes.xml"));

            System.out.println("Hay "+clientes.getClientes().size()+" clientes, que son:");

            for (Biblioteca cli : clientes.getClientes()){
                System.out.println(
                    "\t id: "+cli.getDni()
                    + " nombre:"+cli.getNombre()
                    + " apellidos:"+cli.getApellidos()
                    + " ciudad: "+cli.getDireccion().getLocalidad()
                    + " CP: "+cli.getDireccion().getCodPos());
            }
        } catch (JAXBException ex) {
            Logger.getLogger(ClienteMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

