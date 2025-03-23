package com.saude.facil.demo.repository;

import com.saude.facil.demo.entity.medicos.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
}
