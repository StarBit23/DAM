package com.jorgeortega.clases;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "libro")
@XmlAccessorType (XmlAccessType.FIELD)
public class Libro {
    public int id;
    public String ISBN;
    public String titulo;
    public String autor;
    public int edicion;
    public String editorial;
    public int año;
    
    public Libro(int id, String isbn2, String titulo, String autor, int edicion, String editorial, int año) {
        this.id = id;
        this.ISBN = isbn2;
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
        this.editorial = editorial;
        this.año = año;
    }

    public Libro(){
        
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEdicion() {
        return this.edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAño() {
        return this.año;
    }

    public void setAño(int año) {
        this.año = año;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", ISBN='" + getISBN() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", autor='" + getAutor() + "'" +
            ", edicion='" + getEdicion() + "'" +
            ", editorial='" + getEditorial() + "'" +
            ", año='" + getAño() + "'" +
            "}";
    }

}
