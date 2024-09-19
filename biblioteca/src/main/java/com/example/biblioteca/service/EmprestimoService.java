package com.example.biblioteca.service;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    // Registrar um novo empréstimo
    public Emprestimo registrarEmprestimo(Usuario usuario, Livro livro) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDevolvido(false);
        return emprestimoRepository.save(emprestimo);
    }

    // Registrar devolução de um livro      
    public Emprestimo registrarDevolucao(Long idEmprestimo) {
        Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo).orElse(null);
        if (emprestimo != null && !emprestimo.isDevolvido()) {
            emprestimo.setDevolvido(true);
            emprestimo.setDataDevolucao(LocalDate.now());
            return emprestimoRepository.save(emprestimo);
        }
        return null;
    }

    // Listar todos os empréstimos
    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    // Listar todos os empréstimos ativos
    public List<Emprestimo> listarEmprestimosAtivos() {
        return emprestimoRepository.findByDevolvidoFalse();
    }
}
