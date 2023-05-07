package com.jorgeortega.clases;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "cps")
@XmlAccessorType (XmlAccessType.FIELD)
public class Prestamos {
    private Prestamo prestamo;

    @XmlElement(name="prestamo")
    List<Prestamo> prestamos;

    public Prestamos() {
    }

    public Prestamos(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Prestamo getPrestamo() {
        return this.prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Prestamos prestamo(Prestamo prestamo) {
        setPrestamo(prestamo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Prestamos)) {
            return false;
        }
        Prestamos prestamos = (Prestamos) o;
        return Objects.equals(prestamo, prestamos.prestamo);
    }

    @Override
    public String toString() {
        return "{" +
            " prestamo='" + getPrestamo() + "'" +
            "}";
    }
    

}
