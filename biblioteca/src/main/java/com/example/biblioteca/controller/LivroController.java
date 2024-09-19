package com.example.biblioteca.controller;

import com.example.biblioteca.model.livro;
import com.example.biblioteca.service.livroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class livroController {

    @Autowired
    private livroService livroService;

    @GetMapping
    public String listarLivros(Model model) {
        List<livro> livros = livroService.listarTodos();
        model.addAttribute("livros", livros);
        return "livros/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("livro", new livro());
        return "livros/formulario";
    }

    @PostMapping("/novo")
    public String cadastrarLivro(@ModelAttribute livro livro) {
        livroService.salvarLivro(livro);
        return "redirect:/livros";
    }
}
