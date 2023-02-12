package com.jortmorc.acceso.examen.sellos.modelo;

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
public class Sello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float valor;
    @Column(unique = true, nullable = false, length = 30)
    private String nombre;
    @Column(nullable = false, length = 30)
    private String pais;
}
