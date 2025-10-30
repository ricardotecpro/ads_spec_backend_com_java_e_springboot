# ⚒️ Projetos

--- 

* **[Lista de Tarefa 01 - Backend API](./projetos/listadetarefas_01/listadetarefas.api.md)**
* --[Spring Initialzr](./projetos/loginusuarios_01/loginusuarios01.zip)
* **[Lista de Tarefa 01 - Frontend Web](./projetos/listadetarefas_01/listadetarefas.web.md)**
* **[Lista de Tarefa 01 - Scripts](./projetos/listadetarefas_01/listadetarefas.scripts.md)**

---

* **[Biblioteca de Jogos 01](./projetos/bibliotecajogos_01)**
* --[Spring Initialzr](./projetos/bibliotecajogos_01/bibliotecajogos.zip)

---

# Listas de Tarefas v1.1


### **Desenvolvimento Full-Stack com Java: Construindo um To-Do List**

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
|    (Thymeleaf)   |)     |      |    (Spring Boot)    |      |     (JavaFX)    |
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
          * **Postman/Insomnia:** Ferramenta para testar a API REST.
          * **Scene Builder:** Ferramenta visual para criar as telas em JavaFX.

-----

### **Módulo 1: Construindo o Coração da Aplicação - Backend com Spring Boot**

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

### **Módulo 2: A Interface Web com Thymeleaf**

**Objetivo:** Construir uma interface web reativa que consome a API Spring Boot.

  * **Aula 7: Estrutura do Projeto Thymeleaf**

      * **Conceitos:** Single Page Application (SPA), Componentes, Services, Módulos.
      

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

---

### [ricardotecpro.github.io](https://ricardotecpro.github.io/)
