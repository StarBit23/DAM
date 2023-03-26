package com.pmdm.virgen.pueblosconnavigationdraweb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JuegoParaApi {
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

    public JuegoParaApi() {
    }

    public JuegoParaApi(String id, String id_usuario, String nombre, String descripcion, String ventas, String imagen) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ventas = ventas;
        this.imagen = imagen;
    }
}
