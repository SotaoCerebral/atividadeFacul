package com.saude.facil.demo.repository;

import com.saude.facil.demo.entity.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
