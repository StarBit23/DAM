package com.pmdm.virgen.pueblosconnavigationdraweb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario{
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("disponible")
    @Expose
    private String disponible;
    @SerializedName("imagen")
    @Expose
    private String imagen;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Usuario() {
    }

    public Usuario(String email, String password, String nombre, String imagen, String disponible) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.imagen = imagen;
        this.disponible = disponible;
    }

}
