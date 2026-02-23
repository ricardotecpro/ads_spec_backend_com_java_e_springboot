# Quiz 10 - Controle de Acesso (RBAC) 🛡️

1. O que significa a sigla RBAC?
    - [ ] Real-Binary-Authentication-Code
    - [x] Role-Based Access Control
    - [ ] Route-Based Authorization Check
    - [ ] Restricted-Backend-Access-Control
    *Explicação: É o padrão de mercado para gerenciar permissões baseadas em "perfis" ou "papéis" do usuário.*

2. No RBAC, a quem atribuímos as permissões de acesso?
    - [ ] A cada usuário individualmente por seu CPF
    - [x] A um perfil (Role) que pode ser compartilhado por vários usuários
    - [ ] Apenas ao dono da empresa
    - [ ] Ao endereço IP do computador
    *Explicação: Atribuir a perfis facilita a manutenção, especialmente em sistemas com muitos usuários.*

3. Qual o código HTTP para "Acesso Negado" (Usuário identificado, mas sem permissão)?
    - [ ] 401 Unauthorized
    - [ ] 404 Not Found
    - [x] 403 Forbidden
    - [ ] 500 Internal Error
    *Explicação: O 403 indica que o servidor entendeu quem é você, mas proibiu a ação.*

4. Qual a ordem correta dos middlewares em uma rota protegida?
    - [ ] Primeiro Autorização, depois Autenticação
    - [x] Primeiro Autenticação, depois Autorização
    - [ ] Ambos devem rodar ao mesmo tempo
    - [ ] Apenas um é necessário
    *Explicação: Primeiro desvendamos QUEM é o usuário (Token), para depois checar O QUE ele pode fazer.*

5. O que um Middleware de Autorização faz se o usuário não tem o nível necessário?
    - [ ] Reinicia o servidor
    - [x] Interrompe a requisição e retorna um erro 403 ao cliente
    - [ ] Envia a requisição para outra rota aleatória
    - [ ] Formata o banco de dados
    *Explicação: O middleware age como uma trava que impede a execução do código do Controller.*

6. Por que o Erro 401 (Unauthorized) é retornado quando o token JWT é inválido?
    - [ ] Porque o usuário é feio
    - [x] Porque a identidade do usuário não pôde ser confirmada
    - [ ] Porque o servidor está desligado
    - [ ] Porque o sistema está em manutenção
    *Explicação: 401 significa "Quem é você? Não te conheço ou seu crachá é falso".*

7. Em um sistema de E-commerce, quem deve ter permissão para a rota `DELETE /produtos/:id`?
    - [ ] Todos os clientes
    - [x] Apenas usuários com a Role 'ADMIN' ou 'GERENTE'
    - [ ] Qualquer pessoa sem login
    - [ ] Apenas o programador que criou o site
    *Explicação: Ações destrutivas devem ser restritas a perfis de alta confiança.*

8. O que é "Hierarquia de Roles"?
    - [ ] Uma lista de nomes em ordem alfabética
    - [x] Quando perfis superiores (ex: Admin) herdam automaticamente as permissões de perfis inferiores
    - [ ] O tamanho da letra no banco de dados
    - [ ] A ordem de criação dos usuários
    *Explicação: Facilita o código, evitando ter que listar 'ADMIN' em todas as rotas simples.*

9. O que acontece se chamarmos a função `next()` dentro de um middleware?
    - [ ] O servidor para
    - [x] O processamento passa para o próximo middleware ou para o Controller
    - [ ] O usuário é deslogado
    - [ ] Uma nova aba abre no navegador
    *Explicação: O `next()` é o sinal verde para a requisição seguir seu fluxo.*

10. Qual a principal vantagem de centralizar a autorização em middlewares?
    - [ ] O app fica mais bonito
    - [x] Segurança e Reuso: você protege rotas inteiras com uma única linha de código
    - [ ] O banco de dados fica mais rápido
    - [ ] Os usuários ganham descontos
    *Explicação: Centralizar evita que você esqueça de colocar "if" em algum Controller, deixando brechas de segurança.*
