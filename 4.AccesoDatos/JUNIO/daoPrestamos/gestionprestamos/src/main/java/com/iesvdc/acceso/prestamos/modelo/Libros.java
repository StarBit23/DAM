package com.iesvdc.acceso.prestamos.modelo;

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


@XmlRootElement(name = "libros")
@XmlAccessorType (XmlAccessType.FIELD)
public class Libros {
    Libro libroSend = new Libro();

    @XmlElement(name="libro")
    List <Libro> libros = new ArrayList<Libro>();
    
    List <String> titulos = new ArrayList<String>();
    List <String> autores = new ArrayList<String>();
    List <String> editoriales = new ArrayList<String>();

    public Libro returnLibro(){
        return libroSend;
    }

    public boolean add(Libro libro){
        return this.libros.add(libro);
    }

    public List<Libro>findAll(){
        return libros;
    }

    public Libros() {
        this.libros = new ArrayList<Libro>();
    }

    public boolean loadTitulos(String filename){
        try {
            Scanner myScanner = new Scanner(new File(filename));
            while (myScanner.hasNextLine()) {
                this.titulos.add(myScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("::ERROR:LIBROS::loadTitulos"+e.getLocalizedMessage());
        }
        return this.titulos.size() > 0 ? true : false;
    }

    public boolean loadAutores(String filename){
        try {
            Scanner myScanner = new Scanner(new File(filename));
            while (myScanner.hasNextLine()) {
                this.autores.add(myScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("::ERROR:LIBROS::loadAutores"+e.getLocalizedMessage());
        }
        return this.autores.size() > 0 ? true : false;
    }

    public boolean loadEditorial(String filename){
        try {
            Scanner myScanner = new Scanner(new File(filename));
            while (myScanner.hasNextLine()) {
                this.editoriales.add(myScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("::ERROR:LIBROS::loadEditoriales"+e.getLocalizedMessage());
        }
        return this.editoriales.size() > 0 ? true : false;
    }

    public boolean loadLibros(String titulosFilename, String autoresFilename, String editorialesFilename){
        Random rand = new Random();
        boolean resultado = true;
        resultado = resultado && loadTitulos(titulosFilename);
        resultado = resultado && loadAutores(autoresFilename);
        resultado = resultado && loadEditorial(editorialesFilename);

        if (resultado) {
            for (int i=0; i<1; i++) {
                int id = i+1;
                String titulo = this.titulos.get(rand.nextInt(this.titulos.size()));
                String autor = this.autores.get(rand.nextInt(this.autores.size()));
                String isbnString1 = Integer.toString((rand.nextInt(9)+1));
                String isbnString2 = Integer.toString((rand.nextInt(9)+1));
                String isbnString3 = Integer.toString((rand.nextInt(9)+1));
                String isbnString4 = Integer.toString((rand.nextInt(9)+1));
                String isbnString5 = Integer.toString((rand.nextInt(9)+1));
                String isbnString6 = Integer.toString((rand.nextInt(9)+1));
                String isbnString7 = Integer.toString((rand.nextInt(9)+1));
                String isbnString8 = Integer.toString((rand.nextInt(9)+1));
                String isbnString9 = Integer.toString((rand.nextInt(9)+1));
                String isbnString10 = Integer.toString((rand.nextInt(9)+1));
                String isbnString11 = Integer.toString((rand.nextInt(9)+1));
                String isbnString12 = Integer.toString((rand.nextInt(9)+1));
                String isbnString13 = Integer.toString((rand.nextInt(9)+1));
                String isbn = isbnString1+isbnString2+isbnString3+isbnString4+isbnString5+isbnString6+isbnString7+isbnString8+isbnString9
                    +isbnString10+isbnString11+isbnString12+isbnString13;
                int edicion = rand.nextInt(3)+1;
                String editorial = this.editoriales.get(rand.nextInt(this.editoriales.size()));

                this.libros.add(new Libro(id, isbn, titulo, autor, edicion, editorial, 2022));

                libroSend = new Libro(id, isbn, titulo, autor, edicion, editorial, 2022);
            }
        }
        
        return resultado;
    }

    public Libros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Libro> getLibros() {
        return this.libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public Libros libros(List<Libro> libros) {
        setLibros(libros);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lectores)) {
            return false;
        }
        Libros libros = (Libros) o;
        return Objects.equals(libros, libros.libros);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(libros);
    }

    @Override
    public String toString() {
        return "{" +
            " libros='" + getLibros() + "'" +
            "}";
    }


}
