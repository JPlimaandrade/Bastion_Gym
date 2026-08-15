package com.bastiongym.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "altura", precision = 3, scale = 2)
    private BigDecimal altura;

    @Column(name = "peso", precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(name = "foto", length = 255)
    private String foto;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
   
}
