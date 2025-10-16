# 🚀 Projeto Lista de Tarefas" (To-Do List)

v2.1 - Guia Detalhado da Interface Web Dinâmica

Este é um guia completo para construir a interface web para a nossa API de Lista de Tarefas. Vamos cobrir cada operação do CRUD (Create, Read, Update, Delete), com o código completo e um guia de teste para cada funcionalidade.

## 📦 Módulo 7 (Revisado): Configuração e Leitura (Read)

**Objetivo:** Configurar o projeto para servir páginas web e exibir a lista de tarefas inicial.

### Etapa 7.1: Adicionar a Dependência do Thymeleaf

Primeiro, precisamos habilitar o Thymeleaf em nosso projeto.

1.  **Ação:** Abra o arquivo `pom.xml`.

2.  **Código:** Adicione o seguinte bloco de dependência dentro da tag `<dependencies>`:

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    ```

3.  **Verificação:** Sua IDE deve sincronizar o projeto, baixando a nova dependência. Não há uma saída visual, mas a ausência de erros é um bom sinal.

### Etapa 7.2: Criar o Controller da Web

Este controller será responsável por receber requisições do navegador e retornar páginas HTML.

1.  **Ação:** Crie um novo arquivo Java `TarefaWebController.java` no pacote `br.com.curso.listadetarefas.api.tarefa`.

2.  **Código:** Adicione o seguinte conteúdo completo ao arquivo:

    ```java
    package br.com.curso.listadetarefas.api.tarefa;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    import java.util.Comparator;
    import java.util.stream.Collectors;

    @Controller
    @RequestMapping("/") // Responderá na raiz da aplicação: http://localhost:8080/
    public class TarefaWebController {

        private final TarefaService tarefaService;

        public TarefaWebController(TarefaService tarefaService) {
            this.tarefaService = tarefaService;
        }

        @GetMapping
        public String index(Model model) {
            // Buscamos todas as tarefas e as ordenamos por ID para consistência
            var tarefasOrdenadas = tarefaService.listarTodas()
                    .stream()
                    .sorted(Comparator.comparing(Tarefa::getId))
                    .collect(Collectors.toList());

            // Adicionamos a lista de tarefas ao modelo que será enviado para o Thymeleaf
            model.addAttribute("tarefas", tarefasOrdenadas);
            
            // Retorna o nome do arquivo HTML (sem a extensão .html)
            return "index";
        }
    }
    ```

### Etapa 7.3: Criar a Página HTML com Thymeleaf

Esta é a nossa view, a estrutura visual da aplicação.

1.  **Ação:** Na pasta `src/main/resources/`, crie um novo diretório chamado `templates`.

2.  **Ação:** Dentro de `templates`, crie um novo arquivo chamado `index.html`.

3.  **Código:** Adicione o seguinte conteúdo completo ao arquivo:

    ```html
    <!DOCTYPE html>
    <html lang="pt-br" xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8">
        <title>Lista de Tarefas Dinâmica</title>
        <script src="https://unpkg.com/htmx.org@1.9.10" integrity="sha384-D1Kt99CQMDuVetoL1lrYwg5t+9QdHe7NLX/SoJYkXDFfX37iInKRy5xLSi8nO7UC" crossorigin="anonymous"></script>
        
        <style>
            body { font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif; max-width: 800px; margin: auto; padding: 2rem; background-color: #f9f9f9; color: #333; }
            h1, h2 { color: #0056b3; }
            table { width: 100%; border-collapse: collapse; margin-top: 1rem; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
            thead { background-color: #0056b3; color: white; }
            th, td { border: 1px solid #ddd; padding: 12px; text-align: left; vertical-align: middle; }
            tr:nth-child(even) { background-color: #f2f9ff; }
            tr:hover { background-color: #e6f2ff; }
            .concluida-texto { text-decoration: line-through; color: #888; }
            button { cursor: pointer; border: none; padding: 8px 12px; border-radius: 4px; color: white; }
            .btn-delete { background-color: #dc3545; }
            .btn-delete:hover { background-color: #c82333; }
            form { margin-top: 2rem; display: flex; gap: 10px; }
            input[type="text"] { flex-grow: 1; padding: 10px; border: 1px solid #ccc; border-radius: 4px; }
            button[type="submit"] { background-color: #007bff; padding: 10px 15px; }
            button[type="submit"]:hover { background-color: #0069d9; }
        </style>
    </head>
    <body>

        <h1>Minha Lista de Tarefas</h1>

        <table>
            <thead>
                <tr>
                    <th style="width: 10%;">Status</th>
                    <th>Título</th>
                    <th style="width: 15%;">Ações</th>
                </tr>
            </thead>
            <tbody id="tabela-tarefas">
                <tr th:each="tarefa : ${tarefas}">
                   <td th:text="${tarefa.isConcluida() ? '✅' : '⬜️'}">Status</td>
                   <td th:text="${tarefa.titulo}">Título da Tarefa</td>
                   <td><button class="btn-delete">Deletar</button></td>
                </tr>
            </tbody>
        </table>

        <h2>Nova Tarefa</h2>
        <form>
            <input type="text" name="titulo" placeholder="O que precisa ser feito?" required>
            <button type="submit">Adicionar</button>
        </form>

    </body>
    </html>
    ```

### ✅ Teste da Funcionalidade de Leitura (Read)

1.  **Reinicie a aplicação Spring Boot:** Execute a classe `ListadetarefasApiApplication.java` novamente.
2.  **Acesse no navegador:** Abra a URL `http://localhost:8080`.
3.  **Resultado Esperado:** Você deve ver uma página com o título "Minha Lista de Tarefas". A tabela deve exibir as tarefas que você inseriu no arquivo `data.sql` ("Configurar o Backend" e "Criar a API REST"). Os botões ainda não funcionam.

-----

## 🧠 Módulo 8: Implementando a Criação (Create)

**Objetivo:** Permitir que o usuário adicione uma nova tarefa através do formulário, e a tarefa apareça na lista instantaneamente.

### Etapa 8.1: Criar o "Fragmento" Thymeleaf

HTMX funciona trocando pedaços de HTML. Precisamos de um bloco de HTML que represente **uma única linha da tabela**. Isso é um "fragmento".

1.  **Ação:** Em `index.html`, crie um arquivo separado ou adicione o fragmento no mesmo arquivo. Para simplificar, vamos criar um novo arquivo `fragments.html` dentro da pasta `templates`.

2.  **Código (`templates/fragments.html`):**

    ```html
    <!DOCTYPE html>
    <html lang="pt-br" xmlns:th="http://www.thymeleaf.org">
    <body>

        <tr th:fragment="linha-tarefa" th:id="'tarefa-' + ${tarefa.id}">
            <td th:classappend="${tarefa.concluida} ? 'concluida-texto'">
                <input type="checkbox" th:checked="${tarefa.concluida}">
            </td>
            <td th:text="${tarefa.titulo}" th:classappend="${tarefa.concluida} ? 'concluida-texto'">
                Título da Tarefa
            </td>
            <td>
                <button class="btn-delete">Deletar</button>
            </td>
        </tr>

    </body>
    </html>
    ```

3.  **Ação:** Altere o `index.html` para usar este fragmento.

4.  **Código (`templates/index.html` - Apenas o `<tbody>` modificado):**

    ```html
    <tbody id="tabela-tarefas">
        <tr th:replace="~{fragments :: linha-tarefa(tarefa=${tarefa})}" th:each="tarefa : ${tarefas}"></tr>
    </tbody>
    ```

### Etapa 8.2: Adicionar o Endpoint de Criação no Controller

1.  **Ação:** Adicione um novo método ao `TarefaWebController.java`.

2.  **Código (adicionar dentro da classe `TarefaWebController`):**

    ```java
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    // ...

    @PostMapping("/tarefas")
    public String criarTarefa(@RequestParam String titulo, Model model) {
        // Cria e salva a nova tarefa
        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setTitulo(titulo);
        novaTarefa.setDescricao(""); // Pode ser deixado em branco ou vir do form
        novaTarefa.setConcluida(false);
        Tarefa tarefaSalva = tarefaService.criarTarefa(novaTarefa);

        // Prepara o modelo APENAS com a nova tarefa
        model.addAttribute("tarefa", tarefaSalva);

        // Retorna o caminho para o FRAGMENTO, não a página inteira
        return "fragments :: linha-tarefa";
    }
    ```

### Etapa 8.3: Habilitar o Formulário com HTMX

1.  **Ação:** Modifique a tag `<form>` no arquivo `index.html`.

2.  **Código (substituir o `<form>` antigo):**

    ```html
    <form hx-post="/tarefas"      
          hx-target="#tabela-tarefas" 
          hx-swap="beforeend"
          hx-on::after-request="this.reset()"> <input type="text" name="titulo" placeholder="O que precisa ser feito?" required>
        <button type="submit">Adicionar</button>
    </form>
    ```

      * **`hx-post="/tarefas"`**: Envia os dados do formulário via `POST` para o endpoint que acabamos de criar.
      * **`hx-target="#tabela-tarefas"`**: O resultado da requisição (o HTML da nova linha) será colocado dentro do elemento com `id="tabela-tarefas"`.
      * **`hx-swap="beforeend"`**: O HTML recebido será adicionado no final do conteúdo do alvo.
      * **`hx-on::after-request="this.reset()"`**: Um pequeno "script" que limpa o formulário após a requisição ser concluída.

### ✅ Teste da Funcionalidade de Criação (Create)

1.  **Reinicie a aplicação Spring Boot.**
2.  **Acesse `http://localhost:8080` no navegador.**
3.  **Ação:** No campo de texto "O que precisa ser feito?", digite **"Testar a criação de tarefas"**.
4.  **Ação:** Clique no botão **"Adicionar"**.
5.  **Resultado Esperado:**
      * A nova tarefa "Testar a criação de tarefas" deve aparecer instantaneamente no final da lista.
      * A página **não deve recarregar**.
      * O campo de texto deve ficar vazio, pronto para adicionar outra tarefa.

-----

## 🗑️ Módulo 9: Implementando a Deleção (Delete)

**Objetivo:** Permitir que o usuário remova uma tarefa da lista clicando em um botão.

### Etapa 9.1: Adicionar o Endpoint de Deleção no Controller

1.  **Ação:** Adicione um novo método ao `TarefaWebController.java`.

2.  **Código (adicionar dentro da classe `TarefaWebController`):**

    ```java
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.ResponseBody;

    // ...

    @DeleteMapping("/web/tarefas/{id}")
    @ResponseBody // Indica que não estamos retornando uma view, mas sim dados (ou nada) no corpo
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        // Retorna HTTP 200 OK. HTMX entende que uma resposta vazia e bem-sucedida
        // significa que o elemento alvo deve ser removido (se hx-swap for outerHTML).
        return ResponseEntity.ok().build(); 
    }
    ```

### Etapa 9.2: Habilitar o Botão de Deleção com HTMX

1.  **Ação:** Modifique o botão de deletar no arquivo `fragments.html`.

2.  **Código (`templates/fragments.html` - apenas o fragmento modificado):**

    ```html
    <tr th:fragment="linha-tarefa" th:id="'tarefa-' + ${tarefa.id}">
        <td th:classappend="${tarefa.concluida} ? 'concluida-texto'">
            <input type="checkbox" th:checked="${tarefa.concluida}" 
                   hx-post="@{/tarefas/{id}/toggle(id=${tarefa.id})}"
                   hx-target="'#tarefa-' + ${tarefa.id}"
                   hx-swap="outerHTML">
        </td>
        <td th:text="${tarefa.titulo}" th:classappend="${tarefa.concluida} ? 'concluida-texto'">
            Título da Tarefa
        </td>
        <td>
            <button class="btn-delete"
                    hx-delete="@{/tarefas/{id}(id=${tarefa.id})}"
                    hx-target="'#tarefa-' + ${tarefa.id}"
                    hx-swap="outerHTML"
                    hx-confirm="Tem certeza que deseja apagar esta tarefa?">
                Deletar
            </button>
        </td>
    </tr>
    ```

      * **`hx-delete`**: Envia uma requisição `DELETE` para `/tarefas/{id}`.
      * **`hx-target`**: O alvo da operação é a própria linha (`<tr>`) que tem o `id="tarefa-X"`.
      * **`hx-swap="outerHTML"`**: Substitui o elemento alvo inteiro (a linha `<tr>`) pela resposta. Como a resposta do nosso controller é vazia, a linha simplesmente desaparece.
      * **`hx-confirm`**: Mostra uma caixa de diálogo de confirmação nativa do navegador.

### ✅ Teste da Funcionalidade de Deleção (Delete)

1.  **Reinicie a aplicação Spring Boot.**
2.  **Acesse `http://localhost:8080` no navegador.**
3.  **Ação:** Encontre a tarefa "Criar a API REST" e clique no botão **"Deletar"** ao lado dela.
4.  **Ação:** Uma caixa de diálogo vai perguntar "Tem certeza...". Clique em **"OK"**.
5.  **Resultado Esperado:** A linha correspondente à tarefa "Criar a API REST" deve desaparecer da tabela instantaneamente, sem recarregar a página.

-----

## 🔄 Módulo 10: Implementando a Atualização (Update)

**Objetivo:** Permitir que o usuário marque ou desmarque uma tarefa como concluída, atualizando seu estado visual.

### Etapa 10.1: Adicionar o Endpoint de Atualização no Controller

1.  **Ação:** Adicione o método para alternar o status no `TarefaWebController.java`.

2.  **Código (adicionar dentro da classe `TarefaWebController`):**

    ```java
    // ... (as importações @PostMapping e @PathVariable já devem existir)

    @PostMapping("/tarefas/{id}/toggle")
    public String toggleTarefaConcluida(@PathVariable Long id, Model model) {
        // Busca a tarefa no banco
        tarefaService.findById(id).ifPresent(tarefa -> {
            // Inverte o estado de 'concluida'
            tarefa.setConcluida(!tarefa.isConcluida());
            // Salva a tarefa atualizada
            Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa).orElse(tarefa);
            // Adiciona ao modelo para enviar de volta ao fragmento
            model.addAttribute("tarefa", tarefaAtualizada);
        });

        // Retorna o fragmento da linha atualizado
        return "fragments :: linha-tarefa";
    }
    ```

    *Obs: Precisaremos adicionar o método `findById` ao `TarefaService` se ele não existir.*
    **No `TarefaService.java`:**

    ```java
    public Optional<Tarefa> findById(Long id) {
        return tarefaRepository.findById(id);
    }
    ```

### Etapa 10.2: Habilitar o Checkbox com HTMX

1.  **Ação:** A modificação no `input[type="checkbox"]` já foi feita na etapa 9.2, mas vamos analisá-la em detalhes.

2.  **Código (`templates/fragments.html` - o input dentro do fragmento):**

    ```html
    <input type="checkbox" th:checked="${tarefa.concluida}"
               hx-post="@{/tarefas/{id}/toggle(id=${tarefa.id})}"
               hx-target="'#tarefa-' + ${tarefa.id}"
               hx-swap="outerHTML">
    ```

      * **`hx-post`**: Quando o checkbox é clicado, ele envia uma requisição `POST` para `/tarefas/{id}/toggle`.
      * **`hx-target`**: O alvo, novamente, é a linha inteira da tabela (`<tr>`).
      * **`hx-swap="outerHTML"`**: A linha antiga será completamente substituída pela nova linha (com a classe de texto riscado e o checkbox marcado/desmarcado) que o controller retorna.

### ✅ Teste da Funcionalidade de Atualização (Update)

1.  **Reinicie a aplicação Spring Boot.**
2.  **Acesse `http://localhost:8080` no navegador.**
3.  **Ação:** Encontre a tarefa "Configurar o Backend", que deve estar marcada como concluída (texto riscado). Clique na caixa de seleção dela.
4.  **Resultado Esperado:** O risco no texto deve desaparecer e o checkbox deve ficar desmarcado, tudo sem recarregar a página.
5.  **Ação:** Clique novamente no mesmo checkbox.
6.  **Resultado Esperado:** A tarefa deve voltar ao estado de concluída (texto riscado e checkbox marcado).

---

### Etapa 10.3: 

2.  **Código (classe `TarefaController`):**

    ```java
    // ... (as importações @PostMapping e @PathVariable já devem existir)

    @PostMapping("/tarefas/{id}/toggle")
    public String toggleTarefaConcluida(@PathVariable Long id, Model model) {
        // Busca a tarefa no banco
        tarefaService.findById(id).ifPresent(tarefa -> {
            // Inverte o estado de 'concluida'
            tarefa.setConcluida(!tarefa.isConcluida());
            // Salva a tarefa atualizada
            Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa).orElse(tarefa);
            // Adiciona ao modelo para enviar de volta ao fragmento
            model.addAttribute("tarefa", tarefaAtualizada);
        });

        // Retorna o fragmento da linha atualizado
        return "fragments :: linha-tarefa";
    }
    ```
    

---
### Etapa 10.4: 

2.  **Código (adicionar dentro da classe `TarefaWebController`):**

    ```java
    // ... (as importações @PostMapping e @PathVariable já devem existir)

    @PostMapping("/tarefas/{id}/toggle")
    public String toggleTarefaConcluida(@PathVariable Long id, Model model) {
        // Busca a tarefa no banco
        tarefaService.findById(id).ifPresent(tarefa -> {
            // Inverte o estado de 'concluida'
            tarefa.setConcluida(!tarefa.isConcluida());
            // Salva a tarefa atualizada
            Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa).orElse(tarefa);
            // Adiciona ao modelo para enviar de volta ao fragmento
            model.addAttribute("tarefa", tarefaAtualizada);
        });

        // Retorna o fragmento da linha atualizado
        return "fragments :: linha-tarefa";
    }
    ```