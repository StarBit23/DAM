package com.example.miproyecto.modelo;

public class Juego {

    private String urlFoto;
    private String nombre;
    private String descripcion;
    private String numVentas;

    public Juego() {

    }

    public Juego(String urlFoto, String nombre, String descripcion, String numVentas) {
        this.urlFoto = urlFoto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numVentas = numVentas;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(String numVentas) {
        this.numVentas = numVentas;
    }

    @Override
    public String toString() {
        return "Pueblo{" +
                "urlFoto='" + urlFoto + '\'' +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numVentass=" + numVentas +
                '}';
    }
}
