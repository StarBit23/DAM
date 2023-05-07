package com.jorgeortega.clases;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "lector")
@XmlAccessorType (XmlAccessType.FIELD)
public class Lector {
    private int id;
    private String username;
    private String password;
    private String email;
    private int telefono;
    private Direccion direcciones;
    private String nombre;
    private String apellidos;


    public Lector() {
    }

    public Lector(int id, String username, String password, String email, int telefono, Direccion direcciones, String nombre, String apellidos) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.direcciones = direcciones;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Direccion getDirecciones() {
        return this.direcciones;
    }

    public void setDirecciones(Direccion direcciones) {
        this.direcciones = direcciones;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Lector id(int id) {
        setId(id);
        return this;
    }

    public Lector username(String username) {
        setUsername(username);
        return this;
    }

    public Lector password(String password) {
        setPassword(password);
        return this;
    }

    public Lector email(String email) {
        setEmail(email);
        return this;
    }

    public Lector telefono(int telefono) {
        setTelefono(telefono);
        return this;
    }

    public Lector direcciones(Direccion direcciones) {
        setDirecciones(direcciones);
        return this;
    }

    public Lector nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Lector apellidos(String apellidos) {
        setApellidos(apellidos);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lector)) {
            return false;
        }
        Lector lector = (Lector) o;
        return id == lector.id && Objects.equals(username, lector.username) && Objects.equals(password, lector.password) && Objects.equals(email, lector.email) && telefono == lector.telefono && Objects.equals(direcciones, lector.direcciones) && Objects.equals(nombre, lector.nombre) && Objects.equals(apellidos, lector.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, telefono, direcciones, nombre, apellidos);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", direcciones='" + getDirecciones() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            "}";
    }

}