# Quiz 04 - Documentação e Mocks 📝

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. O que é o OpenAPI (OAS)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O OpenAPI define um formato padrão para descrever recursos, rotas e respostas de uma API.">Uma linguagem de programação para backend</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O OpenAPI define um formato padrão para descrever recursos, rotas e respostas de uma API.">Uma especificação padrão para descrever e documentar APIs RESTful</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O OpenAPI define um formato padrão para descrever recursos, rotas e respostas de uma API.">Um navegador web para desenvolvedores</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O OpenAPI define um formato padrão para descrever recursos, rotas e respostas de uma API.">Um banco de dados em nuvem</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. Qual a principal diferença entre OpenAPI e Swagger?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Pense no OpenAPI como as "regras" e no Swagger como as "ferramentas" que usam essas regras.">Swagger é pago e OpenAPI é gratuito</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Pense no OpenAPI como as "regras" e no Swagger como as "ferramentas" que usam essas regras.">OpenAPI é a especificação e Swagger é o conjunto de ferramentas (UI, Editor, etc)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Pense no OpenAPI como as "regras" e no Swagger como as "ferramentas" que usam essas regras.">OpenAPI foi substituída pelo Swagger em 2021</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Pense no OpenAPI como as "regras" e no Swagger como as "ferramentas" que usam essas regras.">Não há diferença, são nomes para a mesma cor</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Para que serve o Swagger UI?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Swagger UI lê o arquivo YAML/JSON e cria uma interface amigável para humanos.">Para editar o banco de dados diretamente</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Swagger UI lê o arquivo YAML/JSON e cria uma interface amigável para humanos.">Para gerar uma página visual e interativa onde se pode testar os endpoints documentados</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Swagger UI lê o arquivo YAML/JSON e cria uma interface amigável para humanos.">Para compilar o código Java para o servidor</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Swagger UI lê o arquivo YAML/JSON e cria uma interface amigável para humanos.">Para baixar músicas gratuitas</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Qual o objetivo principal de um "Mock de API"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Mocks permitem que o Frontend programe contra um servidor "de mentira" enquanto o real não está pronto.">Substituir o backup do sistema</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Mocks permitem que o Frontend programe contra um servidor "de mentira" enquanto o real não está pronto.">Simular o comportamento de uma API real para permitir o desenvolvimento paralelo</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Mocks permitem que o Frontend programe contra um servidor "de mentira" enquanto o real não está pronto.">Aumentar a segurança contra vírus</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Mocks permitem que o Frontend programe contra um servidor "de mentira" enquanto o real não está pronto.">Esconder o endereço IP do servidor</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. O que significa "Developer Experience" (DX)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Uma boa DX significa documentação clara, erros úteis e facilidade de integração.">O tempo que o desenvolvedor gasta jogando videogame</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Uma boa DX significa documentação clara, erros úteis e facilidade de integração.">A facilidade e satisfação de um desenvolvedor ao usar sua ferramenta ou API</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Uma boa DX significa documentação clara, erros úteis e facilidade de integração.">A quantidade de memória RAM do monitor</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Uma boa DX significa documentação clara, erros úteis e facilidade de integração.">O nome do sistema operacional dos servidores</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Qual formato de arquivo é mais utilizado para escrever especificações OpenAPI?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. YAML é preferido por ser mais legível por humanos e suportar identação clara.">.html</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! YAML é preferido por ser mais legível por humanos e suportar identação clara.">.yaml ou .json</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. YAML é preferido por ser mais legível por humanos e suportar identação clara.">.docx</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. YAML é preferido por ser mais legível por humanos e suportar identação clara.">.pdf</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. Por que retornar mensagens de erro explicativas no corpo da resposta (Body) é uma boa prática?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um erro `400` com a mensagem `"Data de nascimento é obrigatória"` economiza horas de suporte.">Para o log ficar mais colorido</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Um erro `400` com a mensagem `"Data de nascimento é obrigatória"` economiza horas de suporte.">Para ajudar o consumidor da API a entender exatamente o que errou sem precisar perguntar ao autor</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um erro `400` com a mensagem `"Data de nascimento é obrigatória"` economiza horas de suporte.">Porque o HTTP obriga a escrever textos longos</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um erro `400` com a mensagem `"Data de nascimento é obrigatória"` economiza horas de suporte.">Para ocupar mais espaço no servidor</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. Qual componente do Swagger permite digitar e validar a especificação da API em tempo real?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Editor valida a sintaxe YAML e mostra o preview da documentação instantaneamente.">Swagger Hub</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Editor valida a sintaxe YAML e mostra o preview da documentação instantaneamente.">Swagger Editor</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Editor valida a sintaxe YAML e mostra o preview da documentação instantaneamente.">Swagger Inspector</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Editor valida a sintaxe YAML e mostra o preview da documentação instantaneamente.">Swagger Play</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Em qual fase do projeto o "Design de Contrato" deve ocorrer?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No API First, o contrato é acordado primeiro para que as equipes de Front e Back trabalhem em sintaxe.">Somente no fim do projeto para arquivar</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! No API First, o contrato é acordado primeiro para que as equipes de Front e Back trabalhem em sintaxe.">No início, antes mesmo de começar a codificar as rotas (API First)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No API First, o contrato é acordado primeiro para que as equipes de Front e Back trabalhem em sintaxe.">Apenas se o cliente pedir</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No API First, o contrato é acordado primeiro para que as equipes de Front e Back trabalhem em sintaxe.">Nunca, é perda de tempo</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Qual ferramenta pode ser usada para subir um mock server local a partir de uma collection?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Postman e Mockoon facilitam a criação de respostas estáticas baseadas em rotas.">Microsoft Excel</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Postman e Mockoon facilitam a criação de respostas estáticas baseadas em rotas.">Postman / Mockoon</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Postman e Mockoon facilitam a criação de respostas estáticas baseadas em rotas.">Notepad++</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Postman e Mockoon facilitam a criação de respostas estáticas baseadas em rotas.">Windows Paint</div>
  <div class="quiz-feedback"></div>
</div>
