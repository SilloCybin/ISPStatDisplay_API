package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.AuthRequestDTO;
import com.example.ISPStatDisplay.models.DTOs.AuthResponseDTO;
import com.example.ISPStatDisplay.models.exceptions.UsernameAlreadyExistsException;
import com.example.ISPStatDisplay.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public ResponseEntity<String> signup(@RequestBody AuthRequestDTO request) {
        try {
            authService.signup(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UsernameAlreadyExistsException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        try{
            AuthResponseDTO data = authService.login(request);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (UsernameNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}