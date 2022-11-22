package com.jorge.dao;

import java.util.List;

import com.jorge.modelo.Usuario;

public interface UsuarioDAO {

    public boolean create(Usuario u);
    public Usuario findById(int id);
    public Usuario findByUsername(String username);
    public Usuario findByUsernameAndPassword(String username, String password);
    public boolean update(Usuario o, Usuario n);
    public boolean update(int id, Usuario n);
    public boolean delete(Usuario u);
    public boolean delete(int id);
    public List<Usuario> findAll();

}

