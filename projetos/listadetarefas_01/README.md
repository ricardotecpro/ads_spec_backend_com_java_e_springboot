# 🚀 Projeto Lista de Tarefas" (To-Do List)
 v1.0

Este guia é uma sequência didática projetada para ensinar, passo a passo, como construir uma API RESTful robusta e moderna utilizando Spring Boot. Vamos abordar desde a configuração inicial até práticas avançadas de engenharia de software.

## 🎯 Objetivo

Ao final deste tutorial, você terá construído uma API completa para um sistema de "Lista de Tarefas" (To-Do List), capaz de realizar as operações de **Criar, Ler, Atualizar e Deletar** (CRUD).

## 🛠️ Módulo 1: Preparando o Terreno

### 1.1 - Configurando o Projeto

Vamos começar criando nosso projeto com o **Spring Initializr**, a ferramenta oficial para iniciar projetos Spring.

1.  Acesse [start.spring.io](https://start.spring.io).
2.  Preencha os metadados do projeto:
    *   **Project**: `Maven`
    *   **Language**: `Java`
    *   **Spring Boot**: Use a versão estável mais recente (ex: 3.x.x).
    *   **Group**: `br.com.curso`
    *   **Artifact**: `listadetarefas.api`
    *   **Description**: `Projeto Lista de Tarefas" (To-Do List)`
    *   **Package name**: `br.com.curso.listadetarefas.api`
    *   **Packaging**: `Jar`
    *   **Java**: `21` (ou a versão que você tiver instalada)
3.  Adicione as seguintes dependências (`Dependencies`):
    *   `Spring Web`: Para criar APIs REST.
    *   `Spring Data JPA`: Para facilitar o acesso a dados.
    *   `H2 Database`: Um banco de dados em memória, ótimo para desenvolvimento.
    *   `Lombok`: Para reduzir código repetitivo (getters, setters, etc.).
    *   `Spring Boot DevTools`: Para reinicializações automáticas durante o desenvolvimento.
4.  Clique em **GENERATE** e extraia o arquivo `.zip` em seu computador.

### 1.2 - Estrutura Inicial do Projeto

Após abrir o projeto em sua IDE (IntelliJ, VS Code, Eclipse), a estrutura de pastas será a seguinte:

```
listadetarefas.api/
├── pom.xml                # Arquivo de configuração do Maven com nossas dependências
└── src/
    ├── main/
    │   ├── java/
    │   │   └── br/com/curso/listadetarefasapi/
    │   │       └── listadetarefasApiApplication.java  # Ponto de entrada da aplicação
    │   └── resources/
    │       └── application.properties         # Configurações da aplicação
    └── test/
        └── ...
```

### 1.3 - Configurando o Banco de Dados

Abra o arquivo `src/main/resources/application.properties` e adicione as seguintes linhas para configurar nosso banco de dados H2 em memória:

```properties
# Nome da aplicação
spring.application.name=listadetarefas.api

# Habilita o console web do H2 para visualizarmos o banco
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configurações de conexão com o banco
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Informa ao Hibernate qual "dialeto" SQL usar
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Garante que as tabelas sejam criadas antes de tentar inserir dados
spring.jpa.defer-datasource-initialization=true
```

## 📦 Módulo 2: A Camada de Dados

Nesta etapa, vamos modelar como os dados de uma "Tarefa" serão armazenados.

### 2.1 - Criando a Entidade `Tarefa`

Uma **Entidade** é uma classe Java que representa uma tabela no banco de dados.

1.  Crie um novo pacote chamado `tarefa` dentro de `br.com.curso.listadetarefas.api`.
2.  Dentro deste pacote, crie a classe `Tarefa.java`.

```java
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
```

### 2.2 - Diagrama Entidade-Relacionamento (ER)

A classe acima será mapeada para a seguinte estrutura no banco de dados:

```mermaid
erDiagram
    TB_TAREFAS {
        Long id PK "Chave Primária, Auto-incremento"
        String titulo "Título da tarefa"
        String descricao "Descrição detalhada"
        boolean concluida "Indica se a tarefa foi finalizada"
    }
```

### 2.3 - Criando o Repositório `TarefaRepository`

Um **Repositório** é uma interface que abstrai o acesso aos dados. O Spring Data JPA implementará os métodos para nós!

1.  No mesmo pacote `tarefa`, crie a interface `TarefaRepository.java`.

```java
package br.com.curso.listadetarefas.api.tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
```

E é só isso! Agora já temos métodos como `save()`, `findById()`, `findAll()` e `deleteById()` prontos para usar.

## 🧠 Módulo 3: A Camada de Lógica de Negócios

A camada de **Serviço** orquestra as operações e contém as regras de negócio da nossa aplicação.

1.  No pacote `tarefa`, crie a classe `TarefaService.java`.

```java
package br.com.curso.listadetarefas.api.tarefa;

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
}
```

## 🔌 Módulo 4: Expondo a API com o Controller

O **Controller** é a porta de entrada da nossa API. Ele recebe as requisições HTTP e as direciona para a camada de serviço.

1.  No pacote `tarefa`, crie a classe `TarefaController.java`.

```java
package br.com.curso.listadetarefas.api.tarefa;

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
}
```

### 4.1 - Testando o Primeiro Endpoint

1.  **Execute a aplicação**: Rode a classe `listadetarefasApiApplication.java`.
2.  **Acesse no navegador**: Abra a URL `http://localhost:8080/tarefas`.

Você deverá ver uma lista vazia `[]`, pois ainda não temos dados. Vamos adicionar alguns dados de exemplo! Crie o arquivo `src/main/resources/data.sql`:

```sql
INSERT INTO TB_TAREFAS (TITULO, DESCRICAO, CONCLUIDA) VALUES ('Configurar o Backend', 'Criar a entidade e o repositório da Tarefa.', true);
INSERT INTO TB_TAREFAS (TITULO, DESCRICAO, CONCLUIDA) VALUES ('Criar a API REST', 'Desenvolver o endpoint para listar as tarefas.', false);
```

Reinicie a aplicação e acesse a URL novamente. Agora você verá os dados em formato JSON!


---

O tutorial cobre de forma exemplar a configuração do projeto e a implementação da funcionalidade de **Leitura (Read)** do CRUD.

Para dar continuidade e atingir o objetivo de ter um CRUD completo, podemos agora implementar as operações de **Criar (Create), Atualizar (Update) e Deletar (Delete)**. Abaixo, apresento a continuação do seu projeto, seguindo o mesmo formato e didática.

-----

## Módulo 5: Implementando as Operações de Escrita (Create & Update)

Agora que já conseguimos listar nossas tarefas, vamos adicionar a capacidade de criar novas e modificar as existentes.

### 5.1 - Adicionando o Método de Criação no `TarefaService`

Vamos adicionar a lógica para salvar uma nova tarefa no banco de dados.

1.  Abra a classe `TarefaService.java`.
2.  Adicione o método `criarTarefa`.

<!-- end list -->

```java
// ... (dentro da classe TarefaService)

    // ... (método listarTodas existente)

    public Tarefa criarTarefa(Tarefa tarefa) {
        // Aqui poderíamos adicionar regras de negócio,
        // como validações, antes de salvar.
        return tarefaRepository.save(tarefa);
    }
```

### 5.2 - Criando o Endpoint de Criação no `TarefaController`

Agora, vamos expor o método do serviço através de um novo endpoint na API. Usaremos o método HTTP `POST`.

1.  Abra a classe `TarefaController.java`.
2.  Adicione as importações necessárias e o novo método.

<!-- end list -->

```java
package br.com.curso.listadetarefas.api.tarefa;

// Novas importações
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
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
}
```

**Para testar:** Use uma ferramenta como o Postman ou Insomnia para enviar uma requisição `POST` para `http://localhost:8080/tarefas` com o seguinte corpo (JSON):

```json
{
    "titulo": "Estudar Spring Boot",
    "descricao": "Implementar o restante do CRUD.",
    "concluida": false
}
```

### 5.3 - Adicionando os Métodos de Atualização

A atualização seguirá uma lógica parecida, mas precisamos identificar *qual* tarefa será atualizada.

1.  **No `TarefaService.java`**:

<!-- end list -->

```java
// ... (dentro da classe TarefaService)
import java.util.Optional; // Importe esta classe

// ... (outros métodos)

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
```

2.  **No `TarefaController.java`**:

<!-- end list -->

```java
// ... (dentro da classe TarefaController)

// Novas importações
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

// ...

    // NOVO MÉTODO
    @PutMapping("/{id}") // Mapeia requisições HTTP PUT para /tarefas/{id}
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        // @PathVariable extrai o 'id' da URL
        return tarefaService.atualizarTarefa(id, tarefa)
                .map(tarefaAtualizada -> ResponseEntity.ok(tarefaAtualizada))
                .orElse(ResponseEntity.notFound().build()); // Retorna 404 se não encontrar
    }
```

**Para testar:** Envie uma requisição `PUT` para `http://localhost:8080/tarefas/3` (assumindo que o ID 3 foi criado) com um corpo JSON contendo os dados atualizados.

## 🗑️ Módulo 6: Implementando a Operação de Deleção (Delete)

Finalmente, vamos permitir que uma tarefa seja removida.

### 6.1 - Adicionando o Método de Deleção no `TarefaService`

Este método verificará se a tarefa existe antes de deletá-la.

1.  **No `TarefaService.java`**:

<!-- end list -->

```java
// ... (dentro da classe TarefaService)

    public boolean deletarTarefa(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return true; // Deletado com sucesso
        }
        return false; // Tarefa não encontrada
    }
```

### 6.2 - Criando o Endpoint de Deleção no `TarefaController`

Este endpoint receberá o ID da tarefa a ser deletada pela URL.

1.  **No `TarefaController.java`**:

<!-- end list -->

```java
// ... (dentro da classe TarefaController)

// Nova importação
import org.springframework.web.bind.annotation.DeleteMapping;

// ...

    // NOVO MÉTODO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (tarefaService.deletarTarefa(id)) {
            return ResponseEntity.noContent().build(); // Retorna 204 No Content (sucesso, sem corpo)
        }
        return ResponseEntity.notFound().build(); // Retorna 404 Not Found
    }
```

**Para testar:** Envie uma requisição `DELETE` para `http://localhost:8080/tarefas/3`. Se a operação for bem-sucedida, você receberá o status `204 No Content`.

## ✅ Resumo Final

Com esses novos módulos, sua `TarefaController` e `TarefaService` estarão completas com todas as operações CRUD. Você construiu uma API RESTful robusta e funcional, pronta para ser consumida por qualquer aplicação front-end.

**Próximos Passos Sugeridos:**

1.  **Validações**: Adicionar validações nos dados de entrada (ex: o título não pode ser vazio).
2.  **Tratamento de Exceções**: Criar um handler global para tratar erros de forma mais elegante.
3.  **Paginação**: Implementar paginação no endpoint de listagem para lidar com grandes volumes de dados.
4.  **Banco de Dados Real**: Trocar o H2 por um banco de dados como PostgreSQL ou MySQL.
---

### 🚀 [ricardotecpro.github.io](https://ricardotecpro.github.io/)

