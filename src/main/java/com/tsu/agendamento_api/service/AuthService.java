package com.tsu.agendamento_api.service;

import com.tsu.agendamento_api.dto.AuthResponse;
import com.tsu.agendamento_api.dto.LoginRequest;
import com.tsu.agendamento_api.dto.RegisterRequest;
import com.tsu.agendamento_api.model.Usuario;
import com.tsu.agendamento_api.repository.UsuarioRepository;
import com.tsu.agendamento_api.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse registrar(RegisterRequest request){
        var user = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .role(request.getRole())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken);
    }

    public AuthResponse autenticar(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getSenha()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(()-> new IllegalArgumentException("Usuário não encontrado"));
        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken);
    }

}
