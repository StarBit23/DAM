package com.jorgeortega;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.jorgeortega.clases.CPs;
import com.jorgeortega.clases.Direcciones;
import com.jorgeortega.clases.Lector;
import com.jorgeortega.clases.Lectores;
import com.jorgeortega.clases.Libro;
import com.jorgeortega.clases.Libros;
import com.jorgeortega.clases.Operario;
import com.jorgeortega.clases.Operarios;
import com.jorgeortega.clases.Prestamo;

public class UnmarshallerXml 
{
    public static void main( String[] args )
    {
        CPs cps = new CPs();
        cps.load("docs/cp.txt");

        Direcciones direcciones = new Direcciones();
        direcciones.load("docs/direccion.txt",cps);

        Lectores lectores = new Lectores();
        lectores.loadLectores("docs/nombres.txt", "docs/apellidos.txt",direcciones);
        Lector lectorFinal = new Lector();
        lectorFinal = lectores.returnLector();

        Libros libros = new Libros();
        libros.loadLibros("docs/titulosLibros.txt", "docs/autoresLibros.txt", "docs/editorialLibros.txt");
        Libro libroFinal = new Libro();
        libroFinal = libros.returnLibro();

        Operarios operarios = new Operarios();
        operarios.loadOperarios("docs/nombres.txt", "docs/apellidos.txt");
        Operario operarioFinal = new Operario();
        operarioFinal = operarios.returnOperario();


        Prestamo prestamo = new Prestamo(lectorFinal, libroFinal, operarioFinal);
        JAXBContext jaxbContext;

        try {
            
            jaxbContext = JAXBContext.newInstance(prestamo.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Object objeto = jaxbUnmarshaller.unmarshal(new File("personas.xml"));
            prestamo = (Prestamo) objeto;
            System.out.println(prestamo.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
    }
}
