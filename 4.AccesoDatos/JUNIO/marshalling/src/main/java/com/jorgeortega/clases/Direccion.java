package com.jorgeortega.clases;

import java.util.Objects;

public class Direccion {
    public int id;
    public TipoVia tipoVia;
    public String nombreVia;
    public int numero;
    public char portal;
    public int planta;
    public CP cp;


    public Direccion() {
    }

    public Direccion(int id, TipoVia tipoVia, String nombreVia, int numero, char portal, int planta, CP cp) {
        this.id = id;
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.numero = numero;
        this.portal = portal;
        this.planta = planta;
        this.cp = cp;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoVia getTipoVia() {
        return this.tipoVia;
    }

    public void setTipoVia(TipoVia tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return this.nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getPortal() {
        return this.portal;
    }

    public void setPortal(char portal) {
        this.portal = portal;
    }

    public int getPlanta() {
        return this.planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public CP getCp() {
        return this.cp;
    }

    public void setCp(CP cp) {
        this.cp = cp;
    }

    public Direccion id(int id) {
        setId(id);
        return this;
    }

    public Direccion tipoVia(TipoVia tipoVia) {
        setTipoVia(tipoVia);
        return this;
    }

    public Direccion nombreVia(String nombreVia) {
        setNombreVia(nombreVia);
        return this;
    }

    public Direccion numero(int numero) {
        setNumero(numero);
        return this;
    }

    public Direccion portal(char portal) {
        setPortal(portal);
        return this;
    }

    public Direccion planta(int planta) {
        setPlanta(planta);
        return this;
    }

    public Direccion cp(CP cp) {
        setCp(cp);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Direccion)) {
            return false;
        }
        Direccion direccion = (Direccion) o;
        return id == direccion.id && Objects.equals(tipoVia, direccion.tipoVia) && Objects.equals(nombreVia, direccion.nombreVia) && numero == direccion.numero && portal == direccion.portal && planta == direccion.planta && Objects.equals(cp, direccion.cp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoVia, nombreVia, numero, portal, planta, cp);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", tipoVia='" + getTipoVia() + "'" +
            ", nombreVia='" + getNombreVia() + "'" +
            ", numero='" + getNumero() + "'" +
            ", portal='" + getPortal() + "'" +
            ", planta='" + getPlanta() + "'" +
            ", cp='" + getCp() + "'" +
            "}";
    }

    


}
