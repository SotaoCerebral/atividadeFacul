package com.saude.facil.demo.repository;

import com.saude.facil.demo.entity.medicos.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
}
