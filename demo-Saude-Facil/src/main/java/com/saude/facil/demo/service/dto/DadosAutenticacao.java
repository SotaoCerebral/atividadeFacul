package com.saude.facil.demo.service.dto;

import com.saude.facil.demo.entity.enums.UserRole;

public record DadosAutenticacao(

        String login,
        String senha,
        UserRole role
) {
}
