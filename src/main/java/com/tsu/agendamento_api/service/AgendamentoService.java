package com.tsu.agendamento_api.service;

import com.tsu.agendamento_api.model.Agendamento;
import com.tsu.agendamento_api.model.Servico;
import com.tsu.agendamento_api.model.Usuario;
import com.tsu.agendamento_api.repository.AgendamentoRepository;
import com.tsu.agendamento_api.repository.ServicoRepository;
import com.tsu.agendamento_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

        private final AgendamentoRepository agendamentoRepository;
        private final ServicoRepository servicoRepository;
        private final UsuarioRepository usuarioRepository;

        public Agendamento criarAgendamento(Long clienteId, Long prestadorId, Long servicoId, LocalDateTime dataHora){
            Usuario prestador = usuarioRepository.findById(prestadorId)
                    .orElseThrow(()-> new IllegalArgumentException("Prestador não encontrado"));
            if(agendamentoRepository.existsByPrestadorAndDataHora(prestador, dataHora)){
                throw new IllegalArgumentException("O prestador já possui um agendamento nesse horário");
            }

            Usuario cliente = usuarioRepository.findById(clienteId)
                    .orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));

            Servico servico  = servicoRepository.findById(servicoId)
                    .orElseThrow(()-> new IllegalArgumentException("Servico não encontrado"));

            Agendamento agendamento = new Agendamento();
            agendamento.setCliente(cliente);
            agendamento.setPrestador(prestador);
            agendamento.setServico(servico);
            agendamento.setDataHora(dataHora);

            return agendamentoRepository.save(agendamento);
        }


}
