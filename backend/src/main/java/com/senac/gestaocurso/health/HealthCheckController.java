package com.senac.gestaocurso.health;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HealthCheckController {

    @Tag(name = "HEALTH")
    @Operation(summary = "API Health Checker")
    @GetMapping("/health")
    public String healthCheck() {
        return "Aplicação está rodando";
    }
}