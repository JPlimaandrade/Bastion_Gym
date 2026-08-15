package com.bastiongym.service;

import com.bastiongym.model.Serie;
import com.bastiongym.model.TreinoExercicio;
import com.bastiongym.repository.SerieRepository;
import com.bastiongym.repository.TreinoExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    private final SerieRepository serieRepository;
    private final TreinoExercicioRepository treinoExercicioRepository;

    public SerieService(SerieRepository serieRepository, TreinoExercicioRepository treinoExercicioRepository) {
        this.serieRepository = serieRepository;
        this.treinoExercicioRepository = treinoExercicioRepository;
    }

    public List<Serie> listarTodos() {
        return serieRepository.findAll();
    }

    public Optional<Serie> buscarPorId(Long id) {
        return serieRepository.findById(id);
    }

    public Serie salvar(Serie serie) {
        TreinoExercicio treinoExercicio = treinoExercicioRepository.findById(serie.getTreinoExercicio().getIdTreinoExercicio())
                .orElseThrow(() -> new RuntimeException("Treino_Exercicio não encontrado"));
        serie.setTreinoExercicio(treinoExercicio);
        return serieRepository.save(serie);
    }

    public Optional<Serie> atualizar(Long id, Serie dadosNovos) {
        return serieRepository.findById(id)
                .map(existente -> {
                    existente.setNumeroSerie(dadosNovos.getNumeroSerie());
                    existente.setPeso(dadosNovos.getPeso());
                    existente.setRepeticoes(dadosNovos.getRepeticoes());
                    existente.setDescanso(dadosNovos.getDescanso());
                    return serieRepository.save(existente);
                });
    }

    public boolean deletar(Long id) {
        if (!serieRepository.existsById(id)) {
            return false;
        }
        serieRepository.deleteById(id);
        return true;
    }
}