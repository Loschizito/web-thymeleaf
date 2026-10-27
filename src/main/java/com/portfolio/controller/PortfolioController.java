package com.portfolio.controller;

import com.portfolio.model.Habilidade;
import com.portfolio.model.Projeto;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PortfolioController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("nome", "Bruno Loschi");
        model.addAttribute("cargo", "Desenvolvedor Web em formação");
        model.addAttribute("sobre",
                "Estudante de tecnologia apaixonado por criar interfaces limpas e sistemas bem organizados. "
                        + "Neste portfólio reuno os projetos desenvolvidos durante o curso.");
        model.addAttribute("email", "loschii.bruno@gmail.com");

        model.addAttribute("habilidades", List.of(
                new Habilidade("HTML", 90),
                new Habilidade("CSS", 80),
                new Habilidade("JavaScript", 70),
                new Habilidade("Java", 75),
                new Habilidade("Spring Boot", 65)));

        List<Projeto> projetos = List.of(
                new Projeto("Landing Page", "Página responsiva criada com HTML e CSS.",
                        List.of("HTML", "CSS"), "#"),
                new Projeto("Lista de Tarefas", "Aplicação interativa com manipulação do DOM.",
                        List.of("HTML", "CSS", "JavaScript"), "#"),
                new Projeto("Portfólio Thymeleaf", "Este site, renderizado pelo Spring Boot.",
                        List.of("Java", "Spring Boot", "Thymeleaf"), "#"));
        model.addAttribute("projetos", projetos);

        return "index";
    }

    @PostMapping("/contato")
    public String contato(@RequestParam String nome,
                          @RequestParam String mensagem,
                          RedirectAttributes redirect) {
        redirect.addFlashAttribute("confirmacao",
                "Obrigado, " + nome + "! Sua mensagem foi recebida.");
        return "redirect:/#contato";
    }
}
