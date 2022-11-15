package clientemarshalling;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "libros")
@XmlAccessorType (XmlAccessType.FIELD)
public class Libros {
    @XmlElement(name = "libro")
    private List<Libro> listaLibros = null;

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> libros) {
        this.listaLibros = libros;
    }

    public void addLibro(Libro libro){
        this.listaLibros.add(libro);
    }

    public int getSize() {
        return listaLibros.size();
    }

    public Libros() {
        this.listaLibros = new ArrayList<Libro>();
    }

    @Override
    public String toString() {
        return "Libros{" +
                "listaLibros=" + listaLibros +
                '}';
    }
}
