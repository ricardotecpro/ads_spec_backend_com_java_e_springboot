# Quiz 07 - Repositories e Banco de Dados 🗄️

1. Qual a função do PostgreSQL em uma arquitetura backend?
    - [ ] Criar a interface visual
    - [x] Armazenar dados de forma persistente e relacional
    - [ ] Enviar e-mails automaticamente
    - [ ] Compilar o código Javascript
    *Explicação: O PostgreSQL é um Sistema de Gerenciamento de Banco de Dados (SGBD) que garante que os dados não se percam.*

2. O que significa a sigla CRUD?
    - [ ] Create, Remove, Update, Delete
    - [x] Create, Read, Update, Delete
    - [ ] Clear, Read, Unit, Deploy
    - [ ] Code, Run, Update, Debug
    *Explicação: CRUD representa as quatro operações básicas de manipulação de dados em qualquer sistema.*

3. Qual o comando SQL usado para buscar dados em uma tabela?
    - [ ] INSERT
    - [ ] UPDATE
    - [x] SELECT
    - [ ] DELETE
    *Explicação: O SELECT é o comando fundamental para realizar consultas no banco de dados.*

4. Para que serve o padrão Repository?
    - [ ] Para salvar arquivos PDF no servidor
    - [x] Para isolar a lógica de acesso ao banco da lógica de negócio
    - [ ] Para criar rotas no Express
    - [ ] Para acelerar o download do app
    *Explicação: O Repository centraliza as chamadas ao banco, facilitando a troca de tecnologia sem afetar o resto do sistema.*

5. O que é uma Primary Key (Chave Primária)?
    - [ ] A senha master do servidor
    - [x] Um identificador único para cada registro (linha) em uma tabela
    - [ ] O nome da tabela principal
    - [ ] O primeiro campo de um formulário HTML
    *Explicação: A PK garante que não existam dois registros idênticos e facilita a busca rápida.*

6. Quando usamos uma Foreign Key (Chave Estrangeira)?
    - [ ] Para traduzir o banco de dados
    - [x] Para criar um link (relacionamento) entre duas tabelas diferentes
    - [ ] Para encriptar os dados
    - [ ] Para mudar o nome das colunas
    *Explicação: A FK é o que permite conectar, por exemplo, um Pedido ao Usuário que o realizou.*

7. O que acontece se rodarmos um `DELETE FROM usuarios` sem a cláusula `WHERE`?
    - [ ] O banco pede confirmação
    - [x] Todos os registros da tabela "usuarios" serão apagados!
    - [ ] Apenas o primeiro registro é apagado
    - [ ] O comando dá erro de sintaxe
    *Explicação: Sem o WHERE, o comando afeta todas as linhas da tabela. Muito cuidado!*

8. O que são "Migrations"?
    - [ ] Pessoas que mudam de país
    - [x] Arquivos que versionam a estrutura do banco de dados (schema)
    - [ ] A troca de servidor de hospedagem
    - [ ] Um tipo de loop em Javascript
    *Explicação: Migrations garantem que todos os desenvolvedores tenham a mesma versão da estrutura do banco.*

9. Qual o tipo de relacionamento quando um Autor pode escrever vários livros?
    - [ ] 1:1 (Um para um)
    - [x] 1:N (Um para muitos)
    - [ ] N:N (Muitos para muitos)
    - [ ] N:1 (Muitos para um)
    *Explicação: Um único recurso pai (Autor) está ligado a múltiplos recursos filhos (Livros).*

10. Por que o Service deve chamar o Repository em vez de rodar SQL direto?
    - [ ] Para o código ficar mais longo
    - [x] Para seguir o princípio de responsabilidade única e facilitar testes
    - [ ] Porque SQL é uma linguagem antiga
    - [ ] Porque o computador processa Services mais rápido
    *Explicação: Separar as camadas torna o sistema modular: o Service dita O QUE fazer, o Repository sabe COMO buscar.*