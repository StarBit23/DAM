package com.iesvdc.acceso.reservas.gestion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesvdc.acceso.reservas.gestion.modelo.Horario;

@Repository
public interface RepoHorario extends JpaRepository<Horario,Integer> {
    
}
