package com.jortmorc.acceso.examen.sellos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jortmorc.acceso.examen.sellos.modelo.Sello;

public interface RepoSello extends JpaRepository<Sello, Integer>{

    
}
