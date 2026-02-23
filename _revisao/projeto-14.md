# Projeto 14 - Buscador de Repositórios 🔍

**Objetivo**: Consumir uma API real e gerenciar estados de carregamento.

## O Desafio
Crie um app que busca repositórios do GitHub de um usuário:

1.  **Input**: Campo para digitar o nome do usuário do GitHub.
2.  **Botão Buscar**: Ao clicar, deve disparar a busca.
3.  **Loading**: Enquanto a API não responde, deve aparecer o texto "Buscando repositórios...".
4.  **Lista**: Exiba o nome de todos os repositórios públicos encontrados.
5.  **Erro**: Se o usuário não existir, exiba "Erro: Usuário não encontrado".

## O que avaliar?
- Uso do `useEffect` para carregar dados (pode ser ao carregar a página ou via clique).
- Tratamento correto dos estados: `null`, `loading`, `data` e `error`.
- Renderização limpa usando `.map()`.