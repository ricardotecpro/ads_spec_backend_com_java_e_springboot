# Exercícios 15 - Navegação com React Router 🚦

## 🟢 Fáceis

1.  **Conceito**: Por que usamos o React Router em vez de links `<a>` comuns em uma SPA?
2.  **Componentes**: Para que servem os componentes `<BrowserRouter>` e `<Routes>`?

## 🟡 Médios

3.  **Navegação**:
    Qual a diferença entre usar o componente `<Link>` e o hook `useNavigate`? Em quais situações você usaria cada um?
4.  **Rota 404**:
    Como configuramos uma rota que deve ser exibida quando o usuário digita uma URL que não existe no site?
5.  **Parâmetros**:
    Dada a rota `<Route path="/usuario/:nome" element={<Perfil />} />`, como o componente `Perfil` pode descobrir qual o nome que foi digitado na URL?

## 🔴 Desafio

6.  **Proteção de Rotas**:
    Imagine que você tem uma página `/admin` que só pode ser acessada se o usuário estiver logado.
    *   Como você usaria o `useNavigate` dentro de um `useEffect` para redirecionar o usuário para a página de `/login` caso ele não tenha um token salvo no `localStorage`?
    *   O que acontece se o usuário clicar no botão "Voltar" do navegador após ser redirecionado?