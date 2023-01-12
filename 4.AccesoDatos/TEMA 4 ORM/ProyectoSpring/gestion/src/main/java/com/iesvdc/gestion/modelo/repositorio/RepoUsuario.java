package com.iesvdc.gestion.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesvdc.gestion.modelo.modelo.Usuario;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario,Integer>{

}