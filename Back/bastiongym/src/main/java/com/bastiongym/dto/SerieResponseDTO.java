package com.bastiongym.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class SerieResponseDTO {
    private Long id;
    private Long idTreinoExercicio;
    private String nomeExercicio;
    private Integer numeroSerie;
    private BigDecimal peso;
    private Integer repeticoes;
    private Integer descanso;

    public static SerieResponseDTO fromEntity(com.bastiongym.model.Serie s) {
        SerieResponseDTO dto = new SerieResponseDTO();
        dto.setId(s.getIdSerie());
        dto.setIdTreinoExercicio(s.getTreinoExercicio().getIdTreinoExercicio());
        dto.setNomeExercicio(s.getTreinoExercicio().getExercicio().getNome());
        dto.setNumeroSerie(s.getNumeroSerie());
        dto.setPeso(s.getPeso());
        dto.setRepeticoes(s.getRepeticoes());
        dto.setDescanso(s.getDescanso());
        return dto;
    }
}