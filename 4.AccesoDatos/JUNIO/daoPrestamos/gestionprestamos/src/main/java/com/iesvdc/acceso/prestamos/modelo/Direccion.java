package com.iesvdc.acceso.prestamos.modelo;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "direccion")
@XmlAccessorType (XmlAccessType.FIELD)
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

    public Direccion(TipoVia tipoVia, String nombreVia, int numero, char portal, int planta, CP cp) {
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.numero = numero;
        this.portal = portal;
        this.planta = planta;
        this.cp = cp;
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

    public String getCp() {
        return cp.getCp();
    }

    public void setCp(CP cp) {
        this.cp = cp;
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
            "tipoVia='" + getTipoVia() + "'" +
            ", nombreVia='" + getNombreVia() + "'" +
            ", numero='" + getNumero() + "'" +
            ", portal='" + getPortal() + "'" +
            ", planta='" + getPlanta() + "'" +
            ", cp='" + getCp() + "'" +
            "}";
    }

    


}
