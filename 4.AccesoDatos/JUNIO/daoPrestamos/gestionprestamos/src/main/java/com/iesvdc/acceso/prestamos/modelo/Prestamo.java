package com.iesvdc.acceso.prestamos.modelo;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "prestamo")
@XmlAccessorType (XmlAccessType.FIELD)
public class Prestamo {
    public Lector lector;
    public Libro libro;
    public Operario operario;


    public Prestamo() {
    }

    public Prestamo(Lector lector, Libro libro, Operario operario) {
        this.lector = lector;
        this.libro = libro;
        this.operario = operario;
    }

    public Prestamo(Lectores lectores, Libros libros, Operarios operarios) {
    }

    public Lector getLector() {
        return this.lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Operario getOperario() {
        return this.operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    public Prestamo lector(Lector lector) {
        setLector(lector);
        return this;
    }

    public Prestamo libro(Libro libro) {
        setLibro(libro);
        return this;
    }

    public Prestamo operario(Operario operario) {
        setOperario(operario);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Prestamo)) {
            return false;
        }
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(lector, prestamo.lector) && Objects.equals(libro, prestamo.libro) && Objects.equals(operario, prestamo.operario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lector, libro, operario);
    }

    @Override
    public String toString() {
        return "{" +
            " lector='" + getLector() + "'" +
            ", libro='" + getLibro() + "'" +
            ", operario='" + getOperario() + "'" +
            "}";
    }
    
}
