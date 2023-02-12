package com.jortmorc.acceso.examen.sellos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jortmorc.acceso.examen.sellos.modelo.Sello;
import com.jortmorc.acceso.examen.sellos.repositorio.RepoSello;

@RestController
@RequestMapping("/api")
public class ServiSello {
    
    @Autowired
    RepoSello repoSello;

    @GetMapping("sello")
    List<Sello> findAll(){
        return repoSello.findAll();
    }//POSTMAN: GET localhost:8080/api/sello

    @PostMapping("sello")
    Sello create(Sello sello){
        return repoSello.save(sello);
    }//POSTMAN: POST localhost:8080/api/sello (raw JSON)

    @DeleteMapping("sello/{id}")
    void delete(@PathVariable (value = "id") Integer id){
        repoSello.deleteById(id);
    }//POSTMAN: DELETE localhost:8080/api/sello
}
