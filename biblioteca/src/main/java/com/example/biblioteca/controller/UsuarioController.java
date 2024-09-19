package com.example.biblioteca.controller;

import com.example.biblioteca.model.usuario;
import com.example.biblioteca.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class usuarioController {

    @Autowired
    private usuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<usuario> usuarios = usuarioService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new usuario());
        return "usuarios/formulario";
    }

    @PostMapping("/novo")
    public String cadastrarUsuario(@ModelAttribute usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return "redirect:/usuarios";
    }
}
