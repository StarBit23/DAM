package com.jorgeortega.acceso.demoioc.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jorgeortega.acceso.demoioc.model.Estancia;
import com.jorgeortega.acceso.demoioc.model.Inventario;

public interface RepoInventario extends JpaRepository<Inventario, Integer> {

    @Query("SELECT i FROM Inventario i WHERE i.estancia = ?1")
    List<Inventario> findByEstancia(Estancia Estancia);
}
