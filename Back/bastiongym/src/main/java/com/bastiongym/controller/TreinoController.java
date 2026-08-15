package com.bastiongym.controller;

import com.bastiongym.model.Treino;
import com.bastiongym.service.TreinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    // GET todos os treino
    @GetMapping
    public List<Treino> listarTodos() {
        return treinoService.listarTodos();
    }
    // GET treino por id
    @GetMapping("/{id}")
    public ResponseEntity<Treino> buscarPorId(@PathVariable Long id) {

        return treinoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST criar treino
    @PostMapping
    public Treino salvar(@RequestBody Treino treino) {
        return treinoService.salvar(treino);
    }

    // PUT atualizar treino
    @PutMapping("/{id}")
    public ResponseEntity<Treino> atualizar(
            @PathVariable Long id,
            @RequestBody Treino treino) {

        return treinoService.atualizar(id, treino)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE deletar treino
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!treinoService.deletar(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}