package com.bastiongym.service;

import com.bastiongym.model.Exercicio;
import com.bastiongym.model.Treino;
import com.bastiongym.model.TreinoExercicio;
import com.bastiongym.repository.ExercicioRepository;
import com.bastiongym.repository.TreinoExercicioRepository;
import com.bastiongym.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoExercicioService {

    private final TreinoExercicioRepository treinoExercicioRepository;
    private final TreinoRepository treinoRepository;
    private final ExercicioRepository exercicioRepository;

    public TreinoExercicioService(TreinoExercicioRepository treinoExercicioRepository,
                                  TreinoRepository treinoRepository,
                                  ExercicioRepository exercicioRepository) {
        this.treinoExercicioRepository = treinoExercicioRepository;
        this.treinoRepository = treinoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    public List<TreinoExercicio> listarTodos() {
        return treinoExercicioRepository.findAll();
    }

    public Optional<TreinoExercicio> buscarPorId(Long id) {
        return treinoExercicioRepository.findById(id);
    }

    public TreinoExercicio salvar(TreinoExercicio treinoExercicio) {
        Treino treino = treinoRepository.findById(treinoExercicio.getTreino().getIdTreino())
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
        Exercicio exercicio = exercicioRepository.findById(treinoExercicio.getExercicio().getIdExercicio())
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));

        treinoExercicio.setTreino(treino);
        treinoExercicio.setExercicio(exercicio);
        return treinoExercicioRepository.save(treinoExercicio);
    }

    public Optional<TreinoExercicio> atualizar(Long id, TreinoExercicio dadosNovos) {
        return treinoExercicioRepository.findById(id)
                .map(existente -> {
                    existente.setOrdem(dadosNovos.getOrdem());

                    if (dadosNovos.getExercicio() != null && dadosNovos.getExercicio().getIdExercicio() != null) {
                        Exercicio exercicio = exercicioRepository.findById(dadosNovos.getExercicio().getIdExercicio())
                                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
                        existente.setExercicio(exercicio);
                    }

                    return treinoExercicioRepository.save(existente);
                });
    }

    public boolean deletar(Long id) {
        if (!treinoExercicioRepository.existsById(id)) {
            return false;
        }
        treinoExercicioRepository.deleteById(id);
        return true;
    }
}