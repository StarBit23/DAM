package com.pmdm.virgen.pueblosconnavigationdraweb.listadoUsuarios;

import java.util.concurrent.atomic.AtomicLong;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Usuario extends RealmObject {
    private String username;
    private String password;
    @PrimaryKey
    private int id;

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

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
