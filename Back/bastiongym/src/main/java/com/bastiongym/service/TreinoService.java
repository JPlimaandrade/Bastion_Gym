package com.bastiongym.service;

import com.bastiongym.model.Treino;
import com.bastiongym.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }
    // Salvar treino CREATE
    public Treino salvar(Treino treino) {
        return treinoRepository.save(treino);
    }

    // Listar todos os treinos READ
    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }

    //Buscar treino por ID READ
    public Optional<Treino> buscarPorId(Long id) {
        return treinoRepository.findById(id);
    }

    // Atualizar treino se existir UPDATE
    public Optional<Treino> atualizar(Long id, Treino treino) {

        return treinoRepository.findById(id)
                .map(treinoExistente -> {
                    treinoExistente.setNome(treino.getNome());
                    treinoExistente.setTipo(treino.getTipo());
                    treinoExistente.setUsuario(treino.getUsuario());

                    return treinoRepository.save(treinoExistente);
                });
    }

    // Excluir treino se existir DELETE
    public boolean deletar(Long id) {

        if (!treinoRepository.existsById(id)) {
            return false;
        }

        treinoRepository.deleteById(id);
        return true;
    }

}
