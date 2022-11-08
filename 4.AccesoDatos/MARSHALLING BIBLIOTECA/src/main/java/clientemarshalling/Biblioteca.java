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
    @XmlElement
    private Usuario usuario;
    @XmlElement
    private Libro libro;
    @XmlElement
    private Prestamo prestamo;
    @XmlElement
    private Resenna resenna;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Resenna getResenna() {
        return resenna;
    }

    public void setResenna(Resenna resenna) {
        this.resenna = resenna;
    }

    public Biblioteca(Usuario usuario, Libro libro, Prestamo prestamo, Resenna resenna) {
        this.usuario = usuario;
        this.libro = libro;
        this.prestamo = prestamo;
        this.resenna = resenna;
    }

    public Biblioteca() {
    }
}

