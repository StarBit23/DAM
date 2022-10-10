package com.jom.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Random random = new Random();
        //NOMBRE
        List<String> listaNombres = new ArrayList<String>(Arrays.asList("Pepe ","Ana ","Lorenzo ","Antonio ","Miguel "));
        int nombreR = random.nextInt(listaNombres.size());

        //APELLIDOS
        List<String> listaApellidos = new ArrayList<String>(Arrays.asList("García ","Ortega ","Fernández ","González ","Castillo ","Martínez ","Rodriguez ","Ruiz ","Jimenez ","Ramírez "));
        List<String> listaApellidos2 = new ArrayList<String>(Arrays.asList("Martínez","Rodriguez","Ruiz","Jimenez","Ramírez","García","Ortega","Fernández","González","Castillo"));
        int apellidoR = random.nextInt(listaNombres.size());
        System.out.println("Nombre y apellidos: "+listaNombres.get(nombreR)+listaApellidos.get(apellidoR)+listaApellidos2.get(apellidoR)+"\n");

        //CORREO
        List<String> listaCorreo1 = new ArrayList<String>(Arrays.asList("pepeillo","miguelilloMessi","tontoelquelolea","bts19lover","pedrotrabajo"));
        int numeroCorreo = random.nextInt(100);
        List<String> listaCorreo2 = new ArrayList<String>(Arrays.asList("yahoo","gmail","hotmail","santander","zoho","outlook","caixabank"));
        List<String> listaCorreo3 = new ArrayList<String>(Arrays.asList(".net",".com",".es",".eu",".me",".us",".ru"));
        int correo1R = random.nextInt(listaCorreo1.size());
        int correo2R = random.nextInt(listaCorreo2.size());
        int correo3R = random.nextInt(listaCorreo3.size());
        int dado = random.nextInt(3);
        if (dado == 1){
            int numeroCorreo2 = random.nextInt(999);
            System.out.println("CORREO: "+listaCorreo1.get(correo1R)+numeroCorreo+numeroCorreo2+"@"+listaCorreo2.get(correo2R)+listaCorreo3.get(correo3R));
        }else if (dado==2){
            int numeroCorreo3 = random.nextInt(10);
            System.out.println("CORREO: "+listaCorreo1.get(correo1R)+numeroCorreo+numeroCorreo3+"@"+listaCorreo2.get(correo2R)+listaCorreo3.get(correo3R));
        } else {
            System.out.println("CORREO: "+listaCorreo1.get(correo1R)+numeroCorreo+"@"+listaCorreo2.get(correo2R)+listaCorreo3.get(correo3R));
        }



        //DNI
        String vocales = "TRWAGMYFPDXBNJZSQVHLCKE";

        int numero = 0;
        for (int i=0;i<8;i++){
            numero += random.nextInt(10) * (Math.pow(10,i));
        }

        int mod = numero % 23;
        String charActual = String.valueOf(vocales.charAt(mod));
        System.out.println("DNI: "+numero+charActual);


        //DIRECCION Y CODIGO POSTAL
        BufferedReader rd = new BufferedReader( new FileReader("FICHEROS/codprov.csv"));
        String line = null;
        ArrayList listaDireccion = new ArrayList();
        String[] linea;
        while ((line = rd.readLine()) != null) {
            line = rd.readLine();
            //System.out.println(line);
            linea = line.split(",");
            listaDireccion.add(linea);
        }
        int direccionR = random.nextInt(listaDireccion.size());
        System.out.println(listaDireccion.get(direccionR));



    }
}
