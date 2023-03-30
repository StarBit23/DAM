package com.jorgeortega;

public class Libro {
    public int id;
    public int ISBN;
    public String titulo;
    public String autor;
    public int edicion;
    public String editorial;
    public int año;
    

    public Libro(int id, String ISBN, String titulo, String autor, String edicion, String editorial, String año) {
        this.id = id;
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
        this.editorial = editorial;
        this.año = año;
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

    public String getEdicion() {
        return this.edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAño() {
        return this.año;
    }

    public void setAño(String año) {
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
