package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.DTOs.AuthRequestDTO;
import com.example.ISPStatDisplay.models.DTOs.AuthResponseDTO;
import com.example.ISPStatDisplay.models.beans.documents.User;
import com.example.ISPStatDisplay.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthResponseDTO signup(AuthRequestDTO request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthResponseDTO(token);
    }

    public AuthResponseDTO login(AuthRequestDTO request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        User user = userRepository.findByUsername(request.username()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new AuthResponseDTO(token);
    }
}
