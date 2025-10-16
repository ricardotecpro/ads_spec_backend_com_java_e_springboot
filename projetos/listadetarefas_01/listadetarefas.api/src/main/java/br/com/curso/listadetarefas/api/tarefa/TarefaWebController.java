package br.com.curso.listadetarefas.api.tarefa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/") // Responderá na raiz da aplicação: http://localhost:8080/
public class TarefaWebController {

    private final TarefaService tarefaService;

    public TarefaWebController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public String index(Model model) {
        // Buscamos todas as tarefas e as ordenamos por ID para consistência
        var tarefasOrdenadas = tarefaService.listarTodas()
                .stream()
                .sorted(Comparator.comparing(Tarefa::getId))
                .collect(Collectors.toList());

        // Adicionamos a lista de tarefas ao modelo que será enviado para o Thymeleaf
        model.addAttribute("tarefas", tarefasOrdenadas);

        // Retorna o nome do arquivo HTML (sem a extensão .html)
        return "index";
    }
    @PostMapping("/tarefas")
public String criarTarefa(@RequestParam String titulo, Model model) {
    // Cria e salva a nova tarefa
    Tarefa novaTarefa = new Tarefa();
    novaTarefa.setTitulo(titulo);
    novaTarefa.setDescricao(""); // Pode ser deixado em branco ou vir do form
    novaTarefa.setConcluida(false);
    Tarefa tarefaSalva = tarefaService.criarTarefa(novaTarefa);

    // Prepara o modelo APENAS com a nova tarefa
    model.addAttribute("tarefa", tarefaSalva);

    // Retorna o caminho para o FRAGMENTO, não a página inteira
    return "fragments :: linha-tarefa";
}
}