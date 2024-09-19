package com.example.biblioteca.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Emprestimo> emprestimos = new HashSet<>();

    // Construtores
    public Usuario() {}

    public Usuario(String nome, String email, String senha, TipoUsuario tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Set<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(Set<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public enum TipoUsuario {
        ADMINISTRADOR,
        BIBLIOTECARIO,
        MEMBRO
    }

    // Adiciona um empréstimo
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        emprestimo.setUsuario(this);
    }

    // Remove um empréstimo
    public void removerEmprestimo(Emprestimo emprestimo) {
        emprestimos.remove(emprestimo);
        emprestimo.setUsuario(null);
    }
}
