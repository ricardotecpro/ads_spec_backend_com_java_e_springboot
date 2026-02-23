# Quiz 09 - Segurança e Autenticação com JWT 🔐

1. Qual a diferença entre Autenticação e Autorização?
    - [ ] Autenticação é sobre permissões, Autorização é sobre identidade
    - [x] Autenticação checa quem você é, Autorização checa o que você pode fazer
    - [ ] Autenticação é para o backend, Autorização é para o frontend
    - [ ] É a mesma coisa, apenas nomes diferentes
    *Explicação: Primeiro você prova quem é (Login), depois o sistema checa se você tem acesso (Roles).*

2. O que significa a sigla JWT?
    - [ ] Java Web Tool
    - [x] JSON Web Token
    - [ ] Javascript Web Transfer
    - [ ] Just Web Ticket
    *Explicação: É um padrão de mercado para transmissão segura de informações como objetos JSON.*

3. Quantas partes compõem um token JWT?
    - [ ] Uma parte única
    - [ ] Duas partes (Dados e Assinatura)
    - [x] Três partes (Header, Payload e Signature)
    - [ ] Quatro partes (Header, Payload, Signature e Expire)
    *Explicação: As três partes são unidas por pontos para formar o token completo.*

4. O que é o "Payload" do JWT?
    - [ ] O algoritmo de criptografia
    - [ ] A senha do banco de dados
    - [x] O corpo do token, onde ficam os dados do usuário (ex: id, nome)
    - [ ] A chave secreta do servidor
    *Explicação: É aqui que guardamos as "alegações" (claims) sobre o usuário logado.*

5. Por que a "Assinatura" (Signature) é a parte mais importante para a segurança?
    - [ ] Porque ela deixa o token colorido
    - [x] Porque ela garante que o Payload não foi alterado por terceiros
    - [ ] Porque ela esconde o nome do usuário
    - [ ] Porque ela faz o token expirar mais rápido
    *Explicação: Se alguém mudar um único caractere no Payload, a assinatura deixará de ser válida.*

6. O que significa dizer que o JWT é "Stateless" (Sem Estado)?
    - [ ] Que o servidor não tem banco de dados
    - [x] Que o servidor não precisa guardar informações da sessão do usuário na memória
    - [ ] Que o token nunca expira
    - [ ] Que o usuário não precisa de internet
    *Explicação: Toda a informação necessária para validar o usuário está dentro do próprio token.*

7. Onde o Payload do JWT pode ser lido?
    - [ ] Apenas pelo servidor que tem a chave secreta
    - [x] Por qualquer pessoa, pois ele é apenas codificado (Base64), não encriptado
    - [ ] Apenas por usuários com permissão de Admin
    - [ ] Em lugar nenhum, ele é invisível
    *Explicação: CUIDADO! Nunca guarde senhas ou dados sensíveis no Payload, pois qualquer um pode ler.*

8. Qual o objetivo do campo "expiresIn" (ou 'exp')?
    - [ ] Mudar o nome do usuário
    - [x] Definir um tempo de validade para o token, após o qual ele será rejeitado
    - [ ] Apagar o banco de dados
    - [ ] Aumentar a velocidade da API
    *Explicação: Tokens não devem ser eternos; limitando a duração, reduzimos riscos de roubo de sessão.*

9. Onde o frontend geralmente envia o JWT para o servidor?
    - [ ] No corpo da mensagem (Body)
    - [x] No cabeçalho (Header) de autorização: `Authorization: Bearer <token>`
    - [ ] No nome do arquivo
    - [ ] Por e-mail
    *Explicação: O padrão Bearer Token nos headers HTTP é a forma mais comum de enviar o JWT.*

10. O que acontece se o servidor perder a "Chave Secreta"?
    - [ ] Os usuários ganham acesso livre
    - [x] Todos os tokens emitidos anteriormente se tornam inválidos instantaneamente
    - [ ] O banco de dados é deletado
    - [ ] Nada, a chave secreta não é importante
    *Explicação: Sem a chave, o servidor não consegue mais verificar se as assinaturas dos tokens são legítimas.*