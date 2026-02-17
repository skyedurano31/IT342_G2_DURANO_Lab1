package com.systemintegration.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestRestController {

    // Public endpoint - no authentication needed
    @GetMapping("/public/hello")
    public ResponseEntity<Map<String, String>> publicHello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from public endpoint!");
        response.put("access", "public");
        return ResponseEntity.ok(response);
    }

    // User endpoint - requires ROLE_USER or ROLE_ADMIN
    @GetMapping("/user/profile")
    public ResponseEntity<Map<String, Object>> userProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "This is user profile data");
        response.put("username", auth.getName());
        response.put("roles", auth.getAuthorities());
        response.put("access", "user level");

        return ResponseEntity.ok(response);
    }

    // Admin endpoint - requires ROLE_ADMIN only
    @GetMapping("/admin/dashboard")
    public ResponseEntity<Map<String, String>> adminDashboard() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to admin dashboard!");
        response.put("access", "admin only");
        response.put("data", "Sensitive admin data here");
        return ResponseEntity.ok(response);
    }

    // Another admin endpoint - POST example
    @PostMapping("/admin/users")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody Map<String, String> userData) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "User created by admin");
        response.put("createdUser", userData.get("username"));
        return ResponseEntity.ok(response);
    }

    // Endpoint that returns current authentication info
    @GetMapping("/auth-info")
    public ResponseEntity<Map<String, Object>> getAuthInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> response = new HashMap<>();
        response.put("username", auth.getName());
        response.put("authenticated", auth.isAuthenticated());
        response.put("authorities", auth.getAuthorities());
        response.put("principal", auth.getPrincipal().getClass().getSimpleName());

        return ResponseEntity.ok(response);
    }
}