### **Visão Arquitetural: Por Que NoSQL? Superando os Limites do Relacional**

Por décadas, o modelo relacional (SQL) dominou o mundo dos bancos de dados. No entanto, ele apresenta dois desafios significativos para aplicações modernas:

1.  **Incompatibilidade de Impedância Objeto-Relacional**: Em programação orientada a objetos, trabalhamos com objetos complexos e interligados. Um banco de dados relacional nos força a "desmontar" esses objetos em múltiplas tabelas normalizadas. Para recuperar um único objeto de negócio, como uma "Confirmação de Pedido", muitas vezes precisamos executar consultas com múltiplos e complexos `JOIN`s, o que é ineficiente e aumenta a complexidade do código.
2.  **Escalabilidade**: Bancos de dados relacionais são tradicionalmente projetados para **escalar verticalmente** (comprar um servidor mais potente), o que é caro e tem limites. Aplicações web modernas, com milhões de usuários, exigem **escalabilidade horizontal** (distribuir a carga em um cluster de servidores mais simples), algo que o modelo relacional não suporta nativamente com eficiência.

**A Solução NoSQL: O Paradigma de Agregados**

Bancos de dados NoSQL, especialmente os **orientados a documentos** como o MongoDB, foram criados para resolver esses problemas. A ideia central é o conceito de **Agregado**: um conjunto de objetos relacionados que são tratados como uma única unidade.

Em vez de dividir uma "Confirmação de Pedido" em tabelas de `pedidos`, `clientes`, `itens`, etc., nós a armazenamos como um único **documento**. Este documento (geralmente em formato BSON/JSON) contém todos os dados relevantes, aninhados em uma estrutura que espelha o objeto em nosso código.

Essa abordagem resolve os dois problemas:

  * **Elimina a incompatibilidade de impedância**: O formato do dado no banco é quase idêntico ao do objeto na aplicação.
  * **Facilita a escalabilidade horizontal**: O agregado é uma unidade natural para distribuição e replicação em um cluster, permitindo que o banco de dados cresça de forma quase ilimitada.

### **Estrutura do Projeto: Camadas Lógicas com Spring Boot e MongoDB**

A arquitetura de nossa aplicação será a mesma estrutura de camadas robusta que usamos para projetos relacionais, provando a flexibilidade do Spring Framework.

```
com.workshopmongo
├── config/                  // Configuração e instanciação inicial do banco de dados
├── domain/                  // Entidades mapeadas para as coleções do MongoDB (User, Post)
├── dto/                     // Data Transfer Objects para controlar os dados da API
├── repository/              // Interfaces do Spring Data MongoDB (MongoRepository)
├── services/                // Camada de serviço com a lógica de negócio
│   └── exception/           // Exceções customizadas
└── resources/               // Controladores REST (endpoints da API)
    └── exception/           // Manipulador de exceções global
```

-----

### **Fase 1: Configuração do Ambiente e do Projeto**

1.  **Instalação do MongoDB**: Baixe e instale o MongoDB Community Server e, opcionalmente, o Mongo Compass (uma GUI para visualizar e gerenciar o banco). Inicie o servidor MongoDB com o comando `mongod` em um terminal.

2.  **Criação do Projeto Spring Boot**: Use o [Spring Initializr](https://start.spring.io/) com as dependências `Spring Web` e `Spring Data MongoDB`.

3.  **Configuração da Conexão**: No arquivo `src/main/resources/application.properties`, adicione a string de conexão.

    ```properties
    # Conecta ao MongoDB local no banco de dados 'workshop_mongo'.
    # Se o banco não existir, ele será criado na primeira operação.
    spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
    ```

### **Fase 2: Implementando o CRUD de Usuários com o Padrão DTO**

Vamos criar os endpoints para usuários, usando DTOs (Data Transfer Objects) para um design de API limpo e seguro.

1.  **Entidade `User.java`**: A anotação `@Document` do Spring Data MongoDB substitui a `@Entity` do JPA.

    ```java
    // package com.workshopmongo.domain;

    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.mapping.Document;

    @Document(collection="user") // Mapeia para a coleção 'user' no MongoDB
    public class User implements Serializable {
        @Id
        private String id; // No MongoDB, o ID é tipicamente uma String
        private String name;
        private String email;
        // Construtores, Getters, Setters, etc.
    }
    ```

2.  **Repositório `UserRepository.java`**: `MongoRepository` é o equivalente do `JpaRepository` para MongoDB.

    ```java
    // package com.workshopmongo.repository;

    import com.workshopmongo.domain.User;
    import org.springframework.data.mongodb.repository.MongoRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends MongoRepository<User, String> { }
    ```

3.  **`UserDTO.java`**: Um objeto para trafegar dados entre as camadas e a API.

    ```java
    // package com.workshopmongo.dto;

    public class UserDTO implements Serializable {
        private String id;
        private String name;
        private String email;

        public UserDTO(User obj) {
            this.id = obj.getId();
            this.name = obj.getName();
            this.email = obj.getEmail();
        }
        // Construtor padrão, Getters/Setters...
    }
    ```

4.  **`UserService.java` e `UserResource.java`**: A implementação das camadas de serviço e recurso segue o mesmo padrão do projeto com JPA, demonstrando a consistência do Spring. O serviço usa o repositório para buscar os dados, e o recurso chama o serviço, convertendo as entidades para DTOs antes de retornar a resposta HTTP.

### **Fase 3: Modelando Relacionamentos - O Dilema do Design NoSQL**

Aqui está a decisão de design mais crítica ao trabalhar com MongoDB: **aninhar (embed) ou referenciar?**

#### **Abordagem 1: Objetos Aninhados (Embedded)**

Vamos modelar um `Post` que contém os dados de seu autor e seus comentários.

  * **Design**: A classe `Post` terá um atributo do tipo `AuthorDTO` e uma `List<CommentDTO>`. `AuthorDTO` e `CommentDTO` são classes simples (POJOs), não entidades `@Document`.
  * **Vantagem**: **Performance de Leitura Máxima**. Ao buscar um post, todos os dados relacionados (autor, comentários) vêm em uma única operação de banco de dados. Ideal para dados que são quase sempre consumidos juntos.
  * **Implementação `Post.java`**:
    ```java
    @Document
    public class Post implements Serializable {
        @Id
        private String id;
        private Date date;
        private String title;
        private String body;
        private AuthorDTO author; // Objeto aninhado
        private List<CommentDTO> comments = new ArrayList<>(); // Lista de objetos aninhados
        //...
    }
    ```

#### **Abordagem 2: Referências (`@DBRef`)**

Agora, vamos modelar o relacionamento do `User` com seus `Post`s. Aninhar todos os posts dentro do documento do usuário seria inviável. Em vez disso, armazenamos referências.

  * **Design**: A classe `User` terá uma `List<Post>`, anotada com `@DBRef`. No banco, o MongoDB armazenará apenas os IDs dos posts, não os documentos completos.
  * **Vantagem**: **Evita Duplicação e Consistência de Dados**. Se um post for atualizado, a mudança é refletida em todos os lugares, pois há apenas uma cópia dele.
  * **Implementação `User.java`**:
    ```java
    @Document(collection="user")
    public class User implements Serializable {
        // ... outros campos ...
        
        // Armazena uma lista de referências aos documentos da coleção Post.
        // lazy = true é uma otimização para que os posts só sejam carregados quando explicitamente acessados.
        @DBRef(lazy = true)
        private List<Post> posts = new ArrayList<>();
        // ...
    }
    ```

**Endpoint para buscar os posts de um usuário:**
O Spring Data cuidará de resolver essas referências para nós quando acessarmos a lista.

```java
// Em UserResource.java
@GetMapping(value="/{id}/posts")
public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
    User obj = service.findById(id);
    return ResponseEntity.ok().body(obj.getPosts());
}
```

### **Fase 4: Consultas Avançadas no MongoDB**

O Spring Data MongoDB facilita a criação de consultas complexas.

1.  **Query Methods**: Crie consultas simplesmente declarando a assinatura do método no repositório. O Spring "entende" o nome do método e cria a query.

    ```java
    // Em PostRepository.java
    // Encontra posts cujo título contenha a string 'text', ignorando caixa alta/baixa.
    List<Post> findByTitleContainingIgnoreCase(String text);
    ```

2.  **`@Query`**: Para lógicas mais complexas, use a anotação `@Query` com a sintaxe de consulta do MongoDB (JSON-like).

    ```java
    // Em PostRepository.java
    // Busca por 'text' no título OU no corpo OU nos comentários, dentro de um intervalo de datas.
    // ?0, ?1, ?2 referem-se aos parâmetros do método: text, minDate, maxDate.
    // '$regex': 'i' => case-insensitive search
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
    ```

Este guia demonstra como o MongoDB, combinado com o Spring Boot, oferece uma plataforma poderosa e produtiva para construir APIs modernas, ao mesmo tempo que nos força a pensar cuidadosamente sobre como modelar nossos dados para obter o melhor equilíbrio entre performance e consistência.