package br.com.curso.listadetarefas.api.tarefa;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // --- Endpoints para a Página Web (HTML) ---

    @GetMapping
    public String index(Model model) {
        var tarefasOrdenadas = tarefaService.listarTodas().stream()
                .sorted(Comparator.comparing(Tarefa::getId))
                .collect(Collectors.toList());
        model.addAttribute("tarefas", tarefasOrdenadas);
        model.addAttribute("novaTarefa", new Tarefa());
        return "index";
    }

    @GetMapping("/list")
    public String listTarefas(Model model, HttpServletResponse response) {
        // Impede o cache da resposta pelo navegador
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        var tarefasOrdenadas = tarefaService.listarTodas().stream()
            .sorted(Comparator.comparing(Tarefa::getId))
            .collect(Collectors.toList());
        model.addAttribute("tarefas", tarefasOrdenadas);
        return "fragments :: lista-tarefas";
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String criarTarefaWeb(@ModelAttribute Tarefa tarefa, Model model) {
        Tarefa tarefaSalva = tarefaService.salvar(tarefa);
        model.addAttribute("tarefa", tarefaSalva);
        return "fragments :: linha-tarefa";
    }

    @GetMapping(value = "/{id}/edit", produces = MediaType.TEXT_HTML_VALUE)
    public String getEditForm(@PathVariable Long id, Model model) {
        return tarefaService.findById(id)
                .map(tarefa -> {
                    model.addAttribute("tarefa", tarefa);
                    return "fragments :: edit-form";
                })
                .orElse(""); // Retorna vazio se não encontrar
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String atualizarTarefaWeb(@PathVariable Long id, @ModelAttribute Tarefa tarefa, Model model) {
        return tarefaService.atualizarTarefa(id, tarefa)
                .map(tarefaAtualizada -> {
                    model.addAttribute("tarefa", tarefaAtualizada);
                    return "fragments :: linha-tarefa";
                })
                .orElse("");
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ResponseEntity<String> deletarTarefaWeb(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/{id}/toggle", produces = MediaType.TEXT_HTML_VALUE)
    public String toggleTarefaWeb(@PathVariable Long id, Model model) {
        return tarefaService.atualizarStatusTarefa(id)
                .map(tarefa -> {
                    model.addAttribute("tarefa", tarefa);
                    return "fragments :: linha-tarefa";
                })
                .orElse("");
    }

    // --- Endpoints para a API (JSON) ---

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Tarefa> listarTarefasApi() {
        return tarefaService.listarTodas();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Tarefa> buscarPorIdApi(@PathVariable Long id) {
        return tarefaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa criarTarefaApi(@RequestBody Tarefa tarefa) {
        return tarefaService.salvar(tarefa);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Tarefa> atualizarTarefaApi(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizarTarefa(id, tarefa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> deletarTarefaApi(@PathVariable Long id) {
        if (tarefaService.deletarTarefa(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
