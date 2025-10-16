package br.com.curso.listadetarefas.api.tarefa;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class TarefaWebController {

    private final TarefaService tarefaService;

    public TarefaWebController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public String index(Model model) {
        var tarefasOrdenadas = tarefaService.listarTodas()
                .stream()
                .sorted(Comparator.comparing(Tarefa::getId))
                .collect(Collectors.toList());
        model.addAttribute("tarefas", tarefasOrdenadas);
        return "index";
    }

    @PostMapping("/tarefas")
    public String criarTarefa(@RequestParam String titulo, Model model) {
        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setTitulo(titulo);
        novaTarefa.setDescricao("");
        novaTarefa.setConcluida(false);
        Tarefa tarefaSalva = tarefaService.salvar(novaTarefa); // Use salvar
        model.addAttribute("tarefa", tarefaSalva);
        return "fragments :: linha-tarefa";
    }

    @DeleteMapping("/tarefas/{id}")
    @ResponseBody
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tarefas/{id}/toggle")
    public String toggleTarefa(@PathVariable Long id, Model model) {
        return tarefaService.atualizarStatusTarefa(id)
                .map(tarefa -> {
                    model.addAttribute("tarefa", tarefa);
                    return "fragments :: linha-tarefa";
                })
                .orElse("");
    }

    @GetMapping("/tarefas/{id}/edit")
    public String getEditForm(@PathVariable Long id, Model model) {
        return tarefaService.findById(id)
                .map(tarefa -> {
                    model.addAttribute("tarefa", tarefa);
                    return "fragments :: edit-form";
                })
                .orElse("");
    }

    @PutMapping("/tarefas/{id}")
    public String atualizarTarefaWeb(@PathVariable Long id, @RequestParam String titulo, Model model) {
        return tarefaService.findById(id)
                .map(tarefaExistente -> {
                    tarefaExistente.setTitulo(titulo);
                    Tarefa tarefaAtualizada = tarefaService.salvar(tarefaExistente); // Use salvar
                    model.addAttribute("tarefa", tarefaAtualizada);
                    return "fragments :: linha-tarefa";
                })
                .orElse("");
    }

    @GetMapping("/tarefas/{id}")
    public String getTarefa(@PathVariable Long id, Model model) {
        return tarefaService.findById(id)
                .map(tarefa -> {
                    model.addAttribute("tarefa", tarefa);
                    return "fragments :: linha-tarefa";
                })
                .orElse("");
    }
}
