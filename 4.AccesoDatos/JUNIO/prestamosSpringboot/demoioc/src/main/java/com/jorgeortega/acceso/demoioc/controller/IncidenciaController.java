package com.jorgeortega.acceso.demoioc.controller;

import com.jorgeortega.acceso.demoioc.model.Estancia;
import com.jorgeortega.acceso.demoioc.model.Incidencia;
import com.jorgeortega.acceso.demoioc.model.Inventario;
import com.jorgeortega.acceso.demoioc.model.Usuario;
import com.jorgeortega.acceso.demoioc.repos.RepoEstancia;
import com.jorgeortega.acceso.demoioc.repos.RepoIncidencia;
import com.jorgeortega.acceso.demoioc.repos.RepoInventario;
import com.jorgeortega.acceso.demoioc.repos.RepoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Controller
@RequestMapping("/incidencias")
public class IncidenciaController {

    @Autowired
    private RepoIncidencia repoIncidencia;
    @Autowired
    private RepoUsuario repoUsuario;
    @Autowired
    private RepoEstancia repoEstancia;
    @Autowired
    private RepoInventario repoInventario;

    @GetMapping("")
    public String listarIncidencias(Model model) {
        List<Incidencia> incidencias = repoIncidencia.findAll();
        model.addAttribute("incidencias", incidencias);
        return "incidencias";
    }

    @GetMapping("/create")
    public String mostrarFormularioCrearIncidenciaPorEstancia(
        @RequestParam(name="estanciaId") Optional<Integer> estanciaId, Model model) {

        List<Inventario> inventarios = new ArrayList<Inventario>();
        Estancia estancia = null;

        if (estanciaId.isPresent()) {
            Optional <Estancia> oestancia = repoEstancia.findById(estanciaId.get());
            if (oestancia.isPresent()) {
                inventarios = repoInventario.findByEstancia(oestancia.get());
                estancia = oestancia.get();
            }
            else {
                inventarios = repoInventario.findAll();
            }
        } else {
            inventarios = repoInventario.findAll();
        }
        
        List<Usuario> usuarios = repoUsuario.findAll();
        List<Usuario> operarios = repoUsuario.findAll();
        List<Estancia> estancias = repoEstancia.findAll();        

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("operarios", operarios);
        model.addAttribute("estancias", estancias);
        model.addAttribute("inventarios", inventarios);
        model.addAttribute("incidencia", new Incidencia());
        model.addAttribute("estancia", estancia);

        return "incidenciacreate";
    }

    @PostMapping("/guardar")
    public String guardarIncidencia(@ModelAttribute("incidencia") Incidencia incidencia) {
        repoIncidencia.save(incidencia);
        return "redirect:/incidencias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarIncidencia(@PathVariable("id") Integer id, Model model) {
        Incidencia incidencia = repoIncidencia.findById(id).get();
        List<Usuario> usuarios = repoUsuario.findAll();
        List<Usuario> operarios = repoUsuario.findAll();
        List<Estancia> estancias = repoEstancia.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("operarios", operarios);
        model.addAttribute("estancias", estancias);
        model.addAttribute("incidencia", incidencia);
        return "incidenciaedit";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarIncidencia(@PathVariable("id") Integer id) {
        repoIncidencia.deleteById(id);
        return "redirect:/incidencias";
    }
}
