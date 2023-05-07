package com.jorgeortega;

import com.jorgeortega.clases.*;;;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "======= CODIGOS POSTALES =======" );
        CPs cps = new CPs();
        cps.load("docs/cp.txt");
        //System.out.println(cps.toString());
        //System.out.println("\n");

        System.out.println( "======= DIRECCIONES =======" );
        Direcciones direcciones = new Direcciones();
        direcciones.load("docs/direccion.txt",cps);
        //System.out.println(direcciones.toString());
        //System.out.println("\n");

        System.out.println( "======= LECTORES =======" );
        Lectores lectores = new Lectores();
        lectores.loadLectores("docs/nombres.txt", "docs/apellidos.txt",direcciones);
        //System.out.println(lectores.toString());
        //System.out.println("\n");

        System.out.println( "======= LIBROS =======" );
        Libros libros = new Libros();
        libros.loadLibros("docs/titulosLibros.txt", "docs/autoresLibros.txt", "docs/editorialLibros.txt");
        //System.out.println(libros.toString());
        //System.out.println("\n");

        System.out.println( "======= OPERARIOS =======" );
        Operarios operarios = new Operarios();
        operarios.loadOperarios("docs/nombres.txt", "docs/apellidos.txt");
        //System.out.println(operarios.toString());
        //System.out.println("\n");

        System.out.println( "======= PRESTAMOS =======" );
        Lector lectorFinal = new Lector();
        lectorFinal = lectores.returnLector();

        Libro libroFinal = new Libro();
        libroFinal = libros.returnLibro();

        Operario operarioFinal = new Operario();
        operarioFinal = operarios.returnOperario();

        Prestamo prestamos = new Prestamo(lectorFinal, libroFinal, operarioFinal);
        System.out.println(prestamos.toString());

        

    }
}
