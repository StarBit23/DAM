package com.iesvdc.acceso.prestamos.dao;

import java.util.List;

import com.iesvdc.acceso.prestamos.modelo.Libro;

public interface LibroDao {

    public boolean create(Libro i);

    public Libro findById(int id);

    public Libro findByTitulo(String title);

    public boolean update(Libro o, Libro n);

    public boolean update(int id, Libro n);

    public boolean delete(Libro i);

    public boolean delete(int id);

    public List<Libro> findAll();

    public int count();
}
