package com.tsu.agendamento_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class AgendamentoRequest {

    private Long clienteId;
    private Long prestadorId;
    private Long servicoId;
    private LocalDateTime dataHora;
}
