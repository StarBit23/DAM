package com.jortmorc.examen.modelo;

import java.util.Objects;

public class Palo {
    private int id;
    private String nombre;
    private String email;


    public Palo() {
    }

    public Palo(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Palo id(int id) {
        setId(id);
        return this;
    }

    public Palo nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Palo email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Palo)) {
            return false;
        }
        Palo palo = (Palo) o;
        return id == palo.id && Objects.equals(nombre, palo.nombre) && Objects.equals(email, palo.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
    
}
