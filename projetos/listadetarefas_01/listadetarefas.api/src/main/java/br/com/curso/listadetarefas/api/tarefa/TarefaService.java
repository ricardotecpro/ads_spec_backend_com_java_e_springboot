package br.com.curso.listadetarefas.api.tarefa;
// ... (dentro da classe TarefaService)
import java.util.Optional; // Importe esta classe
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Spring: Marca como um componente de serviço
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    // Injeção de dependência via construtor (prática recomendada)
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    // Outros métodos (criar, atualizar, etc.) virão aqui...

    public Tarefa criarTarefa(Tarefa tarefa) {
        // Aqui poderíamos adicionar regras de negócio,
        // como validações, antes de salvar.
        return tarefaRepository.save(tarefa);
    }

    public Optional<Tarefa> atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
        // Busca a tarefa pelo ID para garantir que ela existe
        return tarefaRepository.findById(id)
            .map(tarefaExistente -> {
                tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
                tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
                tarefaExistente.setConcluida(tarefaAtualizada.isConcluida());
                return tarefaRepository.save(tarefaExistente);
            });
    }

}