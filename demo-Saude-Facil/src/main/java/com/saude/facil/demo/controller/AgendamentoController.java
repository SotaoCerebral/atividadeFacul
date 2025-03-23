package com.saude.facil.demo.controller;

import com.saude.facil.demo.entity.medicos.Agendamento;
import com.saude.facil.demo.entity.medicos.enums.TipoConsulta;
import com.saude.facil.demo.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Optional<Agendamento>> criarAgendamento(
            @RequestParam Long pacienteId,
            @RequestParam Long medicoId,
            @RequestParam String data,
            @RequestParam String hora,
            @RequestParam TipoConsulta tipoConsulta,
            @RequestParam(required = false) String observacoes) {
        Optional<Agendamento> agendamento = agendamentoService.criarAgendamento(pacienteId, medicoId, data, hora, tipoConsulta, observacoes);
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarAgendamento(@PathVariable Long id) {
        return agendamentoService.buscarAgendamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long id) {
        if (agendamentoService.cancelarAgendamento(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarAgendamentos() {
        List<Agendamento> agendamentos = (List<Agendamento>) agendamentoService.listarAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }
}
