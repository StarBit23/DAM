package com.jorgeortega;

public class CP {
    public String cp;
    public String localidad;

    public CP(String cp, String localidad) {
        this.cp = cp;
        this.localidad = localidad;
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
