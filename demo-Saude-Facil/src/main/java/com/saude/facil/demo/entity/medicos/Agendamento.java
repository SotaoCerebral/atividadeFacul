package com.saude.facil.demo.entity.medicos;

import com.saude.facil.demo.entity.medicos.enums.StatusAgendamento;
import com.saude.facil.demo.entity.medicos.enums.TipoConsulta;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long pacientId;
    private Long medicoId;
    private String dataHora;
    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;
    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;
    private String observacoes;
}
