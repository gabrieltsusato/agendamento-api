package com.tsu.agendamento_api.controller;

import com.tsu.agendamento_api.dto.AuthResponse;
import com.tsu.agendamento_api.dto.LoginRequest;
import com.tsu.agendamento_api.dto.RegisterRequest;
import com.tsu.agendamento_api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registrar(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.registrar(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> autenticar(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.autenticar(request));
    }


}
