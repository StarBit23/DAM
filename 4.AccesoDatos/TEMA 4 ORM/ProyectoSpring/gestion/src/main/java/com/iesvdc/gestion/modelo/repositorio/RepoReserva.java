package com.iesvdc.gestion.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesvdc.gestion.modelo.modelo.Reserva;

@Repository
public interface RepoReserva extends JpaRepository<Reserva,Integer>{

}