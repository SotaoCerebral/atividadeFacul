package com.saude.facil.demo.entity.paciente;

import com.saude.facil.demo.entity.endereco.Endereco;
import com.saude.facil.demo.entity.paciente.dto.PacienteAtualizarDTO;
import com.saude.facil.demo.entity.paciente.dto.PacienteDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String genero;
    private String estadoCivil;
    private String telefone;
    private String email;
    @Embedded
    private Endereco endereco;

    public Paciente(PacienteDTO dto) {
        this.nomeCompleto = dto.nomeCompleto();
        this.dataNascimento = dto.dataNascimento();
        this.cpf = dto.cpf();
        this.genero = dto.genero();
        this.estadoCivil = dto.estadoCivil();
        this.telefone = dto.telefone();
        this.email = dto.email();

    }

    public void atualizarPaciente(PacienteAtualizarDTO dto) {
        if (dto.nomeCompleto() != null) {
            this.nomeCompleto = dto.nomeCompleto();
        }
        if (dto.cpf() != null) {
            this.cpf = dto.cpf();
        }
        if (dto.dataNascimento() != null) {
            this.dataNascimento = dto.dataNascimento();
        }
        if (dto.genero() != null) {
            this.genero = dto.genero();
        }
        if (dto.estadoCivil() != null) {
            this.estadoCivil = dto.estadoCivil();
        }
        if (dto.telefone() != null) {
            this.telefone = dto.telefone();
        }
        if (dto.email() != null) {
            this.email = dto.email();
        }

    }
}
