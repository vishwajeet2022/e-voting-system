package com.evoting.controller;

import com.evoting.model.User;
import com.evoting.security.JwtUtil;
import com.evoting.service.InMemoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final InMemoryService inMemoryService;
    private final JwtUtil jwtUtil;

    public AuthController(InMemoryService inMemoryService, JwtUtil jwtUtil) {
        this.inMemoryService = inMemoryService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (inMemoryService.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        inMemoryService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = inMemoryService.findByUsername(loginRequest.getUsername());

        // 🔁 Plain string comparison (no encoder)
        if (user == null || !loginRequest.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        return ResponseEntity.ok("Bearer " + token);
    }
}
