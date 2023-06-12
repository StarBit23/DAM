package com.iesvdc.acceso.prestamos.modelo;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "cps")
@XmlAccessorType (XmlAccessType.FIELD)
public class CPs {
    @XmlElement(name="cp")
    List<CP> cps;
    

    public CPs() {
        this.cps = new ArrayList<CP>();
    }

    public boolean add(CP cp){
        return this.cps.add(cp);
    }

    public CP get(int index){
        return cps.size()<index ? null : cps.get(index);
    }
    
    public int size(){
        return cps.size();
    }

    public List<CP>findAll(){
        return cps;
    }

    public boolean load(String filename){
        final boolean resultado = true;
        Path filePath = Paths.get(filename);
        Charset charset = StandardCharsets.UTF_8;

        try {
            Files.lines(filePath, charset).forEach(
                (String linea) -> {
                    String[] datos = linea.split(",");
                    this.cps.add(new CP(
                        datos[0], datos[1].trim()
                    ));
                }
            );
        } catch (Exception e) {
            System.out.println("Revisa tu codigo, que 'ta maaaaal");
        }
        return this.cps.size()>0 ? true : false;
    }

    public CPs(List<CP> cps) {
        this.cps = cps;
    }

    public List<CP> getCps() {
        return this.cps;
    }

    public void setCps(List<CP> cps) {
        this.cps = cps;
    }

    public CPs cps(List<CP> cps) {
        setCps(cps);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CPs)) {
            return false;
        }
        CPs cPs = (CPs) o;
        return Objects.equals(cps, cPs.cps);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cps);
    }

    @Override
    public String toString() {
        return "{" +
            " cps='" + getCps() + "'" +
            "}";
    }

}
