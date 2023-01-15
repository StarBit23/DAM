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

import com.iesvdc.gestion.modelo.modelo.Usuario;
import com.iesvdc.gestion.modelo.repositorio.RepoUsuario;

@RestController
@RequestMapping("/admin")
public class Serviceusuario {
    @Autowired
    RepoUsuario repoUsuario;

    @GetMapping("usuario")
    List<Usuario> findAll(){
        return repoUsuario.findAll();
    }

    @GetMapping("usuario/{id}")
    Usuario findAllById(@PathVariable (value = "id") Integer id){
        return repoUsuario.findById(id).get();
    }

    @PostMapping("usuario")
    Usuario create(@RequestBody Usuario u){
        return repoUsuario.save(u);
    }

    @DeleteMapping("usuario/{id}")
    void delete(@PathVariable (value = "id") Integer id){
        repoUsuario.deleteById(id);
    }
}
