package com.example.biblioteca.controller;

import com.example.biblioteca.model.emprestimo;
import com.example.biblioteca.model.livro;
import com.example.biblioteca.model.usuario;
import com.example.biblioteca.service.emprestimoService;
import com.example.biblioteca.service.livroService;
import com.example.biblioteca.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/emprestimos")
public class emprestimoController {

    @Autowired
    private emprestimoService emprestimoService;

    @Autowired
    private usuarioService usuarioService;

    @Autowired
    private livroService livroService;

    @GetMapping
    public String listarEmprestimos(Model model) {
        List<emprestimo> emprestimos = emprestimoService.listarTodos();
        model.addAttribute("emprestimos", emprestimos);
        return "emprestimos/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        List<usuario> usuarios = usuarioService.listarTodos();
        List<livro> livros = livroService.listarTodos();
        model.addAttribute("emprestimo", new emprestimo());
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("livros", livros);
        return "emprestimos/formulario";
    }

    @PostMapping("/novo")
    public String cadastrarEmprestimo(@RequestParam Long usuarioId,
                                      @RequestParam Long livroId) {
        Optional<usuario> usuarioOptional = usuarioService.buscarPorId(usuarioId);
        Optional<livro> livroOptional = livroService.buscarPorId(livroId);

        if (usuarioOptional.isPresent() && livroOptional.isPresent()) {
            usuario usuario = usuarioOptional.get();
            livro livro = livroOptional.get();

            emprestimoService.registrarEmprestimo(usuario, livro);
        }

        return "redirect:/emprestimos";
    }
}
