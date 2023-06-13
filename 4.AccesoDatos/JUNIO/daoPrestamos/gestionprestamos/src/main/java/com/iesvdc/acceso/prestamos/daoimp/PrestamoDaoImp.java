package com.iesvdc.acceso.prestamos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesvdc.acceso.prestamos.conexion.Conexion;
import com.iesvdc.acceso.prestamos.dao.LibroDao;
import com.iesvdc.acceso.prestamos.dao.PrestamoDao;
import com.iesvdc.acceso.prestamos.modelo.Lector;
import com.iesvdc.acceso.prestamos.modelo.Libro;
import com.iesvdc.acceso.prestamos.modelo.Operario;
import com.iesvdc.acceso.prestamos.modelo.Prestamo;

public class PrestamoDaoImp implements PrestamoDao {

    @Override
    public boolean create(Prestamo i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Prestamo findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Prestamo findByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }

    @Override
    public Prestamo findByEstancia(Libro l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEstancia'");
    }

    @Override
    public Prestamo findByOperario(Operario o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByOperario'");
    }

    @Override
    public Prestamo findByLector(Lector u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLector'");
    }

    @Override
    public boolean update(Prestamo o, Prestamo n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean update(int id, Prestamo n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Prestamo i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Prestamo> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    
}
