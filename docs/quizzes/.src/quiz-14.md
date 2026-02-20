# Quiz - Aula 14 ❓

1. **O padrão DAO serve para:**
   - (A) Criar interfaces gráficas.
   - (B) Isolar e gerenciar o acesso aos dados da aplicação.
   - (C) Aumentar a segurança do Windows.
   - (D) Formatar o código-fonte.
   *Resposta: (B)* - 'Data Access Object' isola o SQL do restante da lógica.

2. **No CRUD, o 'R' (Read) corresponde ao SQL:**
   - (A) INSERT.
   - (B) UPDATE.
   - (C) SELECT.
   - (D) DELETE.
   *Resposta: (C)* - Operação de leitura/consulta.

3. **No CRUD, o 'U' (Update) serve para:**
   - (A) Criar um usuário novo.
   - (B) Atualizar dados de um registro existente.
   - (C) Unir duas tabelas.
   - (D) Desinstalar o sistema.
   *Resposta: (B)* - Comando SQL UPDATE.

4. **A classe DAO deve retornar para o Controller:**
   - (A) Comandos SQL em branco.
   - (B) Objetos ou Listas de Objetos (do Model).
   - (C) A cor da tela.
   - (D) Nada.
   *Resposta: (B)* - O Controller lida com objetos de negócio, não com SQL.

5. **Se mudarmos o nome de uma coluna no banco, o que acontece?**
   - (A) Alteramos apenas a classe DAO.
   - (B) Temos que refazer a tela inteira.
   - (C) O Windows para de funcionar.
   - (D) Nada, o Java descobre sozinho.
   *Resposta: (A)* - Esta é a grande vantagem do isolamento do DAO.

6. **PreparedStatement ajuda no DAO a:**
   - (A) Organizar o código.
   - (B) Prevenir SQL Injection e facilitar a passagem de parâmetros.
   - (C) Deixar a fonte maior.
   - (D) Conectar ao Wi-Fi.
   *Resposta: (B)* - Uso obrigatório para segurança e organização.

7. **O método `listarTodos()` no DAO geralmente retorna:**
   - (A) Um único número.
   - (B) Uma List<Objeto> (ex: List<Produto>).
   - (C) Uma String gigante.
   - (D) Um arquivo PDF.
   *Resposta: (B)* - Permite que a View mostre todos os itens em uma tabela.

8. **A camada DAO fica localizada entre:**
   - (A) A View e o Controller.
   - (B) O Controller e o Banco de Dados.
   - (C) A View e o Usuário.
   - (D) O Teclado e a Memória.
   *Resposta: (B)* - É a camada mais próxima da persistência.

9. **Um DAO para a classe `Usuario` deveria se chamar:**
   - (A) UsuarioWindow.
   - (B) UsuarioDAO.
   - (C) LogicUsuario.
   - (D) SQLData.
   *Resposta: (B)* - Convenção de nomenclatura Clara.

10. **A operação 'Delete' do CRUD deve ser usada:**
    - (A) Livremente a qualquer momento.
    - (B) Com cuidado, geralmente pedindo confirmação ao usuário.
    - (C) Apenas pelo gerente.
    - (D) Apenas se o banco estiver cheio.
    *Resposta: (B)* - Operações destrutivas exigem validação de UX.
