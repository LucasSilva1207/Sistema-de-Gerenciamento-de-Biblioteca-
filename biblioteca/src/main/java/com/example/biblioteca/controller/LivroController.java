package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public String listarLivros(Model model) {
        List<Livro> livros = livroService.listarTodos();
        model.addAttribute("livros", livros);
        return "livros/listar"; // Caminho para a visualização de lista de livros
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/formulario"; // Caminho para o formulário de cadastro de livro
    }

    @PostMapping("/novo")
    public String cadastrarLivro(@ModelAttribute Livro livro) {
        livroService.salvarLivro(livro);
        return "redirect:/livros"; // Redireciona para a lista de livros após a criação
    }
}
