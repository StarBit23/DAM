package com.jorgeortega.clases;

public class Prestamos {
    private Prestamo prestamo;


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
    public String toString() {
        return "{" +
            " prestamo='" + getPrestamo() + "'" +
            "}";
    }

}
