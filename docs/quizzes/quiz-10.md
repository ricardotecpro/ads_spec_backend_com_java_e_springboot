# Quiz 10 - Controle de Acesso (RBAC) 🛡️

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. O que significa a sigla RBAC?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o padrão de mercado para gerenciar permissões baseadas em "perfis" ou "papéis" do usuário.">Real-Binary-Authentication-Code</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É o padrão de mercado para gerenciar permissões baseadas em "perfis" ou "papéis" do usuário.">Role-Based Access Control</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o padrão de mercado para gerenciar permissões baseadas em "perfis" ou "papéis" do usuário.">Route-Based Authorization Check</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o padrão de mercado para gerenciar permissões baseadas em "perfis" ou "papéis" do usuário.">Restricted-Backend-Access-Control</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. No RBAC, a quem atribuímos as permissões de acesso?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Atribuir a perfis facilita a manutenção, especialmente em sistemas com muitos usuários.">A cada usuário individualmente por seu CPF</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Atribuir a perfis facilita a manutenção, especialmente em sistemas com muitos usuários.">A um perfil (Role) que pode ser compartilhado por vários usuários</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Atribuir a perfis facilita a manutenção, especialmente em sistemas com muitos usuários.">Apenas ao dono da empresa</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Atribuir a perfis facilita a manutenção, especialmente em sistemas com muitos usuários.">Ao endereço IP do computador</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Qual o código HTTP para "Acesso Negado" (Usuário identificado, mas sem permissão)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O 403 indica que o servidor entendeu quem é você, mas proibiu a ação.">401 Unauthorized</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O 403 indica que o servidor entendeu quem é você, mas proibiu a ação.">404 Not Found</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O 403 indica que o servidor entendeu quem é você, mas proibiu a ação.">403 Forbidden</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O 403 indica que o servidor entendeu quem é você, mas proibiu a ação.">500 Internal Error</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Qual a ordem correta dos middlewares em uma rota protegida?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Primeiro desvendamos QUEM é o usuário (Token), para depois checar O QUE ele pode fazer.">Primeiro Autorização, depois Autenticação</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Primeiro desvendamos QUEM é o usuário (Token), para depois checar O QUE ele pode fazer.">Primeiro Autenticação, depois Autorização</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Primeiro desvendamos QUEM é o usuário (Token), para depois checar O QUE ele pode fazer.">Ambos devem rodar ao mesmo tempo</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Primeiro desvendamos QUEM é o usuário (Token), para depois checar O QUE ele pode fazer.">Apenas um é necessário</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. O que um Middleware de Autorização faz se o usuário não tem o nível necessário?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O middleware age como uma trava que impede a execução do código do Controller.">Reinicia o servidor</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O middleware age como uma trava que impede a execução do código do Controller.">Interrompe a requisição e retorna um erro 403 ao cliente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O middleware age como uma trava que impede a execução do código do Controller.">Envia a requisição para outra rota aleatória</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O middleware age como uma trava que impede a execução do código do Controller.">Formata o banco de dados</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Por que o Erro 401 (Unauthorized) é retornado quando o token JWT é inválido?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. 401 significa "Quem é você? Não te conheço ou seu crachá é falso".">Porque o usuário é feio</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! 401 significa "Quem é você? Não te conheço ou seu crachá é falso".">Porque a identidade do usuário não pôde ser confirmada</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. 401 significa "Quem é você? Não te conheço ou seu crachá é falso".">Porque o servidor está desligado</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. 401 significa "Quem é você? Não te conheço ou seu crachá é falso".">Porque o sistema está em manutenção</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. Em um sistema de E-commerce, quem deve ter permissão para a rota `DELETE /produtos/:id`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ações destrutivas devem ser restritas a perfis de alta confiança.">Todos os clientes</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Ações destrutivas devem ser restritas a perfis de alta confiança.">Apenas usuários com a Role 'ADMIN' ou 'GERENTE'</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ações destrutivas devem ser restritas a perfis de alta confiança.">Qualquer pessoa sem login</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ações destrutivas devem ser restritas a perfis de alta confiança.">Apenas o programador que criou o site</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que é "Hierarquia de Roles"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Facilita o código, evitando ter que listar 'ADMIN' em todas as rotas simples.">Uma lista de nomes em ordem alfabética</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Facilita o código, evitando ter que listar 'ADMIN' em todas as rotas simples.">Quando perfis superiores (ex: Admin) herdam automaticamente as permissões de perfis inferiores</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Facilita o código, evitando ter que listar 'ADMIN' em todas as rotas simples.">O tamanho da letra no banco de dados</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Facilita o código, evitando ter que listar 'ADMIN' em todas as rotas simples.">A ordem de criação dos usuários</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. O que acontece se chamarmos a função `next()` dentro de um middleware?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O `next()` é o sinal verde para a requisição seguir seu fluxo.">O servidor para</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O `next()` é o sinal verde para a requisição seguir seu fluxo.">O processamento passa para o próximo middleware ou para o Controller</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O `next()` é o sinal verde para a requisição seguir seu fluxo.">O usuário é deslogado</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O `next()` é o sinal verde para a requisição seguir seu fluxo.">Uma nova aba abre no navegador</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Qual a principal vantagem de centralizar a autorização em middlewares?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Centralizar evita que você esqueça de colocar "if" em algum Controller, deixando brechas de segurança.">O app fica mais bonito</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Centralizar evita que você esqueça de colocar "if" em algum Controller, deixando brechas de segurança.">Segurança e Reuso: você protege rotas inteiras com uma única linha de código</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Centralizar evita que você esqueça de colocar "if" em algum Controller, deixando brechas de segurança.">O banco de dados fica mais rápido</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Centralizar evita que você esqueça de colocar "if" em algum Controller, deixando brechas de segurança.">Os usuários ganham descontos</div>
  <div class="quiz-feedback"></div>
</div>
