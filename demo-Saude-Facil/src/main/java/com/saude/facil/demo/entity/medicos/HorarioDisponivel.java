package com.saude.facil.demo.entity.medicos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "horarios-disponiveis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class HorarioDisponivel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long medicoId;
    private String data;
    private String hora;
    private Boolean disponivel;
}
