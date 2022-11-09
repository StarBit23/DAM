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
    private Usuarios usuarios;
    @XmlElement
    private Libros libros;
    @XmlElement
    private Prestamos prestamos;
    @XmlElement
    private Resennas resennas;

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }

    public Prestamos getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Prestamos prestamos) {
        this.prestamos = prestamos;
    }

    public Resennas getResennas() {
        return resennas;
    }

    public void setResennas(Resennas resennas) {
        this.resennas = resennas;
    }

    public Biblioteca(Usuarios usuarios, Libros libros, Prestamos prestamos, Resennas resennas) {
        this.usuarios = usuarios;
        this.libros = libros;
        this.prestamos = prestamos;
        this.resennas = resennas;
    }

    public Biblioteca() {
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "usuarios=" + usuarios +
                ", libros=" + libros +
                ", prestamos=" + prestamos +
                ", resennas=" + resennas +
                '}';
    }
}

