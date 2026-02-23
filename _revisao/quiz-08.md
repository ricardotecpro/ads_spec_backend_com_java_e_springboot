# Quiz 08 - Boas Práticas e Validação de Dados ✅

1. Por que o backend nunca deve confiar nos dados vindos do frontend?
    - [ ] Para economizar bateria do servidor
    - [x] Porque a requisição pode ter sido interceptada, alterada ou burlada
    - [ ] Porque o frontend é sempre feito por iniciantes
    - [ ] Porque os navegadores são lentos
    *Explicação: Segurança baseada em "confiança" no cliente é uma vulnerabilidade grave.*

2. Qual a diferença entre Validar e Sanitizar?
    - [ ] Validar limpa o dado, Sanitizar checa a regra
    - [x] Validar checa se o dado está correto, Sanitizar "limpa" o dado de impurezas (espaços, tags HTML)
    - [ ] São a mesma coisa com nomes diferentes
    - [ ] Validar é para banco SQL, Sanitizar é para NoSQL
    *Explicação: Validar diz "SIM ou NÃO", Sanitizar diz "AGORA ESTÁ LIMPO".*

3. Para que servem bibliotecas como Zod ou Joi?
    - [ ] Para acelerar a conexão com o banco
    - [x] Para definir e aplicar esquemas de validação de forma declarativa e robusta
    - [ ] Para desenhar gráficos no painel do administrador
    - [ ] Para comprimir arquivos PDF
    *Explicação: Essas bibliotecas removem o excesso de "if/else" e centralizam as regras de entrada.*

4. O que é o princípio DRY (Don't Repeat Yourself)?
    - [ ] Beber água durante o código
    - [x] Evitar a duplicação de lógica, transformando repetir em funções ou serviços únicos
    - [ ] Escrever o código o mais rápido possível
    - [ ] Não usar a tecla Backspace
    *Explicação: Código repetido é difícil de manter; se a regra muda, você esquece de atualizar em algum lugar.*

5. O que um Middleware de Erro Global faz?
    - [ ] Impede que o computador trave
    - [x] Captura qualquer erro não tratado e envia uma resposta padronizada ao cliente
    - [ ] Apaga os logs do servidor
    - [ ] Avisa o usuário que a internet caiu
    *Explicação: Centralizar o erro evita que o servidor "morra" e permite um tratamento profissional de falhas.*

6. Por que NÃO devemos enviar o Stack Trace (detalhes técnicos do erro) para o usuário final?
    - [ ] Porque gasta muitos dados de internet
    - [x] Por segurança, pois revela detalhes da estrutura do banco e do código (ajuda hackers)
    - [ ] Porque o usuário não entende inglês
    - [ ] Porque o Stack Trace é feio
    *Explicação: Informações técnicas sobre o erro devem ser logadas internamente, nunca expostas publicamente.*

7. Qual a vantagem de usar nomes de funções altamente descritivos?
    - [ ] O código fica mais colorido no editor
    - [x] Melhora a legibilidade e facilita a manutenção por outros desenvolvedores (ou por você no futuro)
    - [ ] O compilador processa nomes longos mais rápido
    - [ ] Ocupa menos espaço no servidor
    *Explicação: Código deve ser lido como um livro; o nome da função deve dizer exatamente O QUE ela faz.*

8. O que caracteriza um Erro 400 (Bad Request)?
    - [ ] O servidor parou de funcionar
    - [x] O cliente enviou dados inválidos ou incompletos que o sistema não aceita
    - [ ] O usuário não tem permissão para acessar
    - [ ] A página não existe
    *Explicação: Erros 400 indicam que a culpa é do "lado de lá" (cliente/requisição).*

9. O que caracteriza um Erro 500 (Internal Server Error)?
    - [ ] O usuário digitou a senha errada
    - [x] Ocorreu uma falha inesperada na lógica ou infraestrutura do servidor
    - [ ] O link está quebrado
    - [ ] A conta do usuário foi deletada
    *Explicação: Erros 500 indicam que algo "quebrou" no backend e precisa de reparo.*

10. Como o Clean Code ajuda na escalabilidade de um projeto?
    - [ ] Comprimindo o banco de dados
    - [x] Mantendo o código organizado e modular, facilitando a adição de novas funcionalidades
    - [ ] Diminuindo o preço da hospedagem
    - [ ] Aumentando o número de acessos simultâneos
    *Explicação: Um código limpo é como um quebra-cabeça bem encaixado; é fácil adicionar peças novas.*
