# Quiz 02 - Arquitetura e Gateway 🏗️

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. O que acontece na comunicação síncrona (Sync)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No modelo síncrono, a execução fica bloqueada até que o destino retorne o dado.">O serviço envia a mensagem e esquece</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! No modelo síncrono, a execução fica bloqueada até que o destino retorne o dado.">O serviço envia a requisição e aguarda a resposta para continuar</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No modelo síncrono, a execução fica bloqueada até que o destino retorne o dado.">A comunicação só ocorre via rádio</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No modelo síncrono, a execução fica bloqueada até que o destino retorne o dado.">O banco de dados é desligado</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. Qual o principal perigo da comunicação síncrona em excesso?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Se um serviço na cadeia falhar ou demorar, todos os serviços "acima" dele também sofrerão.">O código fica muito curto</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Se um serviço na cadeia falhar ou demorar, todos os serviços "acima" dele também sofrerão.">Cascateamento de falhas (um serviço lento trava todos os outros)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Se um serviço na cadeia falhar ou demorar, todos os serviços "acima" dele também sofrerão.">Economia exagerada de memória</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Se um serviço na cadeia falhar ou demorar, todos os serviços "acima" dele também sofrerão.">O sistema fica rápido demais</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Qual a função do API Gateway?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Gateway centraliza preocupações transversais como autenticação, log e roteamento.">Armazenar as senhas dos desenvolvedores</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Gateway centraliza preocupações transversais como autenticação, log e roteamento.">Atuar como ponto único de entrada para roteamento e segurança</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Gateway centraliza preocupações transversais como autenticação, log e roteamento.">Substituir o roteador Wi-Fi da empresa</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Gateway centraliza preocupações transversais como autenticação, log e roteamento.">Processar scripts de interface visual</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. O que é "Rate Limiting"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Rate limiting protege o sistema contra abusos ou ataques de negação de serviço (DoS).">Aumentar a velocidade da internet</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Rate limiting protege o sistema contra abusos ou ataques de negação de serviço (DoS).">Limitar a quantidade de requisições que um cliente pode fazer em um tempo</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Rate limiting protege o sistema contra abusos ou ataques de negação de serviço (DoS).">Cobrar por cada clique no botão</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Rate limiting protege o sistema contra abusos ou ataques de negação de serviço (DoS).">Diminuir a fonte do texto</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. No Service Discovery, como os serviços são localizados?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Em ambientes elásticos (Docker/K8s), os IPs mudam sempre, exigindo um "Discovery" dinâmico.">Por endereços IP fixos escritos no código</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Em ambientes elásticos (Docker/K8s), os IPs mudam sempre, exigindo um "Discovery" dinâmico.">Via um registro dinâmico que mantém os endereços atualizados</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Em ambientes elásticos (Docker/K8s), os IPs mudam sempre, exigindo um "Discovery" dinâmico.">Através de busca no Google</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Em ambientes elásticos (Docker/K8s), os IPs mudam sempre, exigindo um "Discovery" dinâmico.">Usando GPS</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Qual o papel do "Load Balancer"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele garante que nenhuma instância fique sobrecarregada enquanto outras estão ociosas.">Medir o peso dos servidores físicos</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Ele garante que nenhuma instância fique sobrecarregada enquanto outras estão ociosas.">Distribuir a carga de trabalho entre várias instâncias do mesmo serviço</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele garante que nenhuma instância fique sobrecarregada enquanto outras estão ociosas.">Equilibrar o gasto de energia</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele garante que nenhuma instância fique sobrecarregada enquanto outras estão ociosas.">Organizar as pastas do projeto</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. O que caracteriza a comunicação Assíncrona (Async)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É ideal para processos longos ou para aumentar a resiliência do sistema.">Uso obrigatório de cabos de fibra ótica</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É ideal para processos longos ou para aumentar a resiliência do sistema.">O uso de mensageria (filas) onde o chamador não espera a resposta imediata</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É ideal para processos longos ou para aumentar a resiliência do sistema.">Comunicação em tempo real por vídeo</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É ideal para processos longos ou para aumentar a resiliência do sistema.">Bloqueio total do banco de dados</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que é um "Circuit Breaker" (Disjuntor)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele protege o sistema impedindo que requisições inúteis sejam feitas a um serviço que já se sabe estar fora do ar.">Um fusível físico no servidor</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Ele protege o sistema impedindo que requisições inúteis sejam feitas a um serviço que já se sabe estar fora do ar.">Um padrão que interrompe chamadas para um serviço falho para evitar sobrecarga</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele protege o sistema impedindo que requisições inúteis sejam feitas a um serviço que já se sabe estar fora do ar.">Um hacker que invade sistemas</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele protege o sistema impedindo que requisições inúteis sejam feitas a um serviço que já se sabe estar fora do ar.">O botão de desligar do computador</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Qual destas é uma responsabilidade típica de um Gateway?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Gateway pode unir dados de 3 serviços diferentes e entregar um único JSON ao frontend.">Desenhar o logo da empresa</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Gateway pode unir dados de 3 serviços diferentes e entregar um único JSON ao frontend.">Compilar código C++</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Gateway pode unir dados de 3 serviços diferentes e entregar um único JSON ao frontend.">Agregação de respostas e Autenticação</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Gateway pode unir dados de 3 serviços diferentes e entregar um único JSON ao frontend.">Formatar o HD do servidor</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Qual ferramenta é comumente usada para implementar Service Discovery?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Eureka e Consul são soluções populares para gerenciar a agenda de serviços em microsserviços.">Microsoft Word</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Eureka e Consul são soluções populares para gerenciar a agenda de serviços em microsserviços.">Netflix Eureka / Consul</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Eureka e Consul são soluções populares para gerenciar a agenda de serviços em microsserviços.">Adobe Photoshop</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Eureka e Consul são soluções populares para gerenciar a agenda de serviços em microsserviços.">WhatsApp</div>
  <div class="quiz-feedback"></div>
</div>
