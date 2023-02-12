package com.iesvdc.acceso.reservas.gestion.repositorio;

import com.iesvdc.acceso.reservas.gestion.modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RepoReserva extends JpaRepository<Reserva,Integer>{
    
}
