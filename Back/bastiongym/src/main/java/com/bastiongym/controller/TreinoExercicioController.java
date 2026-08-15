package com.bastiongym.controller;

import com.bastiongym.dto.TreinoExercicioResponseDTO;
import com.bastiongym.model.TreinoExercicio;
import com.bastiongym.service.TreinoExercicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treino-exercicios")
public class TreinoExercicioController {

    private final TreinoExercicioService treinoExercicioService;

    public TreinoExercicioController(TreinoExercicioService treinoExercicioService) {
        this.treinoExercicioService = treinoExercicioService;
    }

    @GetMapping
    public List<TreinoExercicioResponseDTO> listarTodos() {
        return treinoExercicioService.listarTodos().stream()
                .map(TreinoExercicioResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoExercicioResponseDTO> buscarPorId(@PathVariable Long id) {
        return treinoExercicioService.buscarPorId(id)
                .map(TreinoExercicioResponseDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TreinoExercicioResponseDTO salvar(@RequestBody TreinoExercicio treinoExercicio) {
        return TreinoExercicioResponseDTO.fromEntity(treinoExercicioService.salvar(treinoExercicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoExercicioResponseDTO> atualizar(@PathVariable Long id, @RequestBody TreinoExercicio treinoExercicio) {
        return treinoExercicioService.atualizar(id, treinoExercicio)
                .map(TreinoExercicioResponseDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!treinoExercicioService.deletar(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}