package br.com.bibliotecajogos.repository;

import br.com.bibliotecajogos.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo> findByTituloContainingIgnoreCase(String titulo);

    List<Jogo> findByAutorContainingIgnoreCase(String autor);

    List<Jogo> findByGeneroContainingIgnoreCase(String genero);
}