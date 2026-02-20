# Quiz 09 - Segurança e Autenticação com JWT 🔐

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. Qual a diferença entre Autenticação e Autorização?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Primeiro você prova quem é (Login), depois o sistema checa se você tem acesso (Roles).">Autenticação é sobre permissões, Autorização é sobre identidade</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Primeiro você prova quem é (Login), depois o sistema checa se você tem acesso (Roles).">Autenticação checa quem você é, Autorização checa o que você pode fazer</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Primeiro você prova quem é (Login), depois o sistema checa se você tem acesso (Roles).">Autenticação é para o backend, Autorização é para o frontend</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Primeiro você prova quem é (Login), depois o sistema checa se você tem acesso (Roles).">É a mesma coisa, apenas nomes diferentes</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. O que significa a sigla JWT?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É um padrão de mercado para transmissão segura de informações como objetos JSON.">Java Web Tool</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É um padrão de mercado para transmissão segura de informações como objetos JSON.">JSON Web Token</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É um padrão de mercado para transmissão segura de informações como objetos JSON.">Javascript Web Transfer</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É um padrão de mercado para transmissão segura de informações como objetos JSON.">Just Web Ticket</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Quantas partes compõem um token JWT?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. As três partes são unidas por pontos para formar o token completo.">Uma parte única</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. As três partes são unidas por pontos para formar o token completo.">Duas partes (Dados e Assinatura)</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! As três partes são unidas por pontos para formar o token completo.">Três partes (Header, Payload e Signature)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. As três partes são unidas por pontos para formar o token completo.">Quatro partes (Header, Payload, Signature e Expire)</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. O que é o "Payload" do JWT?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É aqui que guardamos as "alegações" (claims) sobre o usuário logado.">O algoritmo de criptografia</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É aqui que guardamos as "alegações" (claims) sobre o usuário logado.">A senha do banco de dados</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É aqui que guardamos as "alegações" (claims) sobre o usuário logado.">O corpo do token, onde ficam os dados do usuário (ex: id, nome)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É aqui que guardamos as "alegações" (claims) sobre o usuário logado.">A chave secreta do servidor</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. Por que a "Assinatura" (Signature) é a parte mais importante para a segurança?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Se alguém mudar um único caractere no Payload, a assinatura deixará de ser válida.">Porque ela deixa o token colorido</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Se alguém mudar um único caractere no Payload, a assinatura deixará de ser válida.">Porque ela garante que o Payload não foi alterado por terceiros</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Se alguém mudar um único caractere no Payload, a assinatura deixará de ser válida.">Porque ela esconde o nome do usuário</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Se alguém mudar um único caractere no Payload, a assinatura deixará de ser válida.">Porque ela faz o token expirar mais rápido</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. O que significa dizer que o JWT é "Stateless" (Sem Estado)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Toda a informação necessária para validar o usuário está dentro do próprio token.">Que o servidor não tem banco de dados</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Toda a informação necessária para validar o usuário está dentro do próprio token.">Que o servidor não precisa guardar informações da sessão do usuário na memória</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Toda a informação necessária para validar o usuário está dentro do próprio token.">Que o token nunca expira</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Toda a informação necessária para validar o usuário está dentro do próprio token.">Que o usuário não precisa de internet</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. Onde o Payload do JWT pode ser lido?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. CUIDADO! Nunca guarde senhas ou dados sensíveis no Payload, pois qualquer um pode ler.">Apenas pelo servidor que tem a chave secreta</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! CUIDADO! Nunca guarde senhas ou dados sensíveis no Payload, pois qualquer um pode ler.">Por qualquer pessoa, pois ele é apenas codificado (Base64), não encriptado</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. CUIDADO! Nunca guarde senhas ou dados sensíveis no Payload, pois qualquer um pode ler.">Apenas por usuários com permissão de Admin</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. CUIDADO! Nunca guarde senhas ou dados sensíveis no Payload, pois qualquer um pode ler.">Em lugar nenhum, ele é invisível</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. Qual o objetivo do campo "expiresIn" (ou 'exp')?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Tokens não devem ser eternos; limitando a duração, reduzimos riscos de roubo de sessão.">Mudar o nome do usuário</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Tokens não devem ser eternos; limitando a duração, reduzimos riscos de roubo de sessão.">Definir um tempo de validade para o token, após o qual ele será rejeitado</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Tokens não devem ser eternos; limitando a duração, reduzimos riscos de roubo de sessão.">Apagar o banco de dados</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Tokens não devem ser eternos; limitando a duração, reduzimos riscos de roubo de sessão.">Aumentar a velocidade da API</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Onde o frontend geralmente envia o JWT para o servidor?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O padrão Bearer Token nos headers HTTP é a forma mais comum de enviar o JWT.">No corpo da mensagem (Body)</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O padrão Bearer Token nos headers HTTP é a forma mais comum de enviar o JWT.">No cabeçalho (Header) de autorização: `Authorization: Bearer <token>`</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O padrão Bearer Token nos headers HTTP é a forma mais comum de enviar o JWT.">No nome do arquivo</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O padrão Bearer Token nos headers HTTP é a forma mais comum de enviar o JWT.">Por e-mail</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. O que acontece se o servidor perder a "Chave Secreta"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Sem a chave, o servidor não consegue mais verificar se as assinaturas dos tokens são legítimas.">Os usuários ganham acesso livre</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Sem a chave, o servidor não consegue mais verificar se as assinaturas dos tokens são legítimas.">Todos os tokens emitidos anteriormente se tornam inválidos instantaneamente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Sem a chave, o servidor não consegue mais verificar se as assinaturas dos tokens são legítimas.">O banco de dados é deletado</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Sem a chave, o servidor não consegue mais verificar se as assinaturas dos tokens são legítimas.">Nada, a chave secreta não é importante</div>
  <div class="quiz-feedback"></div>
</div>
