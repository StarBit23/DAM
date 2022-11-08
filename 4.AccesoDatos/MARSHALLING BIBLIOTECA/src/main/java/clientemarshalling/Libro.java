package clientemarshalling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@XmlRootElement(name = "libro")
@XmlAccessorType (XmlAccessType.FIELD)
public class Libro {
    private String isbn;
    private String nombreLibro;
    private String autor;
    private String genero;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Libro(String isbn, String nombre, String autor, String genero) {
        this.isbn = isbn;
        this.nombreLibro = nombre;
        this.autor = autor;
        this.genero = genero;
    }

    public Libro() {
    }
}
