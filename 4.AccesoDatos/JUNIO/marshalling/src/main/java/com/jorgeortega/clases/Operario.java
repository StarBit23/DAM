package com.jorgeortega.clases;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "operario")
@XmlAccessorType (XmlAccessType.FIELD)
public class Operario {
    private int id;
    private String username;
    private String password;
    private String email;

    public Operario(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Operario() {
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

    public Operario id(int id) {
        setId(id);
        return this;
    }

    public Operario username(String username) {
        setUsername(username);
        return this;
    }

    public Operario password(String password) {
        setPassword(password);
        return this;
    }

    public Operario email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Operario)) {
            return false;
        }
        Operario operario = (Operario) o;
        return id == operario.id && Objects.equals(username, operario.username) && Objects.equals(password, operario.password) && Objects.equals(email, operario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
    

}
