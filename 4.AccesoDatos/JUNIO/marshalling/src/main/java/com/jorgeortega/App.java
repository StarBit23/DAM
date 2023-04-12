package com.jorgeortega;

import com.jorgeortega.clases.*;;;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "======= CODIGOS POSTALES =======" );
        CPs cps = new CPs();
        cps.load("docs/cp.txt");
        System.out.println(cps.toString());
        System.out.println("\n");

        System.out.println( "======= DIRECCIONES =======" );
        Direcciones direcciones = new Direcciones();
        direcciones.load("docs/direccion.txt",cps);
        System.out.println(direcciones.toString());
    }
}
