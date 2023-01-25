package com.iesvdc.acceso.reservas.gestion.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iesvdc.acceso.reservas.gestion.modelo.Reserva;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoHorario;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoReserva;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoUsuario;

import java.util.List;

@RestController
@RequestMapping("admin")
public class ServiReserva {
    @Autowired
    RepoReserva repoReserva;

    @GetMapping("reserva")
    List<Reserva> findAllReservas() {
        return repoReserva.findAll();
    }

    @GetMapping("reserva/{id}")
    Reserva findOne(@PathVariable(value = "id") Integer reserva){
        Reserva r = repoReserva.findById(reserva).get();
        return r;
    }

    @PostMapping("reserva")
    Reserva save(@RequestBody Reserva reserva){
        return repoReserva.save(reserva);
    }

    @PutMapping("reserva/{id}")
    Reserva update(@PathVariable(value = "id") Integer id, @RequestBody Reserva nuevoReserva) {
        return repoReserva.findById(id).map(
                reserva -> {
                    // TO-DO
                    return repoReserva.save(reserva);
                }
        ).orElseGet(
                ()-> {
                    nuevoReserva.setId(id);
                    return repoReserva.save(nuevoReserva);
                }
        );
    }

    @DeleteMapping("reserva/{id}")
    void delete(@PathVariable(value = "id") Integer reserva){
        repoReserva.deleteById(reserva);
    }
}
