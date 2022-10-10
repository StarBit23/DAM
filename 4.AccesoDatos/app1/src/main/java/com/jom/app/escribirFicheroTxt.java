package com.jom.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class escribirFicheroTxt {
    public static void main(String[] args) throws IOException {
        File file = new File("fichero.txt");
        Scanner sc = new Scanner(System.in);

        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }

        //creamos el fichero
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        //toca escribir
        System.out.println("Escribe algo, lo enviaré a un fichero de texto");
        String texto = sc.nextLine();
        bw.write(texto);
        bw.close();
    }
}
