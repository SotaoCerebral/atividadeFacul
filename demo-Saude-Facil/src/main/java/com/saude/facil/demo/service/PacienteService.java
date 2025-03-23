package com.saude.facil.demo.service;

import com.saude.facil.demo.entity.endereco.Endereco;
import com.saude.facil.demo.entity.paciente.Paciente;
import com.saude.facil.demo.entity.paciente.dto.PacienteAtualizarDTO;
import com.saude.facil.demo.entity.paciente.dto.PacienteDTO;
import com.saude.facil.demo.provider.CepApi;
import com.saude.facil.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Autowired
    private CepApi cepApi;

    public Paciente cadastrarPaciente(PacienteDTO request) {

        Endereco endereco = new Endereco(cepApi.apiCep(request.cep()));
        Paciente paciente = new Paciente(request);
        paciente.setEndereco(endereco);
        return repository.save(paciente);
    }

    public List<Paciente> listarPacientes() {
        return repository.findAll();
    }

    public Optional<Paciente> listarPaciente(Long id) {
        return repository.findById(id);
    }

    public void deletarPaciente(Long id) {
        Paciente paciente = repository.findById(id).orElseThrow();
        repository.delete(paciente);
    }

    public Paciente atualizarPaciente(PacienteAtualizarDTO dto, Long id) {
        Paciente paciente = repository.findById(id).orElseThrow();
        paciente.atualizarPaciente(dto);
        this.repository.save(paciente);
        return new Paciente();
    }

    public void agendar(){



    }
}
