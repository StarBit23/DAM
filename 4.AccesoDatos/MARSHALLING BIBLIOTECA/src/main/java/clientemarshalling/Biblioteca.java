package clientemarshalling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */

@XmlRootElement(name = "biblioteca")
@XmlAccessorType (XmlAccessType.FIELD)
public class Biblioteca
{
    
    @XmlAttribute
    private Usuario usuario;
    @XmlElement
    private String libros;
    @XmlElement
    private String prestamos;
    @XmlElement
    private String reseñas;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String libros() {
        return libros;
    }

    public void setLibros(String libros) {
        this.libros = libros;
    }

    public String getPrestamos() {
        return prestamos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Cliente(Integer dni, String nombre, String apellidos, String email, String telefono, Direccion direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente() {
    }

    
    
    
}

