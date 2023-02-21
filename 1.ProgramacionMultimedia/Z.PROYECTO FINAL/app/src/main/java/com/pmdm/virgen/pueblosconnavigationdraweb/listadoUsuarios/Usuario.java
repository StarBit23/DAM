package com.pmdm.virgen.pueblosconnavigationdraweb.listadoUsuarios;

import io.realm.RealmObject;

public class Usuario extends RealmObject {
    private String username;
    private String password;

    public Usuario() {
        this.username = username;
        this.password = password;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
