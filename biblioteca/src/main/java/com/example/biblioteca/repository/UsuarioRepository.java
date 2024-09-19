package com.example.biblioteca.repository;

import com.example.biblioteca.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository<usuario, Long> {
    
}
