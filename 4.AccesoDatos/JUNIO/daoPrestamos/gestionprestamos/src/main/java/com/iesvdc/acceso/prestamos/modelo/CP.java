package com.iesvdc.acceso.prestamos.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cp")
@XmlAccessorType (XmlAccessType.FIELD)
public class CP {
    public String cp;
    public String localidad;

    public CP(String cp, String localidad) {
        this.cp = cp;
        this.localidad = localidad;
    }

    public CP() {
        
    }

    public String getCp() {
        return this.cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public CP cp(String cp) {
        setCp(cp);
        return this;
    }

    public CP localidad(String localidad) {
        setLocalidad(localidad);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " cp='" + getCp() + "'" +
            ", localidad='" + getLocalidad() + "'" +
            "}";
    }

}
