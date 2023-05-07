package com.jorgeortega;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;

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
public class MarshallerJson
{
    public static void main( String[] args )
    {
        Lectores lectores = new Lectores();
        Lector lectorFinal = new Lector();
        lectorFinal = lectores.returnLector();

        Libros libros = new Libros();
        Libro libroFinal = new Libro();
        libroFinal = libros.returnLibro();

        Operarios operarios = new Operarios();
        Operario operarioFinal = new Operario();
        operarioFinal = operarios.returnOperario();


        Prestamo prestamo = new Prestamo(lectorFinal, libroFinal, operarioFinal);
        JAXBContext jaxbContext;

        try {
            System.setProperty("javax.xml.bind.JAXBContextFactory","org.eclipse.persistence.jaxb.JAXBContextFactory");

            jaxbContext = JAXBContext.newInstance(prestamo.getClass());

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
           
            //Para JSON
            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

            jaxbMarshaller.marshal(prestamo, new File("docs/prestamos.json"));
            
            /* jaxbContext = JAXBContext.newInstance(lista.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Object objeto = jaxbUnmarshaller.unmarshal(new File("personas.xml"));
            lista = (Personas) objeto;
            System.out.println(lista.toString());*/

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
    }
}

