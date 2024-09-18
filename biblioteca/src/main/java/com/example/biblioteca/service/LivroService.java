package com.example.biblioteca.service;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
