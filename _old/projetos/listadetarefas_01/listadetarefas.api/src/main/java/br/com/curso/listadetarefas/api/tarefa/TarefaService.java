package br.com.curso.listadetarefas.api.tarefa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> findById(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa salvar(Tarefa tarefa) { // Renamed from criarTarefa
        return tarefaRepository.save(tarefa);
    }

    public Optional<Tarefa> atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
            .map(tarefaExistente -> {
                tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
                tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
                tarefaExistente.setConcluida(tarefaAtualizada.isConcluida());
                return tarefaRepository.save(tarefaExistente);
            });
    }

    public boolean deletarTarefa(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Tarefa> atualizarStatusTarefa(Long id) {
        return tarefaRepository.findById(id)
            .map(tarefa -> {
                tarefa.setConcluida(!tarefa.isConcluida());
                return tarefaRepository.save(tarefa);
            });
    }
}
