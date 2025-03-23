package com.saude.facil.demo.entity.medicos.dtos;

import com.saude.facil.demo.entity.endereco.Endereco;
import com.saude.facil.demo.entity.medicos.enums.Especialidade;

public record MedicoAtualizarDTO(
        String nome,
        String cpf,
        String crm,
        String email,
        String telefone,
        Endereco endereco,
        String dataNascimento,
        Especialidade especialidade
) {
}
