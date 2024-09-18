package com.example.biblioteca.repository;

import com.example.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    @Query("SELECT e FROM Emprestimo e WHERE e.devolvido = false")
    List<Emprestimo> findByDevolvidoFalse();
}
