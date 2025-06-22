package com.evoting.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/secure")
public class TestController {

    @GetMapping("/common")
    public String commonEndpoint() {
        return "Accessible to all authenticated users ";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')") //  Only ADMIN can access
    public String adminEndpoint() {
        return "Admin-only endpoint";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") //  Both roles allowed
    public String userEndpoint() {
        return "Accessible by USER or ADMIN";
    }
}
