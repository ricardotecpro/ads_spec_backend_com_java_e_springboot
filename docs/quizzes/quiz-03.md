# Quiz 03 - Modelagem de APIs RESTful 📡

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. O que significa o termo "Stateless" no REST?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Stateless garante que o servidor possa escalar horizontalmente sem se preocupar em sincronizar sessões de usuários entre máquinas.">O servidor armazena o estado do cliente em variáveis globais</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Stateless garante que o servidor possa escalar horizontalmente sem se preocupar em sincronizar sessões de usuários entre máquinas.">O servidor não guarda informações sobre sessões anteriores; cada requisição é independente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Stateless garante que o servidor possa escalar horizontalmente sem se preocupar em sincronizar sessões de usuários entre máquinas.">O app não precisa de internet para funcionar</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Stateless garante que o servidor possa escalar horizontalmente sem se preocupar em sincronizar sessões de usuários entre máquinas.">O banco de dados nunca muda</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. Qual a regra de ouro para nomear URIs no REST?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. URIs devem representar recursos (coisas), e não ações. A ação é definida pelo Verbo HTTP.">Usar verbos de ação (ex: /getUsers)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. URIs devem representar recursos (coisas), e não ações. A ação é definida pelo Verbo HTTP.">Usar letras maiúsculas para destacar</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! URIs devem representar recursos (coisas), e não ações. A ação é definida pelo Verbo HTTP.">Usar substantivos no plural (ex: /usuarios)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. URIs devem representar recursos (coisas), e não ações. A ação é definida pelo Verbo HTTP.">Colocar a senha do usuário na URL</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Qual verbo HTTP deve ser usado para criar um novo recurso?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O POST é o método padrão para submeter dados para a criação de novos recursos no servidor.">GET</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O POST é o método padrão para submeter dados para a criação de novos recursos no servidor.">POST</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O POST é o método padrão para submeter dados para a criação de novos recursos no servidor.">PUT</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O POST é o método padrão para submeter dados para a criação de novos recursos no servidor.">DELETE</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Qual a diferença fundamental entre PUT e PATCH?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Use PUT para "trocar" o objeto todo e PATCH para mudar apenas um campo (ex: mudar apenas o preço de um produto).">PUT é mais rápido que PATCH</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Use PUT para "trocar" o objeto todo e PATCH para mudar apenas um campo (ex: mudar apenas o preço de um produto).">PATCH remove o recurso e PUT cria um novo</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Use PUT para "trocar" o objeto todo e PATCH para mudar apenas um campo (ex: mudar apenas o preço de um produto).">PUT substitui o recurso inteiro, enquanto PATCH faz atualizações parciais</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Use PUT para "trocar" o objeto todo e PATCH para mudar apenas um campo (ex: mudar apenas o preço de um produto).">Não há diferença, ambos fazem a mesma coisa</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. Qual código de status indica que um recurso foi criado com sucesso?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O 201 é específico para sinalizar que o POST resultou na criação física de um novo elemento.">200 OK</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O 201 é específico para sinalizar que o POST resultou na criação física de um novo elemento.">201 Created</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O 201 é específico para sinalizar que o POST resultou na criação física de um novo elemento.">204 No Content</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O 201 é específico para sinalizar que o POST resultou na criação física de um novo elemento.">404 Not Found</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. O que significa ser um método "Idempotente"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. GET, PUT e DELETE são idempotentes. Se você deletar o mesmo ID 10 vezes, o resultado final (o recurso não existir) é o mesmo.">Que ele gasta muita energia</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! GET, PUT e DELETE são idempotentes. Se você deletar o mesmo ID 10 vezes, o resultado final (o recurso não existir) é o mesmo.">Que múltiplas requisições idênticas têm o mesmo efeito que uma só</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. GET, PUT e DELETE são idempotentes. Se você deletar o mesmo ID 10 vezes, o resultado final (o recurso não existir) é o mesmo.">Que ele só funciona com números inteiros</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. GET, PUT e DELETE são idempotentes. Se você deletar o mesmo ID 10 vezes, o resultado final (o recurso não existir) é o mesmo.">Que ele apaga o banco de dados</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. Por que o JSON é preferido em relação ao XML em APIs modernas?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O JSON tem uma sintaxe muito mais limpa e mapeia quase diretamente para objetos em linguagens modernas.">Porque ele é colorido</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O JSON tem uma sintaxe muito mais limpa e mapeia quase diretamente para objetos em linguagens modernas.">Porque é mais leve, menos verboso e mais fácil de ler/processar em JS</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O JSON tem uma sintaxe muito mais limpa e mapeia quase diretamente para objetos em linguagens modernas.">Porque o XML foi proibido pelo Google</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O JSON tem uma sintaxe muito mais limpa e mapeia quase diretamente para objetos em linguagens modernas.">Porque JSON aceita emojis e XML não</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que o status code 403 Forbidden indica?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Diferente do 401 (sem login), o 403 diz que você é conhecido, mas "não tem entrada permitida aqui".">Que a página não existe</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Diferente do 401 (sem login), o 403 diz que você é conhecido, mas "não tem entrada permitida aqui".">Que o usuário não está logado</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Diferente do 401 (sem login), o 403 diz que você é conhecido, mas "não tem entrada permitida aqui".">Que o usuário está logado, mas não tem permissão para aquele recurso</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Diferente do 401 (sem login), o 403 diz que você é conhecido, mas "não tem entrada permitida aqui".">Que o servidor explodiu</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Em REST, o que compõe uma Interface Uniforme?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o conjunto de regras que torna a API previsível e fácil de aprender por outros desenvolvedores.">Usar a mesma cor em todos os botões</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É o conjunto de regras que torna a API previsível e fácil de aprender por outros desenvolvedores.">Uso de URIs para recursos, métodos HTTP padrão e representações de dados (JSON/XML)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o conjunto de regras que torna a API previsível e fácil de aprender por outros desenvolvedores.">Ter apenas um arquivo de código para tudo</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o conjunto de regras que torna a API previsível e fácil de aprender por outros desenvolvedores.">Usar apenas um tipo de fonte de texto</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Qual a função do cabeçalho "Content-Type" em uma requisição?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Sem o Content-Type, o servidor pode não saber como interpretar o corpo (body) da mensagem recebida.">Dizer o nome do autor da API</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Sem o Content-Type, o servidor pode não saber como interpretar o corpo (body) da mensagem recebida.">Informar ao servidor qual o formato dos dados que estão sendo enviados (ex: application/json)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Sem o Content-Type, o servidor pode não saber como interpretar o corpo (body) da mensagem recebida.">Aumentar a segurança da senha</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Sem o Content-Type, o servidor pode não saber como interpretar o corpo (body) da mensagem recebida.">Definir a cor de fundo do site</div>
  <div class="quiz-feedback"></div>
</div>
