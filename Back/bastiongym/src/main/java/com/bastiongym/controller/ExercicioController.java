package com.bastiongym.controller;

import com.bastiongym.model.Exercicio;
import com.bastiongym.service.ExercicioService;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    // GET todos os exercicios
    @GetMapping
    public List<Exercicio> listarTodos() {
        return exercicioService.listarTodos();
    }

    // GET exercicio por id
    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> buscarPorId(@PathVariable Long id) {
        return exercicioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST criar exercicio
    @PostMapping
    public Exercicio salvar(@RequestBody Exercicio exercicio) {
        return exercicioService.salvar(exercicio);
    }

    // PUT atualizar exercicio
    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizar(
            @PathVariable Long id,
            @RequestBody Exercicio exercicio) {

        return exercicioService.atualizar(id, exercicio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE deletar exercicio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!exercicioService.deletar(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
