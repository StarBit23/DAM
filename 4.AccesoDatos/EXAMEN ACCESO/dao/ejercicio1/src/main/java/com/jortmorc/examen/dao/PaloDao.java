package com.jortmorc.examen.dao;

import java.util.List;

import com.jortmorc.examen.modelo.Palo;

public interface PaloDao {
    
    public boolean create(Palo u);

    public Palo findById(int id);

    public Palo findByNombre(String nombre);

    public boolean update(Palo o, Palo n);

    public boolean update(int id, Palo n);

    public boolean delete(Palo u);

    public boolean delete(int id);

    public List<Palo> findAll();

    public int count();

}
