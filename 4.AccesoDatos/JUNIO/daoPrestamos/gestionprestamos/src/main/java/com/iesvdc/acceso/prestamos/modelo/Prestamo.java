package com.iesvdc.acceso.prestamos.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "prestamo")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Prestamo {
    private int id;
    private Lector lector;
    private Libro libro;
    private Operario operario;

    public Prestamo() {
    }

    public Prestamo(int id, Lector lector, Libro libro, Operario operario) {
        this.id = id;
        this.lector = lector;
        this.libro = libro;
        this.operario = operario;
    }

    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "lector")
    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    @XmlElement(name = "libro")
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @XmlElement(name = "operario")
    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", lector=" + lector +
                ", libro=" + libro +
                ", operario=" + operario +
                '}';
    }
}
