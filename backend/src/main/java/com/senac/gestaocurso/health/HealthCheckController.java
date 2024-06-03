package com.senac.gestaocurso.health;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HealthCheckController {
    @GetMapping("/health")
    public String healthCheck() {
        return "Aplicação está rodando";
    }
}