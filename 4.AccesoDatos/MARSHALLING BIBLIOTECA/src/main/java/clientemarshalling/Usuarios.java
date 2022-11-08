package clientemarshalling;

import java.util.ArrayList;
import java.util.List;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "usuario")
@XmlAccessorType (XmlAccessType.FIELD)
public class Usuarios{
    @XmlElement(name = "usuario")
    private List<Usuario> listaUsuarios = null;
 
    public Usuarios() {
        this.listaUsuarios = new ArrayList<Usuario>();
    }

    public List<Usuario> getListaUsuarios() {
        return getListaUsuarios();
    }
 
    public void setListaUusarios(List<Usuario> usuarios) {
        this.listaUsuarios = usuarios;
    }
    
    public void addUsuario(Usuario usuario){
        this.listaUsuarios.add(usuario);
    }

    public int getSize() {
        return listaUsuarios.size();
    }

    
}

