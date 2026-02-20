# Quiz 07 - Repositories e Banco de Dados 🗄️

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. Qual a função do PostgreSQL em uma arquitetura backend?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O PostgreSQL é um Sistema de Gerenciamento de Banco de Dados (SGBD) que garante que os dados não se percam.">Criar a interface visual</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O PostgreSQL é um Sistema de Gerenciamento de Banco de Dados (SGBD) que garante que os dados não se percam.">Armazenar dados de forma persistente e relacional</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O PostgreSQL é um Sistema de Gerenciamento de Banco de Dados (SGBD) que garante que os dados não se percam.">Enviar e-mails automaticamente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O PostgreSQL é um Sistema de Gerenciamento de Banco de Dados (SGBD) que garante que os dados não se percam.">Compilar o código Javascript</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. O que significa a sigla CRUD?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. CRUD representa as quatro operações básicas de manipulação de dados em qualquer sistema.">Create, Remove, Update, Delete</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! CRUD representa as quatro operações básicas de manipulação de dados em qualquer sistema.">Create, Read, Update, Delete</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. CRUD representa as quatro operações básicas de manipulação de dados em qualquer sistema.">Clear, Read, Unit, Deploy</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. CRUD representa as quatro operações básicas de manipulação de dados em qualquer sistema.">Code, Run, Update, Debug</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Qual o comando SQL usado para buscar dados em uma tabela?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O SELECT é o comando fundamental para realizar consultas no banco de dados.">INSERT</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O SELECT é o comando fundamental para realizar consultas no banco de dados.">UPDATE</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O SELECT é o comando fundamental para realizar consultas no banco de dados.">SELECT</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O SELECT é o comando fundamental para realizar consultas no banco de dados.">DELETE</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Para que serve o padrão Repository?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Repository centraliza as chamadas ao banco, facilitando a troca de tecnologia sem afetar o resto do sistema.">Para salvar arquivos PDF no servidor</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Repository centraliza as chamadas ao banco, facilitando a troca de tecnologia sem afetar o resto do sistema.">Para isolar a lógica de acesso ao banco da lógica de negócio</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Repository centraliza as chamadas ao banco, facilitando a troca de tecnologia sem afetar o resto do sistema.">Para criar rotas no Express</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Repository centraliza as chamadas ao banco, facilitando a troca de tecnologia sem afetar o resto do sistema.">Para acelerar o download do app</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. O que é uma Primary Key (Chave Primária)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A PK garante que não existam dois registros idênticos e facilita a busca rápida.">A senha master do servidor</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! A PK garante que não existam dois registros idênticos e facilita a busca rápida.">Um identificador único para cada registro (linha) em uma tabela</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A PK garante que não existam dois registros idênticos e facilita a busca rápida.">O nome da tabela principal</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A PK garante que não existam dois registros idênticos e facilita a busca rápida.">O primeiro campo de um formulário HTML</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Quando usamos uma Foreign Key (Chave Estrangeira)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A FK é o que permite conectar, por exemplo, um Pedido ao Usuário que o realizou.">Para traduzir o banco de dados</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! A FK é o que permite conectar, por exemplo, um Pedido ao Usuário que o realizou.">Para criar um link (relacionamento) entre duas tabelas diferentes</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A FK é o que permite conectar, por exemplo, um Pedido ao Usuário que o realizou.">Para encriptar os dados</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A FK é o que permite conectar, por exemplo, um Pedido ao Usuário que o realizou.">Para mudar o nome das colunas</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. O que acontece se rodarmos um `DELETE FROM usuarios` sem a cláusula `WHERE`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Sem o WHERE, o comando afeta todas as linhas da tabela. Muito cuidado!">O banco pede confirmação</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Sem o WHERE, o comando afeta todas as linhas da tabela. Muito cuidado!">Todos os registros da tabela "usuarios" serão apagados!</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Sem o WHERE, o comando afeta todas as linhas da tabela. Muito cuidado!">Apenas o primeiro registro é apagado</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Sem o WHERE, o comando afeta todas as linhas da tabela. Muito cuidado!">O comando dá erro de sintaxe</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que são "Migrations"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Migrations garantem que todos os desenvolvedores tenham a mesma versão da estrutura do banco.">Pessoas que mudam de país</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Migrations garantem que todos os desenvolvedores tenham a mesma versão da estrutura do banco.">Arquivos que versionam a estrutura do banco de dados (schema)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Migrations garantem que todos os desenvolvedores tenham a mesma versão da estrutura do banco.">A troca de servidor de hospedagem</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Migrations garantem que todos os desenvolvedores tenham a mesma versão da estrutura do banco.">Um tipo de loop em Javascript</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Qual o tipo de relacionamento quando um Autor pode escrever vários livros?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um único recurso pai (Autor) está ligado a múltiplos recursos filhos (Livros).">1:1 (Um para um)</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Um único recurso pai (Autor) está ligado a múltiplos recursos filhos (Livros).">1:N (Um para muitos)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um único recurso pai (Autor) está ligado a múltiplos recursos filhos (Livros).">N:N (Muitos para muitos)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um único recurso pai (Autor) está ligado a múltiplos recursos filhos (Livros).">N:1 (Muitos para um)</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Por que o Service deve chamar o Repository em vez de rodar SQL direto?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Separar as camadas torna o sistema modular: o Service dita O QUE fazer, o Repository sabe COMO buscar.">Para o código ficar mais longo</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Separar as camadas torna o sistema modular: o Service dita O QUE fazer, o Repository sabe COMO buscar.">Para seguir o princípio de responsabilidade única e facilitar testes</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Separar as camadas torna o sistema modular: o Service dita O QUE fazer, o Repository sabe COMO buscar.">Porque SQL é uma linguagem antiga</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Separar as camadas torna o sistema modular: o Service dita O QUE fazer, o Repository sabe COMO buscar.">Porque o computador processa Services mais rápido</div>
  <div class="quiz-feedback"></div>
</div>
