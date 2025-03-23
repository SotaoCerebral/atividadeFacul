package com.saude.facil.demo.controller;

import com.saude.facil.demo.entity.paciente.Paciente;
import com.saude.facil.demo.entity.paciente.dto.PacienteAtualizarDTO;
import com.saude.facil.demo.entity.paciente.dto.PacienteDTO;
import com.saude.facil.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    private ResponseEntity<Paciente> cadastrarPaciente(@RequestBody PacienteDTO dto) {
        System.out.println(dto.cep());
        return ResponseEntity.ok(this.service.cadastrarPaciente(dto));
    }

    @GetMapping
    private ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(service.listarPacientes());
    }

    @GetMapping("{id}")
    private ResponseEntity<Optional<Paciente>> listarPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPaciente(id));
    }

    @DeleteMapping("{id}")
    private ResponseEntity deletaPaciente(@PathVariable Long id) {
        service.deletarPaciente(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    private ResponseEntity<Paciente> atualizarMedico(@RequestBody PacienteAtualizarDTO dto,@PathVariable Long id) {
        return ResponseEntity.ok(service.atualizarPaciente(dto, id));
    }
}
