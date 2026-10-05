package com.tsu.agendamento_api.repository;

import com.tsu.agendamento_api.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
