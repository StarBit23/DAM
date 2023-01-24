package com.iesvdc.acceso.reservas.gestion.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.iesvdc.acceso.reservas.gestion.modelo.Instalacion;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoInstalacion;

@RestController
@RequestMapping("/api")
public class ServiListaInstalacion {
    @Autowired
    RepoInstalacion repoInstalacion;

    @GetMapping("instalacion")
    List<Instalacion> findAll(){
        return repoInstalacion.findAll();
    }

    @GetMapping("instalacion/{id}")
    Instalacion findById(@PathVariable (value = "id") Integer id){
        Optional<Instalacion> oInstalacion = repoInstalacion.findById(id);
        if (oInstalacion.isPresent()) {
            return repoInstalacion.findById(id).get();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

}