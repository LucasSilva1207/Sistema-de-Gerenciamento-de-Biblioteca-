package com.example.biblioteca.service;

import com.example.biblioteca.model.livro;
import com.example.biblioteca.repository.livroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class livroService {

    @Autowired
    private livroRepository livroRepository;

    public livro salvarLivro(livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public List<livro> listarTodos() {
        return livroRepository.findAll();
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    
}
