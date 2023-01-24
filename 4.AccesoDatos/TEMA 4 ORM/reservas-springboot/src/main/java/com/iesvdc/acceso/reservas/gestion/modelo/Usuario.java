package com.iesvdc.acceso.reservas.gestion.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, length = 32, nullable = false)
    private String username; // longitud <= 32
    @Column(length = 64, nullable = false)
    private String password; // longitud <= 64
    @Column(length = 64, nullable = false)
    private String email; // longitud <= 64
    private boolean activo; // bit

}
