package br.com.curso.listadetarefas.api.tarefa;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok: gera getters, setters, etc.
@Entity // JPA: Marca como uma entidade
@Table(name = "tb_tarefas") // JPA: Define o nome da tabela
public class Tarefa {

    @Id // JPA: Marca como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA: Define a geração automática do ID
    private Long id;

    private String titulo;
    private String descricao;
    private boolean concluida;
}