package com.example.biblioteca.repository;

import com.example.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    // Encontra todos os empréstimos que não foram devolvidos
    List<Emprestimo> findByDevolvidoFalse();
}
