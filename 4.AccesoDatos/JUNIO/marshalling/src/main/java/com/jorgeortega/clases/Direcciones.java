package com.jorgeortega.clases;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "direcciones")
@XmlAccessorType (XmlAccessType.FIELD)
public class Direcciones {
    @XmlElement(name="direccion")
    List<Direccion> direcciones;

    public Direcciones() {
        this.direcciones = new ArrayList<>();
    }

    public boolean add(Direccion direccion){
        return this.direcciones.add(direccion);
    }

    public List<Direccion>findAll(){
        return direcciones;
    }

    public Direccion getRandomDireccion(){
        Random rand = new Random();
        return this.direcciones.get(rand.nextInt(this.direcciones.size()));
    }

    public boolean load(String filename, CPs cps){
        Path path = Paths.get(filename);
        TipoVia tipoVia;
        String nombreVia;
        Random random = new Random();
        int contador = 0;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String linea = br.readLine();
            if (linea != null) {
                linea = br.readLine();
            } while (linea!=null) {
                String datos[] = linea.split(",");

                tipoVia = TipoVia.valueOf(datos[0].toUpperCase());
                nombreVia = datos[1].trim();

                Direccion direccion = new Direccion(
                    tipoVia,
                    nombreVia,
                    random.nextInt(100),
                    '1',
                    random.nextInt(10),
                    cps.get(random.nextInt(cps.size())));
                this.direcciones.add(direccion);
                linea = br.readLine();
                contador++;
            }
        } catch (Exception e) {
            System.out.println("ERROR DIRECCIONES: " + e.getLocalizedMessage());
        }
        return this.direcciones.size()>0 ? true : false;
    }

    public Direcciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Direccion> getDirecciones() {
        return this.direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Direcciones direcciones(List<Direccion> direcciones) {
        setDirecciones(direcciones);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Direcciones)) {
            return false;
        }
        Direcciones direcciones = (Direcciones) o;
        return Objects.equals(direcciones, direcciones.direcciones);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(direcciones);
    }

    @Override
    public String toString() {
        return "{" +
            " direcciones='" + getDirecciones() + "'" +
            "}";
    }

}
