package com.iesvdc.gestion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username; //longitud<= 32
    private String password; //longitud <= 64
    private String email; //longitud <= 64
    private boolean activo; //bit
}
