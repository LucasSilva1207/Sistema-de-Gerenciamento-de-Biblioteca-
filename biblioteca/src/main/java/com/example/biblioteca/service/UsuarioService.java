package com.example.biblioteca.service;

import com.example.biblioteca.model.usuario;
import com.example.biblioteca.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioService {

    @Autowired
    private usuarioRepository usuarioRepository;

    public usuario salvarUsuario(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
