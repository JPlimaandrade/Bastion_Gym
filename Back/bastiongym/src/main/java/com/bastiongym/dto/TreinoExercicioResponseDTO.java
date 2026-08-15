package com.bastiongym.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreinoExercicioResponseDTO {
    private Long id;
    private Long idTreino;
    private String nomeTreino;
    private Long idExercicio;
    private String nomeExercicio;
    private Integer ordem;

    public static TreinoExercicioResponseDTO fromEntity(com.bastiongym.model.TreinoExercicio te) {
        TreinoExercicioResponseDTO dto = new TreinoExercicioResponseDTO();
        dto.setId(te.getIdTreinoExercicio());
        dto.setIdTreino(te.getTreino().getIdTreino());
        dto.setNomeTreino(te.getTreino().getNome());
        dto.setIdExercicio(te.getExercicio().getIdExercicio());
        dto.setNomeExercicio(te.getExercicio().getNome());
        dto.setOrdem(te.getOrdem());
        return dto;
    }
}