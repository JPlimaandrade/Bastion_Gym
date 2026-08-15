package com.bastiongym.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreinoResponseDTO {
    private Long id;
    private String nome;
    private String tipo;
    private Long idUsuario;
    private String nomeUsuario;

    public static TreinoResponseDTO fromEntity(com.bastiongym.model.Treino t) {
        TreinoResponseDTO dto = new TreinoResponseDTO();
        dto.setId(t.getIdTreino());
        dto.setNome(t.getNome());
        dto.setTipo(t.getTipo());
        dto.setIdUsuario(t.getUsuario().getId_usuario());
        dto.setNomeUsuario(t.getUsuario().getNome());
        return dto;
    }
}