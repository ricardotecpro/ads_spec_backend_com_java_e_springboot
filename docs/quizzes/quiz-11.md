# Quiz 11 - Refresh Token e Segurança Avançada 🏗️

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. Por que não é recomendado que o Access Token dure muitos dias?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Tokens curtos minimizam o estrago em caso de vazamento de credenciais.">Porque ele ocupa muito espaço no servidor</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Tokens curtos minimizam o estrago em caso de vazamento de credenciais.">Por segurança: se for roubado, o hacker terá acesso por pouco tempo</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Tokens curtos minimizam o estrago em caso de vazamento de credenciais.">Porque o navegador apaga tokens longos automaticamente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Tokens curtos minimizam o estrago em caso de vazamento de credenciais.">Porque o Google não permite</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. Para que serve o Refresh Token?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele garante uma boa experiência de uso (UX) sem sacrificar a segurança.">Para mudar a senha do usuário</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Ele garante uma boa experiência de uso (UX) sem sacrificar a segurança.">Para pedir um novo Access Token sem que o usuário tenha que digitar a senha novamente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele garante uma boa experiência de uso (UX) sem sacrificar a segurança.">Para aumentar a velocidade da internet</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele garante uma boa experiência de uso (UX) sem sacrificar a segurança.">Para carregar imagens mais rápido</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. O que significa a sigla CORS?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o mecanismo que define quais sites externos podem acessar sua API.">Central-Order-Resource-System</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É o mecanismo que define quais sites externos podem acessar sua API.">Cross-Origin Resource Sharing</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o mecanismo que define quais sites externos podem acessar sua API.">Code-Origin-Restriction-Safe</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o mecanismo que define quais sites externos podem acessar sua API.">Chrome-Only-Response-System</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Quem aplica o bloqueio de CORS?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O navegador bloqueia a leitura da resposta se o servidor não enviar os headers de permissão corretos.">O Provedor de Internet</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O navegador bloqueia a leitura da resposta se o servidor não enviar os headers de permissão corretos.">O Microprocessador do celular</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O navegador bloqueia a leitura da resposta se o servidor não enviar os headers de permissão corretos.">O Navegador (Chrome, Firefox, Safari)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O navegador bloqueia a leitura da resposta se o servidor não enviar os headers de permissão corretos.">O Teclado do usuário</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. Qual a função da biblioteca Helmet?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Helmet ajuda a esconder detalhes do servidor e prevenir ataques como XSS.">Proteger o servidor contra quedas físicas</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Helmet ajuda a esconder detalhes do servidor e prevenir ataques como XSS.">Configurar automaticamente diversos headers de segurança no HTTP</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Helmet ajuda a esconder detalhes do servidor e prevenir ataques como XSS.">Aumentar o brilho da tela</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Helmet ajuda a esconder detalhes do servidor e prevenir ataques como XSS.">Traduzir o app para inglês</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. O que é "Rate Limiting"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É essencial para evitar ataques de força bruta (Brute Force) e ataques de negação de serviço (DoS).">O limite de velocidade do Wi-Fi</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É essencial para evitar ataques de força bruta (Brute Force) e ataques de negação de serviço (DoS).">Uma técnica para limitar o número de requisições que um usuário/IP pode fazer em um tempo</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É essencial para evitar ataques de força bruta (Brute Force) e ataques de negação de serviço (DoS).">Quando o app fica lento de propósito</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É essencial para evitar ataques de força bruta (Brute Force) e ataques de negação de serviço (DoS).">O limite de amigos que alguém pode ter</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. Por que devemos evitar `origin: '*'` no CORS em produção?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O ideal é listar apenas os domínios oficiais que você confia.">Porque o servidor fica pesado</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O ideal é listar apenas os domínios oficiais que você confia.">Porque qualquer site malicioso do mundo poderia tentar roubar dados da sua API</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O ideal é listar apenas os domínios oficiais que você confia.">Porque o Google penaliza sites assim</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O ideal é listar apenas os domínios oficiais que você confia.">Porque os usuários não gostam</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que é o ataque XSS (Cross-Site Scripting)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O invasor pode usar isso para roubar tokens ou cookies de outros usuários.">Quando o banco de dados é deletado</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O invasor pode usar isso para roubar tokens ou cookies de outros usuários.">Quando um invasor consegue injetar scripts maliciosos em páginas vistas por outros usuários</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O invasor pode usar isso para roubar tokens ou cookies de outros usuários.">Quando o cabo USB desconecta</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O invasor pode usar isso para roubar tokens ou cookies de outros usuários.">Quando a senha é muito curta</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Qual desses é o lugar mais seguro para guardar o Refresh Token no navegador?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Cookies HttpOnly não podem ser lidos via Javascript, o que protege contra ataques XSS.">localStorage</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Cookies HttpOnly não podem ser lidos via Javascript, o que protege contra ataques XSS.">sessionStorage</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Cookies HttpOnly não podem ser lidos via Javascript, o que protege contra ataques XSS.">Cookie com a flag HttpOnly</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Cookies HttpOnly não podem ser lidos via Javascript, o que protege contra ataques XSS.">No histórico de navegação</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. O que acontece em um "Refresh Token Rotation"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É uma camada extra de segurança para detectar se um Refresh Token foi roubado.">O token muda de cor</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É uma camada extra de segurança para detectar se um Refresh Token foi roubado.">Sempre que um novo Access Token é pedido, o Refresh Token antigo é invalidado e um novo é gerado</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É uma camada extra de segurança para detectar se um Refresh Token foi roubado.">O usuário é obrigado a trocar a senha</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É uma camada extra de segurança para detectar se um Refresh Token foi roubado.">O servidor reinicia</div>
  <div class="quiz-feedback"></div>
</div>
