package com.jorge.modelo;
public class Persona {
   private int id;
   private String nombre;
   private String username;
   private String password;
   private TipoUsuario tipoUsuario;

    public Persona(int id,String nombre,String username,String password,TipoUsuario tipoUsuario){
        this.id();
        this.username();
        this.password();
        this.tipoUsuario();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


}
