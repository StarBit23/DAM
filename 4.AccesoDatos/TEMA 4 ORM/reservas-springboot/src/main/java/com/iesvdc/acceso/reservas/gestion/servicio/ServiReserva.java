package com.iesvdc.acceso.reservas.gestion.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import com.iesvdc.acceso.reservas.gestion.modelo.Reserva;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoHorario;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoReserva;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoUsuario;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS})
@RequestMapping("admin")
public class ServiReserva {
    @Autowired
    RepoReserva repoReserva;
    @Autowired
    RepoHorario repoHorario;
    @Autowired
    RepoUsuario repoUsuario;

    @GetMapping("reserva")
    List<Reserva> findAllReservas() {
        return repoReserva.findAll();
    }

    @GetMapping("reserva/{id}")
    Reserva findOne(@PathVariable(value = "id") Integer reserva){
        return repoReserva.findById(reserva).orElseThrow(() -> new ResourceAccessException("No encontrado"));
    }

    @PostMapping("reserva/{id}")
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
