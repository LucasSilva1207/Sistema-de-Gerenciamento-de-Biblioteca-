package com.example.biblioteca.controller;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarTodosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    @PostMapping("/novo")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.criarUsuario(usuario);
        return "redirect:/usuarios";
    }
}
