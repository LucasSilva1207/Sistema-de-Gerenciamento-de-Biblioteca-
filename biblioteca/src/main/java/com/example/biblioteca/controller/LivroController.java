@Controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public String listarLivros(Model model) {
        List<Livro> livros = livroService.listarTodos();
        model.addAttribute("livros", livros);
        return "livros/listar"; // Verifique se esse caminho está correto
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/formulario"; // Verifique se esse caminho está correto
    }

    @PostMapping("/novo")
    public String cadastrarLivro(@ModelAttribute Livro livro) {
        livroService.salvarLivro(livro);
        return "redirect:/livros";
    }
}
