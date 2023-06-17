package com.iesvdc.acceso.prestamos.dao;

import java.util.List;

import com.iesvdc.acceso.prestamos.modelo.Operario;
import com.iesvdc.acceso.prestamos.modelo.Prestamo;
import com.iesvdc.acceso.prestamos.modelo.Libro;
import com.iesvdc.acceso.prestamos.modelo.Lector;

public interface PrestamoDao {

    public boolean create(Prestamo i);

    public Prestamo findById(int id);

    public Prestamo findByNombre(String nombre);

    public Prestamo findByLibro(Libro l);

    public Prestamo findByOperario(Operario o);

    public Prestamo findByLector(Lector u);

    public boolean update(Prestamo o, Prestamo n);

    public boolean update(int id, Prestamo n);

    public boolean delete(Prestamo i);

    public boolean delete(int id);

    public List<Prestamo> findAll();

    public int count();
}
