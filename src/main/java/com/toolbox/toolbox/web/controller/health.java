package com.toolbox.toolbox.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class health {

    @GetMapping("/check")
    public String check() {
        return "All is ok v2";
    }
}
