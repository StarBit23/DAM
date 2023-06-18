package com.jorgeortega.acceso.demoioc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgeortega.acceso.demoioc.model.Estancia;

public interface RepoEstancia extends JpaRepository<Estancia, Integer> {

}
