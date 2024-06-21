package com.senac.gestaocurso;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApiConfigurer(){
        Info information = new Info()
                .title("API para controlar cursos disponibilizados pela empresa")
                .version("1.0")
                .description("Esta API expõe endpoints para controlar os cursos");

        return new OpenAPI().info(information);
    }


}