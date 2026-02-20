# Quiz 01 - Introdução a Microsserviços 🌐

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. Qual a principal característica de uma arquitetura Monolítica?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No monólito, todas as funcionalidades residem em um único processo e base de código.">É composta por vários serviços independentes</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! No monólito, todas as funcionalidades residem em um único processo e base de código.">O sistema é um único bloco de código onde tudo está acoplado</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No monólito, todas as funcionalidades residem em um único processo e base de código.">É escrita apenas em JavaScript</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No monólito, todas as funcionalidades residem em um único processo e base de código.">Não utiliza banco de dados</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. Qual vantagem é mais associada aos Microsserviços?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Microsserviços permitem escalar apenas a parte do sistema que precisa de mais fôlego (ex: pagamentos).">Simplicidade de deploy inicial</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Microsserviços permitem escalar apenas a parte do sistema que precisa de mais fôlego (ex: pagamentos).">Baixo custo de infraestrutura</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Microsserviços permitem escalar apenas a parte do sistema que precisa de mais fôlego (ex: pagamentos).">Escalabilidade granular e isolamento de falhas</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Microsserviços permitem escalar apenas a parte do sistema que precisa de mais fôlego (ex: pagamentos).">Facilidade em depurar logs centralizados</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. O que é "Escalabilidade Horizontal"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o ato de adicionar mais "trabalhadores" ao sistema ao invés de aumentar o poder de um só (vertical).">Aumentar a memória RAM de um único servidor</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É o ato de adicionar mais "trabalhadores" ao sistema ao invés de aumentar o poder de um só (vertical).">Adicionar mais máquinas ou instâncias para dividir a carga</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o ato de adicionar mais "trabalhadores" ao sistema ao invés de aumentar o poder de um só (vertical).">Trocar o banco de dados SQL por NoSQL</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o ato de adicionar mais "trabalhadores" ao sistema ao invés de aumentar o poder de um só (vertical).">Aumentar o tamanho das tabelas</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Qual o papel de uma API (Application Programming Interface)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. APIs são os contratos de comunicação entre o backend e seus clientes ou outros serviços.">Criar o design da interface do usuário</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! APIs são os contratos de comunicação entre o backend e seus clientes ou outros serviços.">Permitir a comunicação e troca de dados entre sistemas</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. APIs são os contratos de comunicação entre o backend e seus clientes ou outros serviços.">Servir como o sistema operacional do servidor</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. APIs são os contratos de comunicação entre o backend e seus clientes ou outros serviços.">Substituir o banco de dados</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. Sobre Microsserviços, o que significa ser "Poliglota"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um serviço pode ser em Node.js e outro em Java, dependendo da necessidade técnica.">Falar várias línguas humanas</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Um serviço pode ser em Node.js e outro em Java, dependendo da necessidade técnica.">A liberdade de usar diferentes linguagens/tecnologias para cada serviço</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um serviço pode ser em Node.js e outro em Java, dependendo da necessidade técnica.">Rodar apenas em servidores internacionais</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Um serviço pode ser em Node.js e outro em Java, dependendo da necessidade técnica.">Usar apenas tradução automática nas rotas</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Qual destas ferramentas é usada para testar requisições para uma API sem precisar de frontend?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Clients HTTP como o Postman permitem enviar verbos como GET, POST, etc., e ver a resposta direta.">Photoshop</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Clients HTTP como o Postman permitem enviar verbos como GET, POST, etc., e ver a resposta direta.">Postman / Insomnia</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Clients HTTP como o Postman permitem enviar verbos como GET, POST, etc., e ver a resposta direta.">Excel</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Clients HTTP como o Postman permitem enviar verbos como GET, POST, etc., e ver a resposta direta.">Docker</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. O que acontece se um módulo de um monólito tiver um "Memory Leak" crítico?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Como tudo roda no mesmo processo, falhas críticas afetam o bloco inteiro.">Apenas aquele módulo para de funcionar</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Como tudo roda no mesmo processo, falhas críticas afetam o bloco inteiro.">O banco de dados se apaga automaticamente</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Como tudo roda no mesmo processo, falhas críticas afetam o bloco inteiro.">Provavelmente todo o sistema ficará instável ou sairá do ar</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Como tudo roda no mesmo processo, falhas críticas afetam o bloco inteiro.">O sistema migra sozinho para microsserviços</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. Qual o formato de dados mais comum usado hoje para comunicação entre serviços?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O JSON é leve, legível por humanos e o padrão de facto para APIs REST.">XML</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O JSON é leve, legível por humanos e o padrão de facto para APIs REST.">JSON</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O JSON é leve, legível por humanos e o padrão de facto para APIs REST.">CSV</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O JSON é leve, legível por humanos e o padrão de facto para APIs REST.">TXT</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Por que Microsserviços são considerados mais complexos operacionalmente?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Manter 50 serviços conversando entre si exige muito mais automação e observabilidade.">Porque exigem mais linhas de código</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Manter 50 serviços conversando entre si exige muito mais automação e observabilidade.">Devido à necessidade de monitorar muitos serviços, redes e consistência distribuída</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Manter 50 serviços conversando entre si exige muito mais automação e observabilidade.">Porque só funcionam com Linux</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Manter 50 serviços conversando entre si exige muito mais automação e observabilidade.">Porque requerem hardware da NASA</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Qual ferramenta ajuda a garantir que o ambiente de desenvolvimento seja idêntico ao de produção?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Docker isola o serviço e suas dependências em um container que roda igual em qualquer lugar.">Git</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Docker isola o serviço e suas dependências em um container que roda igual em qualquer lugar.">Postman</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O Docker isola o serviço e suas dependências em um container que roda igual em qualquer lugar.">VS Code</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O Docker isola o serviço e suas dependências em um container que roda igual em qualquer lugar.">Docker (Containerização)</div>
  <div class="quiz-feedback"></div>
</div>
