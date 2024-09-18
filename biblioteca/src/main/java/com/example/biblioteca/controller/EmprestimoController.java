package com.example.biblioteca.controller;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.EmprestimoService;
import com.example.biblioteca.service.LivroService;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LivroService livroService;

    @GetMapping
    public String listarEmprestimos(Model model) {
        List<Emprestimo> emprestimos = emprestimoService.listarTodos();
        model.addAttribute("emprestimos", emprestimos);
        return "emprestimos/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        List<Usuario> usuarios = usuarioService.listarTodosUsuarios();
        List<Livro> livros = livroService.listarTodosLivros();
        model.addAttribute("emprestimo", new Emprestimo());
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("livros", livros);
        return "emprestimos/formulario";
    }

    @PostMapping("/novo")
    public String cadastrarEmprestimo(@ModelAttribute Emprestimo emprestimo,
                                      @RequestParam Long usuarioId,
                                      @RequestParam Long livroId) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(usuarioId);
        Livro livro = livroService.buscarLivroPorId(livroId);

        if (usuario != null && livro != null) {
            emprestimo.setUsuario(usuario);
            emprestimo.setLivro(livro);
            emprestimo.setDataEmprestimo(LocalDate.now());
            emprestimo.setDevolvido(false);

            emprestimoService.registrarEmprestimo(usuario, livro);
        }

        return "redirect:/emprestimos";
    }
}
