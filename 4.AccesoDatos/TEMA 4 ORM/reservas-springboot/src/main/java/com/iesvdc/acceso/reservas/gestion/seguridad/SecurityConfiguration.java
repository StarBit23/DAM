package com.iesvdc.acceso.reservas.gestion.seguridad;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    // @Autowired
    // DataSource dataSource;

    // @Autowired
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.jdbcAuthentication()
    //             .dataSource(dataSource)
    //             .usersByUsernameQuery(
    //                 "select username, password, activo as enabled " +
    //                 "from usuario where username = ? ")
    //             .authoritiesByUsernameQuery(
    //                 "select u.username, ur.authority " +
    //                 "from usuario u, usuario_rol ur where u.id=ur.usuario_id and u.username = ? ");
    // }

    // @Bean
    // public BCryptPasswordEncoder passwordEncoder() {        
    //     return new BCryptPasswordEncoder();
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.oauth2Login().and().authorizeHttpRequests().anyRequest().authenticated()
            .and().csrf().disable().cors().and()            
            .logout()
            .logoutUrl("/logout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");        

        return http.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }

}
