package com.example.biblioteca.repository;

import com.example.biblioteca.model.livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface livroRepository extends JpaRepository<livro, Long> {
    
}
