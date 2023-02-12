package com.iesvdc.acceso.reservas.gestion.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.iesvdc.acceso.reservas.gestion.modelo.Horario;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoHorario;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("admin")
public class ServiHorario {
    @Autowired
    private RepoHorario repoHorario;

    @GetMapping(value="horario")
    public List<Horario> findAll() {
        return repoHorario.findAll();
    }
    
    @GetMapping("horario/{id}")
    public Horario findById(@PathParam(value = "id") Integer id){
        Optional oHorario = repoHorario.findById(id);
        if (oHorario.isPresent())
            return (Horario)oHorario.get();
        else
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("horario")
    public Horario create(@RequestBody Horario horario){
        return repoHorario.save(horario);
    }
    
}
