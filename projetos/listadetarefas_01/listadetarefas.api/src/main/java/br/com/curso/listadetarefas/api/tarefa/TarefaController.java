package br.com.curso.listadetarefas.api.tarefa;

// Novas importações

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
// Novas importações
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // Spring: Define que esta classe é um controller REST
@RequestMapping("/tarefas") // Define a URL base para todos os métodos: http://localhost:8080/tarefas
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping // Mapeia requisições HTTP GET para este método
    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTodas();
    }

    // NOVO MÉTODO
    @PostMapping // Mapeia requisições HTTP POST
    @ResponseStatus(HttpStatus.CREATED) // Retorna o status 201 Created em caso de sucesso
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        // @RequestBody indica que os dados da tarefa virão no corpo da requisição
        return tarefaService.criarTarefa(tarefa);
    }

    // NOVO MÉTODO
    @PutMapping("/{id}") // Mapeia requisições HTTP PUT para /tarefas/{id}
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        // @PathVariable extrai o 'id' da URL
        return tarefaService.atualizarTarefa(id, tarefa)
                .map(tarefaAtualizada -> ResponseEntity.ok(tarefaAtualizada))
                .orElse(ResponseEntity.notFound().build()); // Retorna 404 se não encontrar
    }
}