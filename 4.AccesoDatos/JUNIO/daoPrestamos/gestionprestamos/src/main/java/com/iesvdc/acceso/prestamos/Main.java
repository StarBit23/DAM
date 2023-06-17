package com.iesvdc.acceso.prestamos;

import com.iesvdc.acceso.prestamos.daoimp.LibroDaoImp;
import com.iesvdc.acceso.prestamos.modelo.Libro;

public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro(0, "123456","Pepe Libro", "Pepe", 1, "Anaya", 2023);

        LibroDaoImp libroDaoImp = new LibroDaoImp();
        libroDaoImp.create(libro);
    }
}
