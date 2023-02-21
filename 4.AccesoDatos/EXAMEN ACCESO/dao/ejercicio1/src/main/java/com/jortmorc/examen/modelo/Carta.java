package com.jortmorc.examen.modelo;

import java.util.Objects;

public class Carta {
    private int id;
    private String nombre;
    private String descripcion;
    private String palo;


    public Carta() {
    }

    public Carta(int id, String nombre, String descripcion, String palo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.palo = palo;
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

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPalo() {
        return this.palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public Carta id(int id) {
        setId(id);
        return this;
    }

    public Carta nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Carta descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public Carta palo(String palo) {
        setPalo(palo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Carta)) {
            return false;
        }
        Carta carta = (Carta) o;
        return id == carta.id && Objects.equals(nombre, carta.nombre) && Objects.equals(descripcion, carta.descripcion) && Objects.equals(palo, carta.palo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, palo);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", palo='" + getPalo() + "'" +
            "}";
    }
    
}
