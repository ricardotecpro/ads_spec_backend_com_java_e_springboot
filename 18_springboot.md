### **Título do Curso: Desenvolvimento Full-Stack e Desktop com Java, Angular e JavaFX: Construindo um To-Do List**

**Objetivo Geral:** Ao final do curso, o aluno será capaz de projetar, desenvolver e integrar uma aplicação completa seguindo o padrão arquitetural MVC. Ele dominará a criação de um backend RESTful com Spring Boot, o consumo dessa API por um cliente web moderno com Angular e por um cliente desktop nativo com JavaFX.

**Pré-requisitos:**

  * Lógica de programação.
  * Conhecimentos básicos de Orientação a Objetos (Classes, Objetos, Herança, Polimorfismo).
  * Conhecimentos básicos de Java.
  * Noções de HTML, CSS e JavaScript são um diferencial, mas não estritamente necessárias.

**Diagrama da Arquitetura Final:**

```
+------------------+      +---------------------+      +-----------------+
|                  |      |                     |      |                 |
|  Frontend Web    |      |   Backend (API)     |      | Frontend Desktop|
|    (Angular)     |      |    (Spring Boot)    |      |     (JavaFX)    |
|                  |      |                     |      |                 |
+--------+---------+      +----------+----------+      +--------+--------+
         |                           |                           |
         +---------------------------+---------------------------+
                             |
                       Comunicação via
                         HTTP (JSON)
                             |
                  +----------+----------+
                  |                     |
                  |     Banco de Dados  |
                  |       (H2)    |
                  |                     |
                  +---------------------+
```

-----

### **Módulo 0: Fundamentos e Configuração do Ambiente**

**Objetivo:** Nivelar a turma nos conceitos chave e garantir que todos tenham o ambiente de desenvolvimento pronto.

  * **Aula 1: A Arquitetura da Nossa Aplicação**

      * **Conceitos:**
          * **CRUD:** O que significa Create, Read, Update, Delete? Usar analogias (agenda de contatos, posts em redes sociais).
          * **API REST:** O que é uma API? O conceito de "garçom" que busca e entrega dados. Verbos HTTP (`GET`, `POST`, `PUT`, `DELETE`) e seus significados no CRUD. Formato de dados **JSON**.
          * **Padrão MVC (Model-View-Controller):** A importância de separar responsabilidades.
              * **Model:** A representação dos dados (ex: uma "Tarefa").
              * **View:** A camada de apresentação (a tela que o usuário vê).
              * **Controller:** O cérebro que recebe as interações do usuário, aciona o Model e atualiza a View.
      * **Prática:** Desenhar o diagrama da arquitetura no quadro/slide.

  * **Aula 2: Preparando as Ferramentas**

      * **Conceitos:** Ecossistema de desenvolvimento Java e Web.
      * **Prática:** Guia de instalação passo a passo:
          * **JDK (Java Development Kit):** Versão 17 ou superior.
          * **IDE (Ambiente de Desenvolvimento Integrado):** IntelliJ IDEA Community ou VS Code com extensões Java.
          * **Maven ou Gradle:** Gerenciador de dependências do Java.
          * **Node.js e npm:** Para o ambiente Angular.
          * **Angular CLI:** `npm install -g @angular/cli`
          * **Postman/Insomnia:** Ferramenta para testar a API REST.
          * **Scene Builder:** Ferramenta visual para criar as telas em JavaFX.

-----

### **Módulo 1: Construindo o Coração da Aplicação - Backend com Spring Boot (8 horas)**

**Objetivo:** Criar a API REST completa que servirá como base para os clientes web e desktop.

  * **Aula 3: "Hello, World\!" com Spring Boot**

      * **Conceitos:** Inversão de Controle e Injeção de Dependências. Estrutura de um projeto Spring Boot.
      * **Prática:**
        1.  Usar o **Spring Initializr** (start.spring.io) para criar o projeto.
        2.  Dependências: `Spring Web`, `Spring Data JPA`, `H2 Database` (banco de dados em memória, para simplificar), `Lombok` (para reduzir código boilerplate).
        3.  Criar um `RestController` simples que retorna uma saudação.
        4.  Executar o projeto e acessar a rota no navegador.

  * **Aula 4: A Camada Model e Repository (M do MVC)**

      * **Conceitos:** Mapeamento Objeto-Relacional (ORM) com JPA. Entidades e Repositórios.
      * **Prática:**
        1.  Criar a classe `Tarefa.java`.
        2.  Anotá-la com `@Entity` para que o JPA a reconheça como uma tabela no banco.
        3.  Definir os atributos: `id` (`@Id`, `@GeneratedValue`), `descricao` (`String`), `concluida` (`boolean`).
        4.  Criar a interface `TarefaRepository.java` que estende `JpaRepository<Tarefa, Long>`.
        5.  Explicar que o Spring Data JPA criará magicamente os métodos CRUD para nós (find, save, delete, etc.). **Este é o nosso Model, a camada de acesso e representação dos dados.**

  * **Aula 5: A Camada Controller e Service (C do MVC)**

      * **Conceitos:** Separação entre a camada de API (Controller) e a camada de Regras de Negócio (Service).
      * **Prática:**
        1.  Criar a classe `TarefaService.java`. Injetar o `TarefaRepository` e criar métodos para `listarTodas()`, `criar()`, `atualizar()`, `deletar()`. Aqui pode ir a lógica de negócio (ex: não permitir descrição vazia).
        2.  Criar a classe `TarefaController.java` com a anotação `@RestController`.
        3.  Injetar o `TarefaService`.
        4.  Mapear os endpoints da API para os métodos do Service:
              * `@GetMapping("/tarefas")` -\> `listarTodas()`
              * `@PostMapping("/tarefas")` -\> `criar()`
              * `@PutMapping("/tarefas/{id}")` -\> `atualizar()`
              * `@DeleteMapping("/tarefas/{id}")` -\> `deletar()`
              * `@GetMapping("/tarefas/{id}")` -\> `buscarPorId()`
        5.  **Reforçar:** O `TarefaController` é o **Controller** do nosso backend. Ele orquestra as requisições.

  * **Aula 6: Testando e Validando a API**

      * **Conceitos:** A importância de testar a API de forma isolada.
      * **Prática:**
        1.  Usar o Postman/Insomnia para fazer requisições a todos os endpoints criados.
        2.  **CREATE:** Fazer um `POST` para `/tarefas` com um JSON no corpo: `{ "descricao": "Aprender Spring Boot" }`.
        3.  **READ:** Fazer um `GET` para `/tarefas` e ver a lista. Fazer um `GET` para `/tarefas/1`.
        4.  **UPDATE:** Fazer um `PUT` para `/tarefas/1` com o corpo: `{ "descricao": "Aprender muito Spring Boot", "concluida": true }`.
        5.  **DELETE:** Fazer um `DELETE` para `/tarefas/1`.
        6.  Resolver o problema de CORS adicionando a anotação `@CrossOrigin` no Controller para permitir que o frontend (em outra porta) acesse a API.

-----

### **Módulo 2: A Interface Web com Angular**

**Objetivo:** Construir uma interface web reativa que consome a API Spring Boot.

  * **Aula 7: Estrutura do Projeto Angular**

      * **Conceitos:** Single Page Application (SPA), Componentes, Services, Módulos.
      * **Prática:**
        1.  Criar o projeto com `ng new todo-list-web`.
        2.  Analisar a estrutura de pastas (`src/app`).
        3.  Gerar os componentes e serviços necessários via Angular CLI:
              * `ng generate component task-list`
              * `ng generate service services/task`
              * `ng generate interface models/task`

  * **Aula 8: Conectando Angular ao Backend**

      * **Conceitos:** `HttpClient` para requisições HTTP, `Observable` para programação assíncrona.
      * **Prática:**
        1.  Definir a interface `task.ts` para espelhar o modelo `Tarefa.java`.
        2.  No `task.service.ts`, injetar o `HttpClient`.
        3.  Criar métodos no serviço para cada operação CRUD, que chamarão a nossa API Spring Boot (ex: `getTasks(): Observable<Task[]>`, `addTask(task: Task): Observable<Task>`).
        4.  Importar o `HttpClientModule` no `app.module.ts`.

  * **Aula 9: Construindo a View e o Controller (Component)**

      * **Conceitos:** Data Binding (`[]`, `()`, `[()]`), Diretivas (`*ngFor`, `*ngIf`).
      * **Prática:**
        1.  No `task-list.component.ts` (nosso **Controller** do frontend):
              * Injetar o `TaskService`.
              * Criar métodos para carregar, adicionar, remover e atualizar tarefas, que chamarão os métodos do serviço.
              * Manter um array de tarefas como estado do componente.
        2.  No `task-list.component.html` (nossa **View**):
              * Criar um formulário com um campo de input para a nova tarefa. Usar `[(ngModel)]` para fazer o two-way data binding.
              * Criar um botão "Adicionar" que chama o método de adicionar do componente.
              * Usar a diretiva `*ngFor` para iterar sobre o array de tarefas e exibir cada uma em uma lista.
              * Em cada item da lista, adicionar botões "Deletar" e um checkbox para "Concluir", que chamarão os respectivos métodos no componente, passando o ID da tarefa.

-----

### **Módulo 3: A Interface Desktop com JavaFX**

**Objetivo:** Provar a flexibilidade da API REST, criando um segundo cliente, desta vez para desktop, com JavaFX.

  * **Aula 10: Configurando o Projeto JavaFX**

      * **Conceitos:** Plataforma JavaFX, FXML para separação de UI e lógica.
      * **Prática:**
        1.  Criar um novo projeto Maven/Gradle.
        2.  Adicionar as dependências do JavaFX.
        3.  Introduzir o Scene Builder para desenhar a interface.

  * **Aula 11: Desenhando a View com FXML e Scene Builder**

      * **Conceitos:** Componentes de UI do JavaFX (`TableView`, `TextField`, `Button`).
      * **Prática:**
        1.  Usar o Scene Builder para criar a interface `main-view.fxml`.
        2.  Arrastar e soltar um `TableView` para listar as tarefas, um `TextField` para a nova tarefa e botões para "Adicionar", "Atualizar" e "Deletar".
        3.  No painel do Scene Builder, associar o FXML a uma classe `Controller` (ex: `MainViewController.java`).
        4.  Atribuir `fx:id` aos componentes que precisarão ser manipulados no código (a tabela, o campo de texto).
        5.  Definir os métodos `onAction` para os botões (ex: `onAdicionarButtonClick`). **Este arquivo FXML é a nossa View.**

  * **Aula 12: O Controller JavaFX e a Comunicação com a API**

      * **Conceitos:** `HttpClient` do Java para consumir a API REST. Deserialização de JSON para Objetos Java com a biblioteca Jackson.
      * **Prática:**
        1.  Criar a classe `MainViewController.java` (nosso **Controller** do desktop).
        2.  Usar a anotação `@FXML` para injetar os componentes da View (o `TableView`, etc.).
        3.  Criar uma classe de serviço, `ApiConsumerService.java`, responsável por toda a comunicação com a API Spring Boot.
              * Este serviço usará o `java.net.http.HttpClient` para fazer as requisições GET, POST, PUT, DELETE.
              * Usará a biblioteca Jackson para converter o JSON da resposta em objetos `Tarefa.java` (reaproveitar a mesma classe do backend é uma boa prática aqui).
        4.  No `MainViewController`, injetar o `ApiConsumerService`.
        5.  Implementar os métodos `onAction` dos botões. Eles chamarão o serviço para interagir com a API e, em seguida, atualizarão a `TableView`.
        6.  **Ponto importante:** Atualizações da UI a partir de threads secundárias (como a de rede) devem usar `Platform.runLater()`.

-----

### **Módulo 4: Conclusão e Próximos Passos**

  * **Aula 13: Revisão Geral e Boas Práticas**

      * Revisar o fluxo completo: Interação na View (Angular/JavaFX) -\> Chamada ao Controller (Component/JavaFX Controller) -\> Chamada ao Service (Angular/API Consumer) -\> Requisição HTTP -\> Controller do Backend (Spring) -\> Service do Backend -\> Repository -\> Banco de Dados.
      * Discutir melhorias: tratamento de erros, validação de dados (`@Valid` no Spring), feedback visual para o usuário (loading, mensagens de sucesso/erro).

  * **Aula 14: Para Onde Ir Agora?**

      * **Conceitos:** Autenticação e Autorização com Spring Security e JWT.
      * **Prática:** Breve demonstração de como proteger a API.
      * **Tópicos Futuros:**
          * Deployment: Empacotar a aplicação em um JAR, usar Docker.
          * Bancos de dados mais robustos (PostgreSQL, MySQL).
          * Testes unitários e de integração.
          * CI/CD (Integração Contínua/Entrega Contínua).


### **Guia Prático: Construindo e Testando a API do To-Do List**

**Objetivo:** Criar, passo a passo, o backend completo da nossa aplicação, e aprender a testar cada funcionalidade de forma isolada usando uma ferramenta de cliente HTTP.

-----

### **Etapa 0: Configuração Inicial do Projeto**

Vamos usar o **Spring Initializr** para criar a estrutura base do nosso projeto de forma rápida e segura.

1.  Acesse o site: [https://start.spring.io](https://start.spring.io)

2.  Preencha os campos da seguinte forma:

      * **Project:** Maven
      * **Language:** Java
      * **Spring Boot:** A versão estável mais recente (ex: 3.x.x).
      * **Project Metadata:**
          * **Group:** `br.com.curso`
          * **Artifact:** `todolist-api`
          * **Name:** `todolist-api`
          * **Description:** API para gerenciamento de tarefas
          * **Package name:** `br.com.curso.todolist`
      * **Packaging:** Jar
      * **Java:** 17 (ou a versão que você instalou)

3.  No lado direito, em **Dependencies**, clique em "ADD DEPENDENCIES" e adicione as seguintes:

      * `Spring Web`: Essencial para criar aplicações web e APIs REST.
      * `Spring Data JPA`: Facilita a comunicação com o banco de dados.
      * `H2 Database`: Um banco de dados em memória, perfeito para desenvolvimento e testes.
      * `Lombok`: Ajuda a reduzir a quantidade de código repetitivo (como getters, setters e construtores).

4.  Clique no botão **GENERATE**. Um arquivo `.zip` será baixado.

5.  Descompacte o arquivo e abra a pasta gerada na sua IDE preferida (IntelliJ ou VS Code).

A estrutura de pastas inicial será parecida com esta:

```
todolist-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/curso/todolist/
│   │   │       └── TodolistApiApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

-----

### **Etapa 1: Criando o Model (A Entidade `Tarefa`)**

O Model representa os dados da nossa aplicação. Vamos criar a classe `Tarefa`.

1.  Dentro do pacote `br.com.curso.todolist`, crie um novo pacote chamado `tarefa`.
2.  Dentro de `br.com.curso.todolist.tarefa`, crie um novo arquivo Java chamado `Tarefa.java`.

**Código para `Tarefa.java`:**

```java
package br.com.curso.todolist.tarefa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @Entity: Marca esta classe como uma entidade JPA (uma tabela no banco de dados).
 * @Table(name = "tb_tarefas"): Especifica o nome da tabela no banco.
 * @Data (Lombok): Gera automaticamente getters, setters, toString, equals e hashCode.
 */
@Data
@Entity
@Table(name = "tb_tarefas")
public class Tarefa {

    /**
     * @Id: Marca este campo como a chave primária da tabela.
     * @GeneratedValue: Configura a estratégia de geração da chave primária.
     * IDENTITY significa que o próprio banco de dados irá gerar e gerenciar o valor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private boolean concluida;
}
```

-----

### **Etapa 2: Criando o Repository (A Camada de Acesso a Dados)**

O Repository é uma interface que nos dá os métodos para interagir com o banco de dados (salvar, buscar, deletar, etc.) sem precisarmos escrever SQL.

1.  No mesmo pacote `br.com.curso.todolist.tarefa`, crie uma nova **interface** Java chamada `TarefaRepository.java`.

**Código para `TarefaRepository.java`:**

```java
package br.com.curso.todolist.tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository é uma interface do Spring Data JPA que já vem com métodos CRUD prontos.
 * Precisamos apenas dizer qual a Entidade que ele irá gerenciar (Tarefa) e qual o tipo da chave primária (Long).
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}

```

É só isso\! O Spring Data JPA implementará essa interface em tempo de execução para nós.

-----

### **Etapa 3: Criando a Camada de Serviço (Regras de Negócio)**

É uma boa prática ter uma camada de Serviço para conter a lógica de negócio, mantendo o Controller "limpo".

1.  No pacote `br.com.curso.todolist.tarefa`, crie uma nova classe Java chamada `TarefaService.java`.

**Código para `TarefaService.java`:**

```java
package br.com.curso.todolist.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Service: Marca a classe como um componente de serviço do Spring,
 * onde colocamos a lógica de negócio.
 */
@Service
public class TarefaService {

    // @Autowired: O Spring irá injetar uma instância de TarefaRepository aqui.
    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criar(Tarefa tarefa) {
        // Poderíamos ter validações aqui antes de salvar
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        // Verifica se a tarefa existe antes de tentar atualizar
        return tarefaRepository.findById(id)
            .map(tarefaExistente -> {
                tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
                tarefaExistente.setConcluida(tarefaAtualizada.isConcluida());
                return tarefaRepository.save(tarefaExistente);
            }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o id: " + id));
    }

    public void deletar(Long id) {
        // Verifica se a tarefa existe antes de deletar para evitar erros
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com o id: " + id);
        }
        tarefaRepository.deleteById(id);
    }
}
```

-----

### **Etapa 4: Criando o Controller (A API REST)**

O Controller é a porta de entrada da nossa API. Ele recebe as requisições HTTP e as direciona para a camada de Serviço.

1.  No pacote `br.com.curso.todolist.tarefa`, crie uma nova classe Java chamada `TarefaController.java`.

**Código para `TarefaController.java`:**

```java
package br.com.curso.todolist.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController: Combina @Controller e @ResponseBody, simplificando a criação de APIs REST.
 * @RequestMapping: Define o caminho base para todos os endpoints neste controller.
 * @CrossOrigin: Permite que requisições de outras origens (como nosso frontend Angular) sejam aceitas.
 */
@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    // CREATE
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.criar(tarefa);
    }

    // READ - Listar Todas
    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTodas();
    }

    // READ - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id)
                .map(ResponseEntity::ok) // Se encontrar, retorna 200 OK com a tarefa
                .orElse(ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        try {
            Tarefa atualizada = tarefaService.atualizar(id, tarefa);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        try {
            tarefaService.deletar(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content, sucesso sem corpo
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
```

**Neste ponto, a nossa API está completa\!** Vamos executá-la.

1.  Encontre o arquivo `TodolistApiApplication.java`.
2.  Clique com o botão direito sobre ele e selecione "Run 'TodolistApiApplication'".
3.  O console da sua IDE mostrará o log de inicialização do Spring Boot. Se tudo deu certo, você verá uma mensagem como `Started TodolistApiApplication in X.XXX seconds`.

-----

### **Etapa 5: Testando a API com Postman ou Insomnia**

Agora vamos agir como se fôssemos o frontend, enviando requisições para a nossa API em execução.

#### **Teste 1: Criar uma Tarefa (CREATE)**

  * **Método HTTP:** `POST`
  * **URL:** `http://localhost:8080/api/tarefas`
  * **Body:** Vá para a aba "Body", selecione a opção `raw` e o formato `JSON`.
  * **Conteúdo do Body:**
    ```json
    {
        "descricao": "Aprender a testar APIs REST",
        "concluida": false
    }
    ```
  * **Ação:** Clique em "Send".
  * **Resultado Esperado:** Você deve receber um status `200 OK` e, no corpo da resposta, o JSON da tarefa que você acabou de criar, agora com um `id` (provavelmente `1`).

#### **Teste 2: Listar Todas as Tarefas (READ)**

  * **Método HTTP:** `GET`
  * **URL:** `http://localhost:8080/api/tarefas`
  * **Ação:** Clique em "Send".
  * **Resultado Esperado:** Status `200 OK` e um array JSON no corpo da resposta contendo a tarefa criada no passo anterior.

#### **Teste 3: Atualizar uma Tarefa (UPDATE)**

  * **Método HTTP:** `PUT`
  * **URL:** `http://localhost:8080/api/tarefas/1` (use o `id` da tarefa que você criou)
  * **Body:** Novamente, `raw` e `JSON`.
  * **Conteúdo do Body:**
    ```json
    {
        "descricao": "API testada e atualizada com sucesso!",
        "concluida": true
    }
    ```
  * **Ação:** Clique em "Send".
  * **Resultado Esperado:** Status `200 OK` e o JSON da tarefa com os dados atualizados.

#### **Teste 4: Deletar uma Tarefa (DELETE)**

  * **Método HTTP:** `DELETE`
  * **URL:** `http://localhost:8080/api/tarefas/1`
  * **Ação:** Clique em "Send".
  * **Resultado Esperado:** Status `204 No Content`. A resposta não terá corpo, o que é normal para esta operação.

#### **Verificação Final**

Repita o **Teste 2 (Listar Todas)**. O resultado esperado agora é um status `200 OK` com um array JSON vazio `[]`, confirmando que a exclusão funcionou.

**Parabéns\!** Seus alunos agora têm um backend robusto e funcional, e sabem como verificar cada parte dele. Eles estão prontos para construir os clientes web e desktop.