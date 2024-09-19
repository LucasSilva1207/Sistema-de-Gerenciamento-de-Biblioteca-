package com.example.biblioteca.repository;

import com.example.biblioteca.model.emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface emprestimoRepository extends JpaRepository<emprestimo, Long> {
    List<emprestimo> findByDevolvidoFalse();
}
