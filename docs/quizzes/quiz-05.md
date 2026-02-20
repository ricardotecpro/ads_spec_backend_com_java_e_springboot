# Quiz 05 - Implementação de APIs ⚙️

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. Qual a principal responsabilidade da camada de Controller?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller age como um intermediário entre o mundo externo (HTTP) e a lógica interna do sistema.">Salvar dados no banco de dados</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Controller age como um intermediário entre o mundo externo (HTTP) e a lógica interna do sistema.">Gerenciar a requisição HTTP e retornar a resposta adequada</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller age como um intermediário entre o mundo externo (HTTP) e a lógica interna do sistema.">Fazer cálculos complexos de impostos</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller age como um intermediário entre o mundo externo (HTTP) e a lógica interna do sistema.">Criar a interface gráfica do usuário</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. O que é um "Handler" em um sistema de rotas?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Cada rota (Verbo + Path) é mapeada para um Handler que processa aquela ação específica.">Um tipo de vírus de computador</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Cada rota (Verbo + Path) é mapeada para um Handler que processa aquela ação específica.">A função específica que é executada quando uma rota é chamada</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Cada rota (Verbo + Path) é mapeada para um Handler que processa aquela ação específica.">O nome do servidor de hospedagem</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Cada rota (Verbo + Path) é mapeada para um Handler que processa aquela ação específica.">O arquivo onde guardamos as senhas</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Qual a melhor forma de capturar o ID de um usuário para uma busca individual (ex: /usuarios/10)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Path Params são ideais para identificar recursos de forma única e hierárquica na URI.">Query Param (?id=10)</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Path Params são ideais para identificar recursos de forma única e hierárquica na URI.">Path Param (/usuarios/:id)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Path Params são ideais para identificar recursos de forma única e hierárquica na URI.">Request Body ({ "id": 10 })</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Path Params são ideais para identificar recursos de forma única e hierárquica na URI.">Através de um cookie</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Quando devemos usar "Query Params"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Query Params são usados para modificar ou filtrar a representação dos dados retornados.">Para enviar a senha do usuário</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Query Params são usados para modificar ou filtrar a representação dos dados retornados.">Para filtros, ordenação e paginação (ex: ?cor=azul)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Query Params são usados para modificar ou filtrar a representação dos dados retornados.">Para atualizar o nome de um produto</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Query Params são usados para modificar ou filtrar a representação dos dados retornados.">Para deletar o banco de dados</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. Em qual objeto da requisição costuma vir o JSON enviado via POST?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Body é a parte da mensagem HTTP reservada para o transporte de dados complexos e volumosos.">req.params</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Body é a parte da mensagem HTTP reservada para o transporte de dados complexos e volumosos.">req.query</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Body é a parte da mensagem HTTP reservada para o transporte de dados complexos e volumosos.">req.body</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Body é a parte da mensagem HTTP reservada para o transporte de dados complexos e volumosos.">req.headers</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Qual analogia melhor define o papel do Controller?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller apenas coordena a entrada e a saída, delegando a "preparação" para outras camadas.">O cozinheiro que prepara o prato</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Controller apenas coordena a entrada e a saída, delegando a "preparação" para outras camadas.">O garçom que anota o pedido e entrega o prato</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller apenas coordena a entrada e a saída, delegando a "preparação" para outras camadas.">O dono do restaurante que cuida do banco de dados</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller apenas coordena a entrada e a saída, delegando a "preparação" para outras camadas.">O cliente que come a comida</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. Por que a Injeção de Dependência é útil nos Controllers?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Receber dependências prontas torna o Controller menos acoplado e mais fácil de manter.">Para o código ficar mais pesado e seguro</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Receber dependências prontas torna o Controller menos acoplado e mais fácil de manter.">Para facilitar a troca de comportamentos e a criação de testes automatizados</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Receber dependências prontas torna o Controller menos acoplado e mais fácil de manter.">Para economizar espaço no HD</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Receber dependências prontas torna o Controller menos acoplado e mais fácil de manter.">Porque o Google obriga</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que acontece se o Controller não retornar um Status Code?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É vital ser explícito sobre o que aconteceu (201 para sucesso, 400 para erro, etc).">O servidor explode</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É vital ser explícito sobre o que aconteceu (201 para sucesso, 400 para erro, etc).">O cliente pode receber um status padrão (ex: 200) que não condiz com o resultado real</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É vital ser explícito sobre o que aconteceu (201 para sucesso, 400 para erro, etc).">O computador trava</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É vital ser explícito sobre o que aconteceu (201 para sucesso, 400 para erro, etc).">A internet cai</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Onde configuramos o mapeamento de Verbo + Path no backend?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O roteador é quem diz: "Se chegar esse verbo nesse caminho, chame essa função".">No banco de dados</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O roteador é quem diz: "Se chegar esse verbo nesse caminho, chame essa função".">No arquivo de roteamento (Router)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O roteador é quem diz: "Se chegar esse verbo nesse caminho, chame essa função".">No arquivo de interface (CSS)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O roteador é quem diz: "Se chegar esse verbo nesse caminho, chame essa função".">Dentro do arquivo de imagem .png</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Qual a vantagem de padronizar as respostas de erro em JSON?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um JSON de erro estruturado permite que o app reaja de forma inteligente a falhas.">Para o erro ficar mais bonito</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Um JSON de erro estruturado permite que o app reaja de forma inteligente a falhas.">Para que o frontend consiga ler a mensagem e exibir um alerta amigável ao usuário</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um JSON de erro estruturado permite que o app reaja de forma inteligente a falhas.">Para economizar bateria do servidor</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um JSON de erro estruturado permite que o app reaja de forma inteligente a falhas.">Para esconder o código do erro</div>
  <div class="quiz-feedback"></div>
</div>
