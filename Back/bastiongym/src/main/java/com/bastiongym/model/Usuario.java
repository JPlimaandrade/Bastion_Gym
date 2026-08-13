package com.bastiongym.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    //Construtor

    //Construtor vazio 
    // Obrigatório para o JPA
    public Usuario() {
    }

    //Construtor com todos os campos
    //Facilita a criação de objetos usuario manualmente
    //Sem id_usuario pois o banco gera automaticamente
    public Usuario( 
        String nome, 
        String email, 
        String senha, 
        String telefone, 
        BigDecimal altura, 
        BigDecimal peso, 
        String foto, 
        LocalDate dataCadastro) 
    {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.altura = altura;
        this.peso = peso;
        this.foto = foto;
        this.dataCadastro = dataCadastro;
    }
    
}
