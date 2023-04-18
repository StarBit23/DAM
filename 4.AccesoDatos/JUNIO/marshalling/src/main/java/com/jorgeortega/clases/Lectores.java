package com.jorgeortega.clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import org.xml.sax.SAXException;

public class Lectores {
    List <Lector> lectores;
    List <String> apellidos;
    List <String> nombres;

    public boolean add(Lector lector){
        return this.lectores.add(lector);
    }

    public List<Lector>findAll(){
        return lectores;
    }

    public Lectores() {
        this.lectores = new ArrayList<Lector>();
    }

    public boolean loadNombres(String filename){
        try {
            Scanner myScanner = new Scanner(new File(filename));
            while (myScanner.hasNextLine()) {
                this.nombres.add(myScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("::ERROR:LECTORES::loadNombres"+e.getLocalizedMessage());
        }
        return this.nombres.size() > 0 ? true : false;
    }

    public boolean loadApellidos(String filename){
        try {
            Scanner myScanner = new Scanner(new File(filename));
            while (myScanner.hasNextLine()) {
                this.apellidos.add(myScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("::ERROR:LECTORES::loadNombres"+e.getLocalizedMessage());
        }
        return this.nombres.size() > 0 ? true : false;
    }

    public boolean loadLectores(String nombresFilename, String apellidosFilename, Direcciones direcciones){
        Random rand = new Random();
        boolean resultado = true;
        resultado = resultado && loadNombres(nombresFilename);
        resultado = resultado && loadApellidos(apellidosFilename);

        if (resultado) {
            for (int i=0; i<10; i++) {
                int id = i;
                String nombre = this.nombres.get(rand.nextInt(this.nombres.size()));
                String apellido = this.apellidos.get(rand.nextInt(this.apellidos.size()));
                String username = nombre.toLowerCase().substring(0, 1)+apellido.split(" ")[0].toLowerCase();
                String email = username + "@gmail.com";
                int telefono = rand.nextInt(200000000)+000000000;
                Direccion direccion = direcciones.getRandomDireccion();
                String password = "Secreto123";

                this.lectores.add(new Lector(
                    id, username, password, email, telefono, direccion, 
                    nombre, apellido));
            }
        }
        
        return resultado;
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
