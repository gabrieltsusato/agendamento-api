package com.tsu.agendamento_api.dto;

import com.tsu.agendamento_api.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private Role role;
}