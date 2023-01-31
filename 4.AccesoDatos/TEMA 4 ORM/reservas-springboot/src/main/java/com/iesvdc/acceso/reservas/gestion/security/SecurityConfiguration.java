package com.iesvdc.acceso.reservas.gestion.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class SecurityConfiguration {
    @Autowired
    private DataSource datasource;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
        .dataSource(datasource)
        .usersByUsernameQuery("select username, password, enabled from usuario where username = ?")
        .authoritiesByUsernameQuery("select username, authority where usuario.id = usuario_rol.ususario_id and username = ?");
    }
}
