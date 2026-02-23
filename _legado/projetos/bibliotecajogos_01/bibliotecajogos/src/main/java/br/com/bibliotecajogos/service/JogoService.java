package br.com.bibliotecajogos.service;

import br.com.bibliotecajogos.entity.Jogo;
import br.com.bibliotecajogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> listarTodos(String sortBy) {
        return jogoRepository.findAll(Sort.by(sortBy));
    }

    public Jogo salvar(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public Jogo buscarPorId(Long id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        jogoRepository.deleteById(id);
    }

    public List<Jogo> pesquisar(String termo, String tipoPesquisa) {
        switch (tipoPesquisa) {
            case "titulo":
                return jogoRepository.findByTituloContainingIgnoreCase(termo);
            case "autor":
                return jogoRepository.findByAutorContainingIgnoreCase(termo);
            case "genero":
                return jogoRepository.findByGeneroContainingIgnoreCase(termo);
            default:
                return List.of();
        }
    }
}