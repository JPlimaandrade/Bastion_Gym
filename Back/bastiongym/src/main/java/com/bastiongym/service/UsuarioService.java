package com.bastiongym.service;

import com.bastiongym.model.Usuario;
import com.bastiongym.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        usuario.setDataCadastro(LocalDate.now());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> atualizar(Long id, Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setNome(usuario.getNome());
                    usuarioExistente.setEmail(usuario.getEmail());
                    usuarioExistente.setSenha(usuario.getSenha());
                    usuarioExistente.setTelefone(usuario.getTelefone());
                    usuarioExistente.setAltura(usuario.getAltura());
                    usuarioExistente.setPeso(usuario.getPeso());
                    usuarioExistente.setFoto(usuario.getFoto());
                    usuarioExistente.setDataNascimento(usuario.getDataNascimento());
                    return usuarioRepository.save(usuarioExistente);
                });
    }

    public boolean deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            return false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }
}