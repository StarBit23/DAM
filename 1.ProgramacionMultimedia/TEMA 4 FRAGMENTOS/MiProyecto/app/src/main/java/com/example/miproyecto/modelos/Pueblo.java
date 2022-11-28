package com.example.miproyecto.modelos;

public class Pueblo {
    private String urlFoto;
    private String nombre;
    private String descripcion;
    private int numHabitantes;

    public Pueblo() {

    }

    public Pueblo(String urlFoto, String nombre, String descripcion, int numHabitantes) {
        this.urlFoto = urlFoto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numHabitantes = numHabitantes;
    }



    public String getUrlFoto() {
        return urlFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNumHabitantes() {
        return numHabitantes;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNumHabitantes(int numHabitantes) {
        this.numHabitantes = numHabitantes;
    }

    @Override
    public String toString() {
        return "Pueblo{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numHabitantes=" + numHabitantes +
                '}';
    }
}
