package com.bastiongym.service;

import com.bastiongym.repository.ExercicioRepository;
import org.springframework.stereotype.Service;
import com.bastiongym.model.Exercicio;
import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    // Salvar exercicio CREATE
    public Exercicio salvar(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    // Listar todos os exercicios READ
    public List<Exercicio> listarTodos() {
        return exercicioRepository.findAll();
    }

    // Buscar exercicio por ID READ
    public Optional<Exercicio> buscarPorId(Long id) {
        return exercicioRepository.findById(id);
    }

    // Atualizar exercicio se existir UPDATE
    public Optional<Exercicio> atualizar(Long id, Exercicio exercicio) {

        return exercicioRepository.findById(id)
                .map(exercicioExistente -> {
                    exercicioExistente.setNome(exercicio.getNome());
                    return exercicioRepository.save(exercicioExistente);
                });
    }

    // Excluir exercicio se existir DELETE
    public boolean deletar(Long id) {

        if (!exercicioRepository.existsById(id)) {
            return false;
        }

        exercicioRepository.deleteById(id);
        return true;
    }
}
