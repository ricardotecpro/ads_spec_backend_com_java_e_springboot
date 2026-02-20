# Quiz 06 - Services e Regras de Negócio 🧠

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. O que acontece se colocarmos toda a lógica de negócio dentro do Controller?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Acoplar lógica de negócio ao transporte HTTP cria dívida técnica e dificulta a evolução do sistema.">O app fica mais rápido</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Acoplar lógica de negócio ao transporte HTTP cria dívida técnica e dificulta a evolução do sistema.">O código fica difícil de testar, manter e reutilizar (o famoso "Controller Gordo")</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Acoplar lógica de negócio ao transporte HTTP cria dívida técnica e dificulta a evolução do sistema.">O banco de dados se apaga sozinho</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Acoplar lógica de negócio ao transporte HTTP cria dívida técnica e dificulta a evolução do sistema.">O roteamento para de funcionar</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. Qual a principal responsabilidade do Service?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Service é onde o conhecimento do domínio da aplicação (as regras do "negócio") reside.">Definir as rotas do app</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Service é onde o conhecimento do domínio da aplicação (as regras do "negócio") reside.">Executar as regras de negócio, validações e cálculos</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Service é onde o conhecimento do domínio da aplicação (as regras do "negócio") reside.">Gerar as respostas JSON para o cliente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Service é onde o conhecimento do domínio da aplicação (as regras do "negócio") reside.">Configurar a porta do servidor</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Como um Service deve notificar o Controller sobre uma falha de validação?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O lançamento de erros permite que o Controller capture o fluxo e decida qual resposta HTTP enviar.">Retornando um número 400</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O lançamento de erros permite que o Controller capture o fluxo e decida qual resposta HTTP enviar.">Lançando uma exceção ou erro (throw Error)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O lançamento de erros permite que o Controller capture o fluxo e decida qual resposta HTTP enviar.">Enviando um e-mail para o administrador</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O lançamento de erros permite que o Controller capture o fluxo e decida qual resposta HTTP enviar.">Mudando a cor do console</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Por que o Service não deve acessar os objetos `req` ou `res`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A camada de serviço deve ser "cega" para o transporte, focando apenas nos dados e regras.">Porque eles são secretos</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! A camada de serviço deve ser "cega" para o transporte, focando apenas nos dados e regras.">Para manter o Service independente do protocolo de transporte (podendo ser usado em gRPC, CLI, etc)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A camada de serviço deve ser "cega" para o transporte, focando apenas nos dados e regras.">Porque isso gasta muita internet</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A camada de serviço deve ser "cega" para o transporte, focando apenas nos dados e regras.">Para economizar linhas de código</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. O que define uma "Regra de Negócio"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Regras de negócio são as "leis" do funcionamento daquela aplicação específica.">O nome das variáveis do sistema</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Regras de negócio são as "leis" do funcionamento daquela aplicação específica.">As diretrizes que ditam como o serviço deve operar (ex: "só maiores de 18 podem comprar")</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Regras de negócio são as "leis" do funcionamento daquela aplicação específica.">O tipo de servidor onde o app está rodando</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Regras de negócio são as "leis" do funcionamento daquela aplicação específica.">A cor do logotipo da empresa</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Qual a vantagem de reutilizar um Service em diferentes Controllers?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Centralizar a regra no Service garante que, se a lei mudar, você só precisa alterar em um lugar.">Nenhuma, é melhor copiar o código</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Centralizar a regra no Service garante que, se a lei mudar, você só precisa alterar em um lugar.">Consistência: a regra é aplicada da mesma forma em todo o sistema</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Centralizar a regra no Service garante que, se a lei mudar, você só precisa alterar em um lugar.">Economiza espaço de memória no disco</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Centralizar a regra no Service garante que, se a lei mudar, você só precisa alterar em um lugar.">Deixa o site mais colorido</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. O que é um DTO (Data Transfer Object)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. DTOs ajudam a filtrar campos sensíveis (como senhas) antes de enviá-los ao mundo externo.">Um tipo de cabo para conectar servidores</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! DTOs ajudam a filtrar campos sensíveis (como senhas) antes de enviá-los ao mundo externo.">Um objeto simples usado para transportar dados entre camadas sem expor a lógica interna</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. DTOs ajudam a filtrar campos sensíveis (como senhas) antes de enviá-los ao mundo externo.">O nome do motor de busca do Google</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. DTOs ajudam a filtrar campos sensíveis (como senhas) antes de enviá-los ao mundo externo.">Um comando do terminal Linux</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que significa "Separation of Concerns" (Separação de Preocupações)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Dividir o sistema em Controller, Service e Repository é aplicar esse princípio fundamental.">Cada desenvolvedor deve trabalhar sozinho</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Dividir o sistema em Controller, Service e Repository é aplicar esse princípio fundamental.">Cada camada do sistema deve ter uma responsabilidade única e bem definida</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Dividir o sistema em Controller, Service e Repository é aplicar esse princípio fundamental.">O banco de dados deve ficar em outro país</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Dividir o sistema em Controller, Service e Repository é aplicar esse princípio fundamental.">O site deve ter várias cores diferentes</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Qual o momento ideal para chamar o Service dentro de uma rota?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller "limpa" a entrada e passa os dados "puros" para o Service processar.">Antes de receber a requisição</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Controller "limpa" a entrada e passa os dados "puros" para o Service processar.">Após o Controller validar os parâmetros básicos de entrada</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller "limpa" a entrada e passa os dados "puros" para o Service processar.">Depois que a resposta já foi enviada ao cliente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller "limpa" a entrada e passa os dados "puros" para o Service processar.">Nunca, o Controller deve fazer tudo</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Como o Controller deve tratar o retorno de um Service?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller é o tradutor final que comunica o sucesso ou erro do Service para o cliente HTTP.">Ignorando o resultado</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Controller é o tradutor final que comunica o sucesso ou erro do Service para o cliente HTTP.">Capturando o dado retornado e devolvendo em um JSON com Status 200/201</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller é o tradutor final que comunica o sucesso ou erro do Service para o cliente HTTP.">Pedindo para o usuário reiniciar o computador</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Controller é o tradutor final que comunica o sucesso ou erro do Service para o cliente HTTP.">Exibindo o código fonte na tela</div>
  <div class="quiz-feedback"></div>
</div>
