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

    // Salvar usuario CREATE
    public Usuario salvar(Usuario usuario) {
         usuario.setDataCadastro(LocalDate.now()); // Define a data de cadastro atual
        return usuarioRepository.save(usuario);
    }

    // Listar todos os usuarios READ
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Buscar usuario por ID READ
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Atualizar usuario se existir UPDATE
    public Usuario atualizar(Long id, Usuario usuario) {

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setSenha(usuario.getSenha());
        usuarioExistente.setTelefone(usuario.getTelefone());
        usuarioExistente.setAltura(usuario.getAltura());
        usuarioExistente.setPeso(usuario.getPeso());
        usuarioExistente.setFoto(usuario.getFoto());

        return usuarioRepository.save(usuarioExistente);
    }

    // Excluir usuario se existir DELETE
    public void excluir(Long id) {

        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }

        usuarioRepository.deleteById(id);
    }
}

