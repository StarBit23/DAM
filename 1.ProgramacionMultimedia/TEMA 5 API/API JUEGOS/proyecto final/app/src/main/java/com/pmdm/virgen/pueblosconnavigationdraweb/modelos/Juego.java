package com.pmdm.virgen.pueblosconnavigationdraweb.modelos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Juego {
    /**
         * Declaramos constantes con los argumentos que se le pasaránpublic static final String ARGUMENTO_ID = "id";
         * del Main al Dialogo Edición del Juego.public static final String ARGUMENTO_NOMBRE = "nombre";
   */
    public static final String ARGUMENTO_ID = "id";
    public static final String ARGUMENTO_NOMBRE = "nombre";
    public static final String ARGUMENTO_DESCRIPCION = "descripcion";
    public static final String ARGUMENTO_NUM_VENTAS = "numVentas";
    public static final String ARGUMENTO_URL_FOTO = "urlFoto";

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("id_usuario")
    @Expose
    private String id_usuario;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("ventas")
    @Expose
    private String ventas;

    @SerializedName("imagen")
    @Expose
    private String imagen;




    public Juego() {

    }

    public Juego(String id, String id_usuario, String nombre, String descripcion, String ventas, String imagen) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ventas = ventas;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getVentas() {
        return ventas;
    }

    public void setVentas(String ventas) {
        this.ventas = ventas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id='" + id + '\'' +
                ", id_usuario='" + id_usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ventas='" + ventas + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
