package clientemarshalling;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "clientes")
@XmlAccessorType (XmlAccessType.FIELD)
public class Clientes
{
    @XmlElement(name = "cliente")
    private List<Biblioteca> clientes = null;
 
    public List<Biblioteca> getClientes() {
        return clientes;
    }
 
    public void setClientes(List<Biblioteca> clientes) {
        this.clientes = clientes;
    }
    
    public void addCliente(Biblioteca cliente){
        this.clientes.add(cliente);
    }

    public Clientes() {
        this.clientes = new ArrayList<Biblioteca>();
    }
}

