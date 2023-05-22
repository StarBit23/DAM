package com.jorgeortega;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.jorgeortega.clases.CPs;
import com.jorgeortega.clases.Direcciones;
import com.jorgeortega.clases.Lector;
import com.jorgeortega.clases.Lectores;
import com.jorgeortega.clases.Libro;
import com.jorgeortega.clases.Libros;
import com.jorgeortega.clases.Operario;
import com.jorgeortega.clases.Operarios;
import com.jorgeortega.clases.Prestamo;

/**
 * Ejemplo de generador de personas.
 *
 */
public class MarshallerJson {
    public static void main(String[] args) {
        CPs cps = new CPs();
        cps.load("docs/cp.txt");

        Direcciones direcciones = new Direcciones();
        direcciones.load("docs/direccion.txt", cps);

        Lectores lectores = new Lectores();
        lectores.loadLectores("docs/nombres.txt", "docs/apellidos.txt", direcciones);

        Libros libros = new Libros();
        libros.loadLibros("docs/titulosLibros.txt", "docs/autoresLibros.txt", "docs/editorialLibros.txt");

        Operarios operarios = new Operarios();
        operarios.loadOperarios("docs/nombres.txt", "docs/apellidos.txt");

        List<Prestamo> prestamos = new ArrayList<>();

        // Generar varios préstamos aquí, por ejemplo, en un bucle
        for (int i = 0; i < 5; i++) {
            Lector lector = lectores.returnLector();
            Libro libro = libros.returnLibro();
            Operario operario = operarios.returnOperario();
            Prestamo prestamo = new Prestamo(lector, libro, operario);
            prestamos.add(prestamo);
        }

        JAXBContext jaxbContext;

        try {
            System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

            jaxbContext = JAXBContext.newInstance(Prestamo.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Para JSON
            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

            // Marshalling y escritura en el archivo JSON
            jaxbMarshaller.marshal(prestamos, new File("docs/prestamos.json"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}


