# Quiz 11 - Refresh Token e Segurança Avançada 🏗️

1. Por que não é recomendado que o Access Token dure muitos dias?
    - [ ] Porque ele ocupa muito espaço no servidor
    - [x] Por segurança: se for roubado, o hacker terá acesso por pouco tempo
    - [ ] Porque o navegador apaga tokens longos automaticamente
    - [ ] Porque o Google não permite
    *Explicação: Tokens curtos minimizam o estrago em caso de vazamento de credenciais.*

2. Para que serve o Refresh Token?
    - [ ] Para mudar a senha do usuário
    - [x] Para pedir um novo Access Token sem que o usuário tenha que digitar a senha novamente
    - [ ] Para aumentar a velocidade da internet
    - [ ] Para carregar imagens mais rápido
    *Explicação: Ele garante uma boa experiência de uso (UX) sem sacrificar a segurança.*

3. O que significa a sigla CORS?
    - [ ] Central-Order-Resource-System
    - [x] Cross-Origin Resource Sharing
    - [ ] Code-Origin-Restriction-Safe
    - [ ] Chrome-Only-Response-System
    *Explicação: É o mecanismo que define quais sites externos podem acessar sua API.*

4. Quem aplica o bloqueio de CORS?
    - [ ] O Provedor de Internet
    - [ ] O Microprocessador do celular
    - [x] O Navegador (Chrome, Firefox, Safari)
    - [ ] O Teclado do usuário
    *Explicação: O navegador bloqueia a leitura da resposta se o servidor não enviar os headers de permissão corretos.*

5. Qual a função da biblioteca Helmet?
    - [ ] Proteger o servidor contra quedas físicas
    - [x] Configurar automaticamente diversos headers de segurança no HTTP
    - [ ] Aumentar o brilho da tela
    - [ ] Traduzir o app para inglês
    *Explicação: O Helmet ajuda a esconder detalhes do servidor e prevenir ataques como XSS.*

6. O que é "Rate Limiting"?
    - [ ] O limite de velocidade do Wi-Fi
    - [x] Uma técnica para limitar o número de requisições que um usuário/IP pode fazer em um tempo
    - [ ] Quando o app fica lento de propósito
    - [ ] O limite de amigos que alguém pode ter
    *Explicação: É essencial para evitar ataques de força bruta (Brute Force) e ataques de negação de serviço (DoS).*

7. Por que devemos evitar `origin: '*'` no CORS em produção?
    - [ ] Porque o servidor fica pesado
    - [x] Porque qualquer site malicioso do mundo poderia tentar roubar dados da sua API
    - [ ] Porque o Google penaliza sites assim
    - [ ] Porque os usuários não gostam
    *Explicação: O ideal é listar apenas os domínios oficiais que você confia.*

8. O que é o ataque XSS (Cross-Site Scripting)?
    - [ ] Quando o banco de dados é deletado
    - [x] Quando um invasor consegue injetar scripts maliciosos em páginas vistas por outros usuários
    - [ ] Quando o cabo USB desconecta
    - [ ] Quando a senha é muito curta
    *Explicação: O invasor pode usar isso para roubar tokens ou cookies de outros usuários.*

9. Qual desses é o lugar mais seguro para guardar o Refresh Token no navegador?
    - [ ] localStorage
    - [ ] sessionStorage
    - [x] Cookie com a flag HttpOnly
    - [ ] No histórico de navegação
    *Explicação: Cookies HttpOnly não podem ser lidos via Javascript, o que protege contra ataques XSS.*

10. O que acontece em um "Refresh Token Rotation"?
    - [ ] O token muda de cor
    - [x] Sempre que um novo Access Token é pedido, o Refresh Token antigo é invalidado e um novo é gerado
    - [ ] O usuário é obrigado a trocar a senha
    - [ ] O servidor reinicia
    *Explicação: É uma camada extra de segurança para detectar se um Refresh Token foi roubado.*
