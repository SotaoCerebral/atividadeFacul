package com.saude.facil.demo.entity.paciente.dto;

import com.saude.facil.demo.entity.endereco.Endereco;

public record PacienteDTO(

         String nomeCompleto,
         String dataNascimento,
         String cpf,
         String genero,
         String estadoCivil,
         String telefone,
         String email,
         String cep
) {
}
