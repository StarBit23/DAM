package com.iesvdc.acceso.reservas.gestion.repositorio;

import org.springframework.stereotype.Repository;

import com.iesvdc.acceso.reservas.gestion.modelo.UsuarioRol;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepoUsuarioRol extends JpaRepository <UsuarioRol,Integer>{
    
}
