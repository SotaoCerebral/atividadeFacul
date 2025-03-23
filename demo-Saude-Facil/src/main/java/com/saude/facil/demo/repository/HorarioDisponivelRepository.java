package com.saude.facil.demo.repository;

import com.saude.facil.demo.entity.medicos.HorarioDisponivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HorarioDisponivelRepository extends JpaRepository<HorarioDisponivel,Long> {

    Optional<HorarioDisponivel> findByMedicoIdAndDataAndHora(Long medicoId, String data, String hora);
    Optional<HorarioDisponivel> findByMedicoIdAndDataAndHoraAndDisponivelTrue(Long medicoId, String data, String hora);
}
