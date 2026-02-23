# Exercícios 10 - Controle de Acesso (RBAC) 🛡️

## 🟢 Fáceis

1.  **Conceito**: No sistema RBAC, o que é uma "Role"?
2.  **Status Code**: Se um usuário comum tenta acessar uma área de administrador, qual o código de erro HTTP (Status Code) mais apropriado?

## 🟡 Médios

3.  **Diferença**:
    Explique a diferença fundamental entre erro 401 e erro 403. Em qual desses casos o usuário deve ser redirecionado para a tela de login?
4.  **Middleware**:
    Imagine que você tem uma rota `/admin/dashboard`. Quais seriam os dois middlewares (nesta ordem) que o usuário deveria passar antes de chegar no Controller final?

## 🔴 Desafio

5.  **Hierarchy (Hierarquia)**:
    Implemente (em pseudocódigo) uma lógica onde a função `autorizar(['EDITOR', 'ADMIN'])` permita a passagem se o usuário logado tiver QUALQUER um desses dois perfis.
    *   Como você garantiria que um `ADMIN` sempre consiga acessar rotas de `USER` e `EDITOR` sem precisar listar o `ADMIN` em todas as rotas do sistema?
    *   Qual a vantagem dessa abordagem centralizada?