package com.jorgeortega.clases;

import java.util.List;
import java.util.Objects;

public class Lectores {
    List<Lector> lectores;

    public boolean add(Lector lector){
        return this.lectores.add(lector);
    }

    public List<Lector>findAll(){
        return lectores;
    }

    public Lectores() {
    }

    public Lectores(List<Lector> lectores) {
        this.lectores = lectores;
    }

    public List<Lector> getLectores() {
        return this.lectores;
    }

    public void setLectores(List<Lector> lectores) {
        this.lectores = lectores;
    }

    public Lectores lectores(List<Lector> lectores) {
        setLectores(lectores);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lectores)) {
            return false;
        }
        Lectores lectores = (Lectores) o;
        return Objects.equals(lectores, lectores.lectores);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lectores);
    }

    @Override
    public String toString() {
        return "{" +
            " lectores='" + getLectores() + "'" +
            "}";
    }


}
