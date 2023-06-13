package com.iesvdc.acceso.prestamos.dao;

import java.util.List;

import com.iesvdc.acceso.prestamos.modelo.Operario;

public interface OperarioDao {
    
    public boolean create(Operario u);
    public Operario findById(int id);
    public Operario findByUsername(String username);
    public Operario findByUsernameAndPassword(String username, String password);
    public boolean update(Operario o, Operario n);
    public boolean update(int id, Operario n);
    public boolean delete(Operario u);
    public boolean delete(int id);
    /**
     * Devuelve la lista de todos los usuarios de la base de datos
     */
    public List<Operario> findAll();
    public int count();
}
