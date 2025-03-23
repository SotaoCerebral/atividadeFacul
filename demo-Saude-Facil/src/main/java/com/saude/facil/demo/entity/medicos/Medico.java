package com.saude.facil.demo.entity.medicos;

import com.saude.facil.demo.entity.endereco.Endereco;
import com.saude.facil.demo.entity.medicos.dtos.MedicoAtualizarDTO;
import com.saude.facil.demo.entity.medicos.dtos.MedicoDTO;
import com.saude.facil.demo.entity.medicos.enums.Especialidade;
import com.saude.facil.demo.service.dto.DadosAutenticacao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String senha;
    private String cpf;
    private String crm;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private String dataNascimento;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    public Medico(MedicoDTO request) {
        this.nome = request.nome();
        this.cpf = request.cpf();
        this.crm = request.crm();;
        this.email = request.email();
        this.telefone = request.telefone();
        this.dataNascimento = request.dataNascimento();
        this.especialidade = request.especialidade();
    }

    public Medico(DadosAutenticacao dadosAutenticacao) {
        this.crm =dadosAutenticacao.login();
        this.senha = dadosAutenticacao.senha();

    }

    public void atualizarMedico(MedicoAtualizarDTO dto) {
        if (dto.nome() != null){
            this.nome = dto.nome();
        }
        if (dto.cpf() !=null){
            this.cpf = dto.cpf();
        }
        if (dto.crm() != null){
            this.crm = dto.crm();
        }
        if (dto.email() != null){
            this.email = dto.email();
        }
        if (dto.telefone() != null){
            this.telefone = dto.telefone();
        }
        if (dto.endereco() != null){
            this.endereco = dto.endereco();
        }
        if (dto.dataNascimento() != null){
            this.dataNascimento = dto.dataNascimento();
        }
        if (dto.especialidade() != null){
            this.especialidade = dto.especialidade();
        }
    }
}
