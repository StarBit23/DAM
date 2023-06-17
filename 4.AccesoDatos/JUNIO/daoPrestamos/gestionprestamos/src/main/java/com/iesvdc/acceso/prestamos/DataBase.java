package com.iesvdc.acceso.prestamos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.iesvdc.acceso.prestamos.dao.PrestamoDao;
import com.iesvdc.acceso.prestamos.daoimp.PrestamoDaoImp;
import com.iesvdc.acceso.prestamos.modelo.Prestamo;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class DataBase {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Prestamo> prestamos;

        try (Reader reader = new FileReader("docs/prestamos.json")) {
            Type prestamoListType = new TypeToken<List<Prestamo>>() {}.getType();
            prestamos = gson.fromJson(reader, prestamoListType);

            if (prestamos != null) {
                for (Prestamo prestamo : prestamos) {
                    System.out.println(prestamo.toString());

                    PrestamoDao prestamoDao = new PrestamoDaoImp();
                    prestamoDao.create(prestamo);
                    Prestamo prestamoFromDb = prestamoDao.findById(prestamo.getId());
                    System.out.println(prestamoFromDb.toString());
                }
            } else {
                System.out.println("Error al cargar el JSON.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
