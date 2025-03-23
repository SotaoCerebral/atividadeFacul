package com.saude.facil.demo.provider.dto;

public record EnderecoResponse(
        String logradouro,
        String localidade,
        String uf,
        String bairro,
        String estado,
        String cep
) {
}
