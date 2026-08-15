package com.bastiongym.service;

import com.bastiongym.model.Treino;
import com.bastiongym.model.Usuario;
import com.bastiongym.repository.TreinoRepository;
import com.bastiongym.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;
    private final UsuarioRepository usuarioRepository;

    public TreinoService(TreinoRepository treinoRepository, UsuarioRepository usuarioRepository) {
        this.treinoRepository = treinoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Treino salvar(Treino treino) {
        Usuario usuario = usuarioRepository.findById(treino.getUsuario().getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        treino.setUsuario(usuario);
        return treinoRepository.save(treino);
    }

    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }

    public Optional<Treino> buscarPorId(Long id) {
        return treinoRepository.findById(id);
    }

    public Optional<Treino> atualizar(Long id, Treino treino) {
        return treinoRepository.findById(id)
                .map(treinoExistente -> {
                    treinoExistente.setNome(treino.getNome());
                    treinoExistente.setTipo(treino.getTipo());

                    if (treino.getUsuario() != null && treino.getUsuario().getId_usuario() != null) {
                        Usuario usuario = usuarioRepository.findById(treino.getUsuario().getId_usuario())
                                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
                        treinoExistente.setUsuario(usuario);
                    }

                    return treinoRepository.save(treinoExistente);
                });
    }

    public boolean deletar(Long id) {
        if (!treinoRepository.existsById(id)) {
            return false;
        }
        treinoRepository.deleteById(id);
        return true;
    }
}