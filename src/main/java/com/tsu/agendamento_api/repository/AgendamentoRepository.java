package com.tsu.agendamento_api.repository;

import com.tsu.agendamento_api.model.Agendamento;
import com.tsu.agendamento_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByPrestadorAndDataHora(Usuario prestador, LocalDateTime dataHora);
}
