package com.bastiongym.controller;

import com.bastiongym.dto.SerieResponseDTO;
import com.bastiongym.model.Serie;
import com.bastiongym.service.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public List<SerieResponseDTO> listarTodos() {
        return serieService.listarTodos().stream()
                .map(SerieResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieResponseDTO> buscarPorId(@PathVariable Long id) {
        return serieService.buscarPorId(id)
                .map(SerieResponseDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SerieResponseDTO salvar(@RequestBody Serie serie) {
        return SerieResponseDTO.fromEntity(serieService.salvar(serie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SerieResponseDTO> atualizar(@PathVariable Long id, @RequestBody Serie serie) {
        return serieService.atualizar(id, serie)
                .map(SerieResponseDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!serieService.deletar(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}