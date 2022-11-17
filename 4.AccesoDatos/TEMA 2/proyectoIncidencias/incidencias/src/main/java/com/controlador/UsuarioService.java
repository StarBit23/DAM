package com.controlador;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.jorge.modelo.Usuario;

@Path("/api/admin")
public class UsuarioService {
    
    public Response findAll(){
        Usuario ud = new Usuario();

        List<Usuario> lista = ud.find();
    }
}
