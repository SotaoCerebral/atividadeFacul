package com.saude.facil.demo.entity.paciente.dto;

import com.saude.facil.demo.entity.endereco.Endereco;

public record PacienteAtualizarDTO(
        String nomeCompleto,
        String dataNascimento,
        String cpf,
        String genero,
        String estadoCivil,
        String telefone,
        String email,
        Endereco endereco
) {
}
