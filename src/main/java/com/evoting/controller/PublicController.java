package com.evoting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/api/public/hello")
    public String publicHello() {
        return "✅ Public endpoint working!";
    }
}
