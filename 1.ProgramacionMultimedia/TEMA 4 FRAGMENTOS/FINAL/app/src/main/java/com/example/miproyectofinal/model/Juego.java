package com.example.miproyectofinal.model;

public class Juego {

    public static final String ARGUMENTO_ID = "id";
    public static final String ARGUMENTO_NOMBRE = "nombre";
    public static final String ARGUMENTO_DESCRIPCION = "descripcion";
    public static final String ARGUMENTO_NUM_VENTAS = "numVentas";
    public static final String ARGUMENTO_URL_FOTO = "urlFoto";

    private long id;
    private String urlFoto;
    private String nombre;
    private String descripcion;
    private String numVentas;

    public Juego() {

    }

    public Juego(String urlFoto, String nombre, String descripcion, String numVentas, long id) {
        this.urlFoto = urlFoto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numVentas = numVentas;
        this.id = id;
    }

    public Juego(long dameId, Object nombre, String nombre1, String edad, String scuderia) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", urlFoto='" + urlFoto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numVentas='" + numVentas + '\'' +
                '}';
    }
}
