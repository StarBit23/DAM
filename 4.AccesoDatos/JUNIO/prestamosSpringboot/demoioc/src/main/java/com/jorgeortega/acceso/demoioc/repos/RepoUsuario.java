package com.jorgeortega.acceso.demoioc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgeortega.acceso.demoioc.model.Usuario;

public interface RepoUsuario extends JpaRepository<Usuario, Integer> {

}
