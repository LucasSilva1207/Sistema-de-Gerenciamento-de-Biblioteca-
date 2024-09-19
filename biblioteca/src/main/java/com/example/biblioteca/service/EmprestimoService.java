package com.example.biblioteca.service;

import com.example.biblioteca.model.emprestimo;
import com.example.biblioteca.model.livro;
import com.example.biblioteca.model.usuario;
import com.example.biblioteca.repository.emprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class emprestimoService {

    @Autowired
    private emprestimoRepository emprestimoRepository;

    // Registrar um novo empréstimo
    public emprestimo registrarEmprestimo(usuario usuario, livro livro) {
        emprestimo emprestimo = new emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDevolvido(false);
        return emprestimoRepository.save(emprestimo);
    }

    // Registrar devolução de um livro      
    public emprestimo registrarDevolucao(Long idEmprestimo) {
        emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo).orElse(null);
        if (emprestimo != null && !emprestimo.isDevolvido()) {
            emprestimo.setDevolvido(true);
            emprestimo.setDataDevolucao(LocalDate.now());
            return emprestimoRepository.save(emprestimo);
        }
        return null;
    }

    // Listar todos os empréstimos
    public List<emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    // Listar todos os empréstimos ativos
    public List<emprestimo> listarEmprestimosAtivos() {
        return emprestimoRepository.findByDevolvidoFalse();
    }
}
