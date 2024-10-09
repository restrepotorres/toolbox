package com.toolbox.toolbox.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class health { // Cambié el nombre de la clase para seguir la convención de nombres

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        String message = "All is ok v2";
        return new ResponseEntity<>(message, HttpStatus.OK); // Devuelve el mensaje junto con el estado 200
    }
}
