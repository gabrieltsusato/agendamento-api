package com.tsu.agendamento_api.dto;

import com.tsu.agendamento_api.model.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AgendamentoResponseDTO {
    private Long id;
    private LocalDateTime dataHora;
    private UsuarioResponseDTO cliente;
    private UsuarioResponseDTO prestador;
    private Servico servico;
}