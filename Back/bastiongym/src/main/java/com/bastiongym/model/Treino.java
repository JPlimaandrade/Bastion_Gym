package com.bastiongym.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "treino")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treino")
    private Long idTreino;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
}
