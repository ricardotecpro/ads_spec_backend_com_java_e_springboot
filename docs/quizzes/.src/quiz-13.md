# Quiz - Aula 13 ❓

1. **O JDBC permite que o Java se conecte a:**
   - (A) Apenas bancos MySQL.
   - (B) Qualquer banco de dados que possua um driver compatível.
   - (C) Apenas arquivos de texto.
   - (D) Sites da internet.
   *Resposta: (B)* - É uma API universal de conexão.

2. **DriverManager serve para:**
   - (A) Gerenciar os arquivos do projeto.
   - (B) Obter uma conexão com o banco de dados via URL.
   - (C) Deletar o driver.
   - (D) Abrir o navegador.
   *Resposta: (B)* - Localiza o driver correto e abre o canal de comunicação.

3. **Uma URL de conexão JDBC geralmente começa com:**
   - (A) http://
   - (B) jdbc:
   - (C) ftp:
   - (D) database://
   *Resposta: (B)* - Indica ao Java que é uma conexão de banco de dados.

4. **O que é um erro do tipo `SQLException`?**
   - (A) Erro de memória RAM.
   - (B) Erro relacionado a operações de banco de dados e conexão.
   - (C) Erro de digitação no teclado.
   - (D) Erro de internet.
   *Resposta: (B)* - É a exceção base para problemas com JDBC/SQL.

5. **A boa prática de usar o `try-with-resources` garante que:**
   - (A) O banco nunca falhe.
   - (B) A conexão seja fechada automaticamente ao final do bloco.
   - (C) O código fique mais rápido.
   - (D) A senha seja criptografada.
   *Resposta: (B)* - Previne vazamentos de memória (memory leaks).

6. **Para adicionar o Driver JDBC ao projeto Java, geralmente adicionamos um arquivo:**
   - (A) .txt
   - (B) .jar
   - (C) .exe
   - (D) .png
   *Resposta: (B)* - Arquivos JAR contêm as bibliotecas necessárias.

7. **A conexão com o banco deve ser aberta:**
   - (A) Uma vez no início do programa e nunca fechada.
   - (B) Apenas quando for necessária e fechada logo após o uso.
   - (C) A cada 1 segundo.
   - (D) Apenas se o usuário pedir.
   *Resposta: (B)* - Economiza recursos do servidor/máquina local.

8. **O que acontece se o Driver JDBC não for encontrado?**
   - (A) O Java baixa sozinho.
   - (B) Lança uma `ClassNotFoundException`.
   - (C) O programa trava em silêncio.
   - (D) O banco de dados é deletado.
   *Resposta: (B)* - Indica que o "tradutor" não está disponível.

9. **Em uma rede local, para conectar ao banco do colega, na URL usamos:**
   - (A) localhost
   - (B) O endereço IP da máquina dele.
   - (C) 127.0.0.1
   - (D) O nome da rua dele.
   *Resposta: (B)* - Permite conexões remotas.

10. **Connection conn = ...; O objeto `conn` representa:**
    - (A) O banco de dados inteiro.
    - (B) O canal de comunicação ativo entre o programa e o banco.
    - (C) Uma tabela.
    - (D) O usuário logado no Windows.
    *Resposta: (B)* - É a "ponte" por onde os comandos SQL passarão.
