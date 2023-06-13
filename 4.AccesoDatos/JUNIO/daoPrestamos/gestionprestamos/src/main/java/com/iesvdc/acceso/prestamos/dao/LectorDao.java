package com.iesvdc.acceso.prestamos.dao;

import java.util.List;

import com.iesvdc.acceso.prestamos.modelo.Lector;

public interface LectorDao {

    public boolean create(Lector u);

    /**
     * Busca en la base de datos estancias por su identificador.
     * 
     * @param id número entero positivo
     * @return null si no está ese id, la Estancia en caso contrario.
     */
    public Lector findById(int id);

    public List<Lector> findAll();

    public Lector findByNombre(String nombre);

    public boolean update(Lector o, Lector n);

    public boolean update(int id, Lector n);

    public boolean delete(Lector u);

    public boolean delete(int id);

    public int count();
}
