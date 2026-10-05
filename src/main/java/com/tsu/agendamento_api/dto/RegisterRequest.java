package com.tsu.agendamento_api.dto;

import com.tsu.agendamento_api.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class RegisterRequest {

    private String nome;
    private String senha;
    private String email;
    private Role role;
}
