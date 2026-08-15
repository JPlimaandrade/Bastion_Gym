package com.bastiongym.service;

import com.bastiongym.model.Usuario;
import com.bastiongym.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario salvar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
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

                    // só re-hasheia se veio uma senha nova no body
                    if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
                        usuarioExistente.setSenha(passwordEncoder.encode(usuario.getSenha()));
                    }

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