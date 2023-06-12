package com.jorgeortega;

import java.util.ArrayList;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.jorgeortega.clases.CPs;
import com.jorgeortega.clases.Direcciones;
import com.jorgeortega.clases.Lector;
import com.jorgeortega.clases.Lectores;
import com.jorgeortega.clases.Libro;
import com.jorgeortega.clases.Libros;
import com.jorgeortega.clases.Operario;
import com.jorgeortega.clases.Operarios;
import com.jorgeortega.clases.Prestamo;

public class NewMarshaller {
    public static void main(String[] args) {        
        try {
            /**
             * La clase JAXBContext proporciona el punto de entrada del cliente a la API de JAXB
             */
            JAXBContext jaxbContext = JAXBContext.newInstance(Prestamo.class);            
            /**
             * La clase Marshaller proporciona a la aplicación cliente la capacidad 
             * de convertir un árbol de contenido Java en datos XML. 
             */
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            /**
             * Creamos una objeto cliente y agregamos algunos datos
             */
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
            
            /**
             * Se definen algunas propiedades standar
             */            
            //Datos formateados con salto de linea y sangria
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Especifica el valor del atributo xsi: schemaLocation para colocar en la salida XML 
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
            //Codificacion de salida
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");            
            //El nombre del esquemaXSD para el atributo xsi: noNamespaceSchemaLocation
            jaxbMarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "miesquema.xsd");
            
            /**
             * Se genera el XML y se muestra en consola
             */
            jaxbMarshaller.marshal(prestamo, System.out);                                   
            
        } catch (JAXBException ex) {
            System.err.println(ex.getMessage());                        
        }        
    }
}
