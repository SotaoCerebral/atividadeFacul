package com.saude.facil.demo.service;

import com.saude.facil.demo.entity.medicos.HorarioDisponivel;
import com.saude.facil.demo.repository.HorarioDisponivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioDisponivelService {

    @Autowired
    private HorarioDisponivelRepository horarioDisponivelRepository;

    // Criar novo horário disponível
    public HorarioDisponivel criarHorarioDisponivel(Long medicoId, String data, String hora, Boolean disponivel) {
        HorarioDisponivel horario = new HorarioDisponivel(null, medicoId, data, hora, disponivel);
        return horarioDisponivelRepository.save(horario);
    }

    // Buscar horário disponível por ID
    public Optional<HorarioDisponivel> buscarHorarioPorId(Long id) {
        return horarioDisponivelRepository.findById(id);
    }

    // Buscar todos os horários disponíveis
    public List<HorarioDisponivel> listarHorariosDisponiveis() {
        return horarioDisponivelRepository.findAll();
    }

    // Atualizar horário disponível
    public Optional<HorarioDisponivel> atualizarHorarioDisponivel(Long id, Boolean disponivel) {
        Optional<HorarioDisponivel> horarioOptional = horarioDisponivelRepository.findById(id);
        if (horarioOptional.isPresent()) {
            HorarioDisponivel horario = horarioOptional.get();
            horario.setDisponivel(disponivel);
            horarioDisponivelRepository.save(horario);
            return Optional.of(horario);
        }
        return Optional.empty();
    }

    // Deletar horário disponível por ID
    public boolean deletarHorarioDisponivel(Long id) {
        if (horarioDisponivelRepository.existsById(id)) {
            horarioDisponivelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
