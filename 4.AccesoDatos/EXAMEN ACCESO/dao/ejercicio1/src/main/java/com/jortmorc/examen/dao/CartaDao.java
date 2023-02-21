package com.jortmorc.examen.dao;

import java.util.List;

import com.jortmorc.examen.modelo.Carta;

public interface CartaDao {
      
    public boolean create(Carta u);

    public Carta findById(int id);

    public Carta findByNombre(String nombre);

    public boolean update(Carta o, Carta n);

    public boolean update(int id, Carta n);

    public boolean delete(Carta u);

    public boolean delete(int id);

    public List<Carta> findAll();

    public int count();

}
