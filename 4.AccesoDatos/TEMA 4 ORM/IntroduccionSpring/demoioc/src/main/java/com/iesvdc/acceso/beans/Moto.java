package com.iesvdc.acceso.beans;

public class Moto {
    private String marca;
    private String modelo;

    public Moto(){

    }

    public Moto(String ma, String mo){
        this.marca  = ma;
        this.modelo = mo;
    }
    /**
     * @return String return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return String return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String toString(){
        return ":Moto:: marca::"+this.marca+" modelo::"+this.modelo;
    }
}