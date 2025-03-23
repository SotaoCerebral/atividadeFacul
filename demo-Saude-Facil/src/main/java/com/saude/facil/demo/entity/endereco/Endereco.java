package com.saude.facil.demo.entity.endereco;


import com.saude.facil.demo.provider.dto.EnderecoResponse;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {


    private String rua;
    private String bairro;
    private String cidade;
    private String estados;
    private String cep;


    public Endereco(EnderecoResponse dto) {
        this.rua = dto.logradouro();
        this.bairro = dto.bairro();
        this.cidade = dto.localidade();
        this.estados = dto.estado();
        this.cep = dto.cep();
    }
}
