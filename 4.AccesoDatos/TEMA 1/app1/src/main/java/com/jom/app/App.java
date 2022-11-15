package com.jom.app;

import java.io.IOException;
import java.util.*;


public class App 
{
    public static void main( String[] args ) throws IOException {
        Random random = new Random();

        System.out.println(generarNombre());
        //NOMBRE


        System.out.println(generarApellidos());
        //APELLIDOS


        System.out.println(generarCorreo());
        //CORREO

        System.out.println(generarDni());
        //DNI


        System.out.println(generarDireccion());
        //DIRECCION Y CODIGO POSTAL



//        String nombre;
//        String apellidos;
//        String correo;
//        String dni;
//        String direccion;
//
//        List<Persona> listaPersonas = new ArrayList<>();
//        for (int i = 0;i<20;i++){
//            nombre = generarNombre();
//            apellidos = generarApellidos();
//            correo = generarCorreo();
//            dni = generarDni();
//            direccion = generarDireccion();
//            listaPersonas.add(new Persona(nombre,apellidos,correo,dni,direccion));
//        }
//
//
//        for (Persona persona:listaPersonas){
//            System.out.println(persona);
//        }

    }

    private static String generarDireccion() {
        Random random = new Random();
        List<String> listaCiudades = new ArrayList<>();
        listaCiudades.add("Jaen,23000");
        listaCiudades.add("Gerona,17000");
        listaCiudades.add("Toledo,45000");
        listaCiudades.add("Malaga,29000");
        listaCiudades.add("Melilla,52000");
        listaCiudades.add("Cuenca,16000");
        listaCiudades.add("Alava,01000");
        listaCiudades.add("Huesca,22000");
        listaCiudades.add("Albacete,02000");
        listaCiudades.add("Alicante,03000");
        listaCiudades.add("Badajoz,06000");
        listaCiudades.add("Cadiz,11000");
        listaCiudades.add("Guadalajara,19000");
        listaCiudades.add("Avila,05000");
        int direccionR = random.nextInt(listaCiudades.size());
        //System.out.println("Dirección: "+listaCiudades.get(direccionR));
        String direccion = listaCiudades.get(direccionR);
        return direccion;
    }

    private static String generarDni() {
        Random random = new Random();
        String vocales = "TRWAGMYFPDXBNJZSQVHLCKE";
        String dni;
        do {
            int numero = 0;
            for (int i=0;i<8;i++){
                numero += random.nextInt(10) * (Math.pow(10,i));
            }

            int mod = numero % 23;
            String charActual = String.valueOf(vocales.charAt(mod));
            //System.out.println("DNI: "+numero+charActual);
            dni=numero+charActual;
            return dni;
        }while (dni.length()==8);

    }

    private static String generarCorreo() {
        Random random = new Random();
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
            String correoRandom1=listaCorreo1.get(correo1R)+numeroCorreo+numeroCorreo2+"@"+listaCorreo2.get(correo2R)+listaCorreo3.get(correo3R);
            return correoRandom1;
        }else if (dado==2){
            int numeroCorreo3 = random.nextInt(99);
            String correoRandom2=listaCorreo1.get(correo1R)+numeroCorreo+numeroCorreo3+"@"+listaCorreo2.get(correo2R)+listaCorreo3.get(correo3R);
            return correoRandom2;
        } else {
           String correo=listaCorreo1.get(correo1R)+numeroCorreo+"@"+listaCorreo2.get(correo2R)+listaCorreo3.get(correo3R);
            return correo;
        }

    }

    private static String generarApellidos() {
        Random random = new Random();
        List<String> listaApellidos = new ArrayList<String>(Arrays.asList("García ","Ortega ","Fernández ","González ","Castillo ","Martínez ","Rodriguez ","Ruiz ","Jimenez ","Ramírez "));
        List<String> listaApellidos2 = new ArrayList<String>(Arrays.asList("Martínez","Rodriguez","Ruiz","Jimenez","Ramírez","García","Ortega","Fernández","González","Castillo"));
        int apellidoR = random.nextInt(listaApellidos.size());
        //System.out.println("Nombre y apellidos: "+listaNombres.get(nombreR)+listaApellidos.get(apellidoR)+listaApellidos2.get(apellidoR)+"\n");
        String apellidos=listaApellidos.get(apellidoR) + listaApellidos2.get(apellidoR);
        return apellidos;
    }

    private static String generarNombre() {
        Random random = new Random();
        List<String> listaNombres = new ArrayList<String>(Arrays.asList("Pepe ","Ana ","Lorenzo ","Antonio ","Miguel "));
        int nombreR = random.nextInt(listaNombres.size());
        String nombre=listaNombres.get(nombreR);
        return nombre;
    }


}
