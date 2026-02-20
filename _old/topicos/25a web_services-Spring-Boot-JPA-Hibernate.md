### **Visão Arquitetural: Construindo um Web Service com Camadas Lógicas**

O objetivo é desenvolver um web service RESTful robusto, seguindo as melhores práticas de design de software. Para isso, adotaremos uma **arquitetura em camadas**, que é fundamental para a organização, manutenibilidade e testabilidade do código.

1.  **Resource Layer (Camada de Recursos)**: É a porta de entrada da nossa API. Composta por Controladores REST (`REST Controllers`), esta camada é responsável por expor os endpoints HTTP (ex: `/users`, `/products/{id}`) e por traduzir as requisições HTTP em chamadas para a camada de serviço.
2.  **Service Layer (Camada de Serviço)**: Contém a lógica de negócio da aplicação. Ela orquestra as operações, aplica regras e validações. Os serviços são agnósticos em relação à tecnologia de apresentação (não sabem que estão sendo chamados por um controlador REST) e delegam as operações de persistência à camada de acesso a dados.
3.  **Data Access Layer (Camada de Acesso a Dados)**: Também conhecida como *Repository Layer*. É a única camada que se comunica com o banco de dados. Utilizando o **Spring Data JPA**, definimos interfaces que, por mágica do framework, nos fornecem implementações completas para operações CRUD (Create, Retrieve, Update, Delete), abstraindo toda a complexidade do JDBC e do Hibernate.

As **Entidades** são os objetos do nosso modelo de domínio, que transitam entre essas camadas.

### **Estrutura do Projeto: Organização para Escalabilidade**

A organização dos pacotes deve refletir a nossa arquitetura em camadas. Esta estrutura torna o projeto intuitivo e fácil de navegar.

```
com.yourproject
├── config/                  // Classes de configuração (ex: popular o banco de teste)
├── entities/                // Classes do modelo de domínio (User, Order, Product, etc.)
│   └── enums/               // Enums específicos do domínio (OrderStatus)
├── repositories/            // Interfaces do Spring Data JPA (UserRepository, etc.)
├── services/                // Classes da camada de serviço (UserService, etc.)
│   └── exceptions/          // Exceções customizadas da camada de serviço
└── resources/               // Controladores REST (UserResource, etc.)
    └── exceptions/          // Manipulador de exceções global para a camada de recursos
```

-----

### **Fase 1: Configuração do Projeto e Ambiente de Teste**

Vamos criar a base do projeto e configurar um ambiente de desenvolvimento rápido com o banco de dados em memória H2.

1.  **Criação do Projeto**: Utilize o [Spring Initializr](https://start.spring.io/) ou a funcionalidade integrada da sua IDE (`File -> New -> Spring Starter Project`).

      * **Project**: Maven
      * **Language**: Java (versão 11 ou superior)
      * **Packaging**: JAR
      * **Dependencies**: `Spring Web`, `Spring Data JPA`, `H2 Database`.

2.  **Configuração de Perfis (Profiles)**: O Spring permite criar perfis de configuração para diferentes ambientes. Vamos criar um perfil `test` para usar o H2.

    **`src/main/resources/application.properties`** (arquivo principal que ativa o perfil de teste)

    ```properties
    spring.profiles.active=test
    ```

    **`src/main/resources/application-test.properties`** (configurações específicas para o H2)

    ```properties
    # Configuração da conexão com o banco H2 em memória
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.username=sa
    spring.datasource.password=

    # Habilita o console web do H2 para debug (acessível em http://localhost:8080/h2-console)
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console

    # Configurações do JPA/Hibernate para mostrar e formatar o SQL gerado
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    ```

### **Fase 2: Implementando a Camada de Dados e o Modelo de Domínio**

Com o projeto configurado, vamos criar nossa primeira entidade e seu repositório.

1.  **Entidade `User.java`**: Esta é uma classe POJO (Plain Old Java Object) anotada com JPA para mapeamento objeto-relacional.

    ```java
    // package com.yourproject.entities;

    import javax.persistence.*;
    import java.io.Serializable;
    import java.util.Objects;

    @Entity
    @Table(name = "tb_user") // Define o nome da tabela no banco de dados
    public class User implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String phone;
        private String password;

        // Construtores, Getters, Setters, hashCode e equals
        // ...
    }
    ```

2.  **Repositório `UserRepository.java`**: Ao estender `JpaRepository`, o Spring Data JPA gera automaticamente todos os métodos CRUD básicos em tempo de execução.

    ```java
    // package com.yourproject.repositories;

    import com.yourproject.entities.User;
    import org.springframework.data.jpa.repository.JpaRepository;

    // JpaRepository<TipoDaEntidade, TipoDaChavePrimaria>
    public interface UserRepository extends JpaRepository<User, Long> {
        // Métodos CRUD como save(), findById(), findAll(), deleteById() já estão disponíveis.
    }
    ```

3.  **Povoando o Banco de Testes (Database Seeding)**: Vamos criar uma classe de configuração para inserir dados no banco H2 sempre que a aplicação iniciar no perfil `test`.

    ```java
    // package com.yourproject.config;

    import com.yourproject.entities.User;
    import com.yourproject.repositories.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Profile;
    import java.util.Arrays;

    @Configuration
    @Profile("test") // Indica que esta configuração só será ativa no perfil 'test'
    public class TestConfig implements CommandLineRunner {

        @Autowired // O Spring injeta a dependência automaticamente
        private UserRepository userRepository;

        @Override
        public void run(String... args) throws Exception {
            User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
            User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

            userRepository.saveAll(Arrays.asList(u1, u2));
        }
    }
    ```

### **Fase 3: Implementando as Camadas de Serviço e Recursos (CRUD)**

Agora, vamos expor as operações CRUD através de uma API REST.

1.  **`UserService.java`**: Contém a lógica de negócio. Ela depende do `UserRepository` para acessar os dados.

    ```java
    // package com.yourproject.services;

    import com.yourproject.entities.User;
    import com.yourproject.repositories.UserRepository;
    import com.yourproject.services.exceptions.ResourceNotFoundException;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import java.util.List;
    import java.util.Optional;

    @Service // Registra a classe como um componente de serviço do Spring
    public class UserService {

        @Autowired
        private UserRepository repository;

        public List<User> findAll() {
            return repository.findAll();
        }

        public User findById(Long id) {
            Optional<User> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        }
        
        public User insert(User obj) {
            return repository.save(obj);
        }
    }
    ```

2.  **`UserResource.java`**: O Controlador REST que expõe os endpoints HTTP.

    ```java
    // package com.yourproject.resources;

    import com.yourproject.entities.User;
    import com.yourproject.services.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
    import java.net.URI;
    import java.util.List;

    @RestController
    @RequestMapping(value = "/users")
    public class UserResource {

        @Autowired
        private UserService service;

        @GetMapping
        public ResponseEntity<List<User>> findAll() {
            List<User> list = service.findAll();
            return ResponseEntity.ok().body(list);
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<User> findById(@PathVariable Long id) {
            User obj = service.findById(id);
            return ResponseEntity.ok().body(obj);
        }
        
        @PostMapping
        public ResponseEntity<User> insert(@RequestBody User obj) {
            obj = service.insert(obj);
            // Retorna o status HTTP 201 Created com a URL do novo recurso no header
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).body(obj);
        }
    }
    ```

### **Fase 4: Tratamento de Exceções Centralizado**

Para evitar blocos `try-catch` em cada método do controlador e padronizar as respostas de erro, criamos um manipulador de exceções global.

1.  **Exceção Customizada**: `ResourceNotFoundException.java`

2.  **`ResourceExceptionHandler.java`**: Intercepta exceções lançadas pelos controladores e retorna uma resposta HTTP padronizada.

    ```java
    // package com.yourproject.resources.exceptions;

    import com.yourproject.services.exceptions.ResourceNotFoundException;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.ControllerAdvice;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import javax.servlet.http.HttpServletRequest;
    import java.time.Instant;

    @ControllerAdvice // Intercepta exceções para serem tratadas globalmente
    public class ResourceExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class) // Trata exceções do tipo especificado
        public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
            String error = "Resource not found";
            HttpStatus status = HttpStatus.NOT_FOUND;
            StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }
    }
    ```

### **Fase 5: Implantação em Produção com PostgreSQL e Heroku**

Para a produção, trocamos o H2 por um banco de dados robusto como o PostgreSQL e fazemos o deploy na nuvem.

1.  **Adicionar Dependência do PostgreSQL** no `pom.xml`.
2.  **Criar Perfis `dev` e `prod`**:
      * **`application-dev.properties`**: Para conectar a um PostgreSQL local.
      * **`application-prod.properties`**: Para conectar ao banco do Heroku, usando variáveis de ambiente (`${...}`).
        ```properties
        # URL do banco de dados fornecida pelo Heroku
        spring.datasource.url=${DATABASE_URL}

        # Desativa a criação automática de tabelas em produção
        spring.jpa.hibernate.ddl-auto=none 
        ```
3.  **Configurar o Heroku**:
      * Crie uma conta e um novo aplicativo no Heroku.
      * Provisione o add-on "Heroku Postgres".
      * No painel de configurações do seu app Heroku (`Settings -> Config Vars`), o Heroku já cria a variável `DATABASE_URL`. Adicione outras variáveis que sua aplicação precise (como segredos JWT, etc.).
4.  **Criar `system.properties`**: Na raiz do projeto, crie este arquivo para especificar a versão do Java para o Heroku.
    ```properties
    java.runtime.version=11
    ```
5.  **Fazer o Deploy**: Após configurar o Git para o seu repositório Heroku, o deploy é feito com um simples comando:
    ```bash
    git push heroku master
    ```

Seguindo este guia, você terá construído um web service completo, desde a concepção e desenvolvimento local até a implantação em um ambiente de produção na nuvem, utilizando um conjunto de tecnologias moderno e poderoso do ecossistema Java.