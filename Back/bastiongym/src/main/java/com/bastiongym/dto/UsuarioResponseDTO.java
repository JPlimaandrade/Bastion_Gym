package com.bastiongym.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private BigDecimal altura;
    private BigDecimal peso;
    private String foto;
    private LocalDate dataCadastro;
    private LocalDate dataNascimento;

    public static UsuarioResponseDTO fromEntity(com.bastiongym.model.Usuario u) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(u.getId_usuario());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setTelefone(u.getTelefone());
        dto.setAltura(u.getAltura());
        dto.setPeso(u.getPeso());
        dto.setFoto(u.getFoto());
        dto.setDataCadastro(u.getDataCadastro());
        dto.setDataNascimento(u.getDataNascimento());
        return dto;
    }
}