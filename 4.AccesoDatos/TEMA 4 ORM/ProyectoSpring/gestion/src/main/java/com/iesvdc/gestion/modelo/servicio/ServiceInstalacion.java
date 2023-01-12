package com.iesvdc.gestion.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iesvdc.gestion.modelo.modelo.Instalacion;
import com.iesvdc.gestion.modelo.repositorio.RepoInstalacion;

@RestController
@RequestMapping("/admin")
public class ServiceInstalacion {
    @Autowired
    RepoInstalacion repoInstalacion;

    @GetMapping("instalacion")
    List<Instalacion> findAll(){
        return repoInstalacion.findAll();
    }

    @GetMapping("instalacion/{id}")
    Instalacion findAllById(@PathVariable (value = "id") Integer id){
        return repoInstalacion.findById(id).get();
    }

    @PostMapping("instalacion")
    Instalacion create(@RequestBody Instalacion i){
        return repoInstalacion.save(i);
    }

    @DeleteMapping("instalacion/{id}")
    void delete(@PathVariable (value = "id") Integer id){
        repoInstalacion.deleteById(id);
    }
}
