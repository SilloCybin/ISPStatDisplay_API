package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.AuthRequestDTO;
import com.example.ISPStatDisplay.models.DTOs.AuthResponseDTO;
import com.example.ISPStatDisplay.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public AuthResponseDTO signup(@RequestBody AuthRequestDTO request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO request) {
        return authService.login(request);
    }
}