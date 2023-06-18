package com.jorgeortega.acceso.demoioc.controller;

import com.jorgeortega.acceso.demoioc.repos.RepoEstancia;
import com.jorgeortega.acceso.demoioc.model.Estancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estancias")
public class EstanciaController {

    @Autowired
    RepoEstancia repoEstancia;

    @GetMapping("")
    public String listarEstancias(Model model) {
        model.addAttribute("estancias", repoEstancia.findAll());
        return "estancias";
    }

    @GetMapping("/create")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("estancia", new Estancia());
        return "estanciacreate";
    }

    @PostMapping("/guardar")
    public String guardarEstancia(@ModelAttribute("estancia") Estancia estancia) {
        repoEstancia.save(estancia);
        return "redirect:/estancias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
        Estancia estancia = repoEstancia.findById(id).get();
        model.addAttribute("estancia", estancia);
        return "estanciaedit";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstancia(@PathVariable("id") Integer id) {
        repoEstancia.deleteById(id);
        return "redirect:/estancias";
    }
}