package com.tsu.agendamento_api.controller;

import com.tsu.agendamento_api.model.Servico;
import com.tsu.agendamento_api.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoRepository servicoRepository;

    @GetMapping
    public ResponseEntity<List<Servico>> listarTodos(){
        return ResponseEntity.ok(servicoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico){
        return ResponseEntity.ok(servicoRepository.save(servico));
    }

}
