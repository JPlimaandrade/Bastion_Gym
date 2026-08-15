package com.bastiongym.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serie")
    private Long idSerie;

    @ManyToOne
    @JoinColumn(name = "id_treino_exercicio", nullable = false)
    private TreinoExercicio treinoExercicio;

    @Column(name = "numero_serie", nullable = false)
    private Integer numeroSerie;

    @Column(name = "peso", nullable = false)
    private BigDecimal peso;

    @Column(name = "repeticoes", nullable = false)
    private Integer repeticoes;

    @Column(name = "descanso", nullable = false)
    private Integer descanso;
}