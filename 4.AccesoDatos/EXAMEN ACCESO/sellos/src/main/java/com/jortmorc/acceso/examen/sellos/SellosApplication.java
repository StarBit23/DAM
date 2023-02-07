package com.jortmorc.acceso.examen.sellos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jortmorc.acceso.examen.sellos.modelo.Sello;
import com.jortmorc.acceso.examen.sellos.repositorio.RepoSello;

@SpringBootApplication
public class SellosApplication {

	public static void main(String[] args) {

		SpringApplication.run(SellosApplication.class, args);

		//Ejecutar docker, crear "sello"
		//POSTMAN: GET localhost:8080/api/sello

		// Sello sello = new Sello(
		// 	-1, 5, "Sellos de Rawan", "España");

		// @Autowired RepoSello repoSello,
		// repoSello.save(sello);
		// SpringApplication.run(SellosApplication.class, args);
	}

}
