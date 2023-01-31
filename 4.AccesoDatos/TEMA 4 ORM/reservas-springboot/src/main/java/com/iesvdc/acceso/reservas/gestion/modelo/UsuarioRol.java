package com.iesvdc.acceso.reservas.gestion.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioRol {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String rol;
    @OneToMany
    private Usuario usuario;
}
