package com.saude.facil.demo.entity.medicos.dtos;


import com.saude.facil.demo.entity.medicos.enums.Especialidade;

public record MedicoDTO(
         String nome,
         String cpf,
         String crm,
         String email,
         String telefone,
         String cep,
         String dataNascimento,
         Especialidade especialidade
) {
}
