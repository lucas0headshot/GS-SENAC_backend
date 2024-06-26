package com.senac.gestaocurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class GestaoCursoApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestaoCursoApplication.class, args);
	}
}
