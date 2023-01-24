package com.iesvdc.acceso.reservas.gestion.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iesvdc.acceso.reservas.gestion.modelo.Horario;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoHorario;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api")
public class ServiListaHorario {
    
    @Autowired
    RepoHorario repoHorario;

    @GetMapping("horario")
    List<Horario> findAll(){
        return repoHorario.findAll();
    }

    @GetMapping("horario/{id}")
    Horario findById(@PathParam (value = "id") Integer id){
        return repoHorario.findById(id).get();
    }
    
}
