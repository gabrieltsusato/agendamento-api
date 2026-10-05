package com.tsu.agendamento_api.controller;

import com.tsu.agendamento_api.dto.AgendamentoRequest;
import com.tsu.agendamento_api.dto.AgendamentoResponseDTO;
import com.tsu.agendamento_api.dto.UsuarioResponseDTO;
import com.tsu.agendamento_api.model.Agendamento;
import com.tsu.agendamento_api.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> agendar(@RequestBody AgendamentoRequest request){
        Agendamento agendamento = agendamentoService.criarAgendamento(
                request.getClienteId(),
                request.getPrestadorId(),
                request.getServicoId(),
                request.getDataHora()
        );

        // Mapeamento para DTO limpo
        UsuarioResponseDTO clienteDTO = new UsuarioResponseDTO(
                agendamento.getCliente().getId(),
                agendamento.getCliente().getNome(),
                agendamento.getCliente().getEmail(),
                agendamento.getCliente().getRole()
        );

        UsuarioResponseDTO prestadorDTO = new UsuarioResponseDTO(
                agendamento.getPrestador().getId(),
                agendamento.getPrestador().getNome(),
                agendamento.getPrestador().getEmail(),
                agendamento.getPrestador().getRole()
        );

        AgendamentoResponseDTO response = new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getDataHora(),
                clienteDTO,
                prestadorDTO,
                agendamento.getServico()
        );

        return ResponseEntity.ok(response);
    }


}
