package com.saude.facil.demo.service;

import com.saude.facil.demo.entity.medicos.Agendamento;
import com.saude.facil.demo.entity.medicos.HorarioDisponivel;
import com.saude.facil.demo.entity.medicos.enums.StatusAgendamento;
import com.saude.facil.demo.entity.medicos.enums.TipoConsulta;
import com.saude.facil.demo.repository.AgendamentoRepository;
import com.saude.facil.demo.repository.HorarioDisponivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private HorarioDisponivelRepository horarioDisponivelRepository;

    // Criar novo agendamento
    public Optional<Agendamento> criarAgendamento(Long pacienteId, Long medicoId, String data, String hora, TipoConsulta tipoConsulta, String observacoes) {

        Optional<HorarioDisponivel> horario = horarioDisponivelRepository.findByMedicoIdAndDataAndHoraAndDisponivelTrue(medicoId, data, hora);
        System.out.println(horario);
        if (horario.isPresent()) {
            // Atualiza disponibilidade do horário
            HorarioDisponivel horarioDisponivel = horario.get();
            horarioDisponivel.setDisponivel(false);
            horarioDisponivelRepository.save(horarioDisponivel);

            // Cria o novo agendamento
            Agendamento novoAgendamento = new Agendamento(null, pacienteId, medicoId, data + " " + hora, StatusAgendamento.AGENDADO, tipoConsulta, observacoes);
            return Optional.of(agendamentoRepository.save(novoAgendamento));
        }

        return Optional.empty(); // Horário indisponível
    }

    // Buscar agendamento por ID
    public Optional<Agendamento> buscarAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    // Cancelar um agendamento e liberar horário
    public boolean cancelarAgendamento(Long id) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);
        if (agendamentoOptional.isPresent()) {
            Agendamento agendamento = agendamentoOptional.get();
            agendamento.setStatus(StatusAgendamento.CANCELADO);
            agendamentoRepository.save(agendamento);

            // Libera o horário correspondente
            String[] dataHora = agendamento.getDataHora().split(" ");
            String data = dataHora[0];
            String hora = dataHora[1];

            Optional<HorarioDisponivel> horarioOpt =
                    horarioDisponivelRepository.findByMedicoIdAndDataAndHora(agendamento.getMedicoId(), data, hora);

            if (horarioOpt.isPresent()) {
                HorarioDisponivel h = horarioOpt.get();
                h.setDisponivel(true);
                horarioDisponivelRepository.save(h);
            } else {
                System.out.println("Nenhum horário disponível encontrado para os parâmetros fornecidos.");
            }

            return true;
        }
        return false;
    }

    // Listar todos os agendamentos
    public Iterable<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }
}
