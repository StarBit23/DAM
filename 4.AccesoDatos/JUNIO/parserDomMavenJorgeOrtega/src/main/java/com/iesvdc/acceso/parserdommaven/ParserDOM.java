package com.iesvdc.acceso.parserdommaven;

import java.util.Scanner;
import net.sf.saxon.s9api.*;

/**
 * Programa para probar expresiones xPath 
 * Con el pom.xml actual ejecuta "mvn exec:java"
 * @author jgutierrez AT iesvirgendelcarmen.com
 */
public class ParserDOM {

    /**
     * Este programa ejecuta indefinidas expresiones xPath contra el fichero
     * XML que se le pase como parámetro.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args){
        SaxonUtil saut;
        String leido="exit";
        XdmValue arbol;
        if (args.length==1) {
        // hacemos un try con recursos
        // Scanner es closeable, luego no hace falta hacer scan.clkose() porque 
        // se hace sólo por haberlo puesto en este try
        try (Scanner scan = new Scanner(System.in)){
            saut = new SaxonUtil(args[0]);
            System.out.println("Escriba la expresión xPath para ejecutar contra el fichero: "+
                    args[0]+".\n Escribe exit para terminar.");                    
            do {
                leido = scan.nextLine();
                arbol = saut.runXPath(leido);
                System.out.println(saut.xdm2string(arbol));
            }while (!leido.equals("exit"));            
        } catch (Exception ex) {
            System.out.println("ERROR:: "+ex.getLocalizedMessage());
        }
        } else {
            System.out.println("Uso del programa: \n ParserDOM fichero.xml\n");
        }
        
    }
    
}
