package com.jorgeortega.clases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "operarios")
@XmlAccessorType (XmlAccessType.FIELD)
public class Operarios {
    Operario operarioSend = new Operario();

    

    @XmlElement(name="operario")
    List <Operario> operarios = new ArrayList<Operario>();

    List <String> apellidos = new ArrayList<String>();
    List <String> nombres = new ArrayList<String>();

    public Operario returnOperario(){
        return operarioSend;
    }

    public boolean add(Operario operario){
        return this.operarios.add(operario);
    }

    public List<Operario>findAll(){
        return operarios;
    }

    public Operarios() {
        this.operarios = new ArrayList<Operario>();
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

    public boolean loadOperarios(String nombresFilename, String apellidosFilename){
        Random rand = new Random();
        boolean resultado = true;
        resultado = resultado && loadNombres(nombresFilename);
        resultado = resultado && loadApellidos(apellidosFilename);

        if (resultado) {
            for (int i=0; i<1; i++) {
                int id = i+1;
                String nombre = this.nombres.get(rand.nextInt(this.nombres.size()));
                String apellido = this.apellidos.get(rand.nextInt(this.apellidos.size()));
                String username = nombre.toLowerCase().substring(0, 1)+apellido.split(" ")[0].toLowerCase();
                String email = username + "@gmail.com";
                String password = "Secreto123";

                this.operarios.add(new Operario(id, username, password, email));

                operarioSend = new Operario(id, username, password, email);
            }
        }
        
        return resultado;
    }

    public Operarios(List<Operario> operarios) {
        this.operarios = operarios;
    }

    public List<Operario> getOperarios() {
        return this.operarios;
    }

    public void setOperarios(List<Operario> operarios) {
        this.operarios = operarios;
    }

    public Operarios operarios(List<Operario> operarios) {
        setOperarios(operarios);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Operarios)) {
            return false;
        }
        Operarios operarios = (Operarios) o;
        return Objects.equals(operarios, operarios.operarios);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(operarios);
    }

    @Override
    public String toString() {
        return "{" +
            " operarios='" + getOperarios() + "'" +
            "}";
    }


}
