package com.jorge.modelo;

public class Usuario {
    
    String username;
    String email;
    String password;
    Integer id;
    TipoUsuario tipoUsuario;

    public Usuario() {

    }

    public Usuario(String username, String email, String password, Integer id, TipoUsuario tipoUsuario){
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    


}