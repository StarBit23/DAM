package com.jorge.controlador;

import java.lang.System.Logger;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jorge.modelo.Usuario;
import com.jorge.dao.UsuarioDAO;
import com.jorge.daoimp.UsuarioDAOimp;

@Path("/api/admin")
public class UsuarioService {
    
    @GET
    @Path("user")
    @Produces((MediaType.APPLICATION_XML))
    public Response findAll(){
        List<Usuario> lista;
        try {
            Usuario ud = new Usuario();
        UsuarioDAO udDao = new UsuarioDAOimp();
        lista = udDao.findAll();
        return Response.ok(lista).build();
        } catch (Exception e) {
            Logger.getLogger(e.getLocalizedMessage());
            return Response.status(500).entity(lista).build();
        }
        

        
    }
}
