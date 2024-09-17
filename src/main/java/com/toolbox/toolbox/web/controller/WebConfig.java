package com.toolbox.toolbox.web.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Permitir cualquier origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD") // Permitir todos los métodos HTTP
                .allowedHeaders("*") // Permitir cualquier cabecera
                .allowCredentials(false); // Deshabilitar envío de credenciales (cookies)
    }
}
