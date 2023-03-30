package com.jorgeortega;

public class Direccion {
    public int id;
    public String tipoVia;
    public String nombreVia;
    public CP cp;


    public Direccion(int id, String tipoVia, String nombreVia, CP cp) {
        this.id = id;
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.cp = cp;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoVia() {
        return this.tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return this.nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public CP getCp() {
        return this.cp;
    }

    public void setCp(CP cp) {
        this.cp = cp;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", tipoVia='" + getTipoVia() + "'" +
            ", nombreVia='" + getNombreVia() + "'" +
            ", cp='" + getCp() + "'" +
            "}";
    }

}
