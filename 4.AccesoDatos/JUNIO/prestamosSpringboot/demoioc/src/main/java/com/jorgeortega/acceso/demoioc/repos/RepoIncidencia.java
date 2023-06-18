package com.jorgeortega.acceso.demoioc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgeortega.acceso.demoioc.model.Incidencia;

public interface RepoIncidencia extends JpaRepository<Incidencia, Integer> {

}
