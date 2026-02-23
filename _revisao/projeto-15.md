# Projeto 15 - Sistema de Multi-Páginas 🚦

**Objetivo**: Implementar a navegação completa em uma SPA.

## O Desafio
Transforme seu app de repositórios ou contatos em um site completo com 3 páginas:

1.  **Home (/)**: Uma página de boas-vindas com links para as outras seções.
2.  **Dashboard (/app)**: Onde fica a funcionalidade principal (ex: a busca de repositórios).
3.  **Sobre (/sobre)**: Uma página contando quem criou o projeto.
4.  **404**: Uma página personalizada para links quebrados.

## Requisito Extra (Parâmetro)
Crie uma página de **Perfil de Repositório** (`/repo/:id`) que deve ser aberta ao clicar em um item da lista. Essa página só precisa exibir o ID que foi clicado por enquanto.

## O que avaliar?
- Configuração correta do `BrowserRouter` no `main.jsx` ou `App.jsx`.
- Uso exclusivo de `<Link>` para navegação em menus.
- Funcionamento correto dos parâmetros de URL com `useParams`.