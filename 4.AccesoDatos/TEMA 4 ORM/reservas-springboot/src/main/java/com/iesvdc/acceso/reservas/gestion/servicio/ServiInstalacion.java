package com.iesvdc.acceso.reservas.gestion.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iesvdc.acceso.reservas.gestion.modelo.Instalacion;
import com.iesvdc.acceso.reservas.gestion.repositorio.RepoInstalacion;

@RestController
@RequestMapping("/admin")
public class ServiInstalacion {
    @Autowired
    RepoInstalacion repoInstalacion;

    @GetMapping("instalacion")
    List<Instalacion> findAll(){
        return repoInstalacion.findAll();
    }

    @GetMapping("instalacion/{id}")
    Instalacion findById(@PathVariable (value = "id") Integer id){
        return repoInstalacion.findById(id).get();
    }

    @PostMapping("instalacion")
    Instalacion create(@RequestBody Instalacion u){
        return repoInstalacion.save(u);
    }

    @DeleteMapping("instalacion/{id}")
    void delete(@PathVariable (value = "id") Integer id){
        repoInstalacion.deleteById(id);
    }
}