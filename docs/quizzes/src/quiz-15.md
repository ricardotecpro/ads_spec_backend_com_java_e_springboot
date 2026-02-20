# Quiz 15 - Navegação com React Router 🚦

1. O que é uma SPA (Single Page Application)?
    - [ ] Um site que só funciona em um navegador
    - [x] Uma aplicação onde o HTML é carregado uma única vez e o Javascript troca o conteúdo da tela
    - [ ] Um site que não tem Javascript
    - [ ] Um aplicativo de celular que não usa internet
    *Explicação: SPAs oferecem uma experiência fluida, parecida com um app nativo, sem recarregamentos de página.*

2. Qual componente é obrigatório para envolver toda a aplicação que usará rotas?
    - [ ] <Route>
    - [ ] <Link>
    - [x] <BrowserRouter>
    - [ ] <RouterManager>
    *Explicação: Ele é o "contexto" que permite ao React monitorar a URL do navegador.*

3. Como definimos uma rota específica para a página de contato?
    - [ ] <Route url="/contato" component={Contato} />
    - [x] <Route path="/contato" element={<Contato />} />
    - [ ] <Link to="/contato" />
    - [ ] <a href="/contato">
    *Explicação: No React Router v6, usamos os atributos `path` e `element`.*

4. Por que não devemos usar a tag `<a>` para navegar entre rotas no React?
    - [ ] Porque ela é proibida pelo Google
    - [ ] Porque ela gasta mais bateria
    - [x] Porque ela causa um recarregamento total da página, perdendo o estado do React
    - [ ] Porque ela não aceita CSS
    *Explicação: O componente `<Link>` intercepta o clique para manter a troca de telas interna.*

5. Para que serve o caractere `*` no atributo `path`?
    - [ ] Para indicar uma rota secreta
    - [x] Como um "coringa" para capturar qualquer URL que não foi definida anteriormente (Página 404)
    - [ ] Para multiplicar o número de páginas
    - [ ] Para aceitar qualquer tipo de arquivo
    *Explicação: É a forma padrão de lidar com links inexistentes.*

6. Qual hook usamos para capturar parâmetros da URL (ex: o ID em `/post/10`)?
    - [ ] useID()
    - [ ] useRoute()
    - [x] useParams()
    - [ ] useQuery()
    *Explicação: Os parâmetros definidos com `:` na rota são extraídos por este hook.*

7. Como redirecionamos o usuário para a Home após ele clicar em um botão de "Sair"?
    - [ ] window.location.href = "/"
    - [x] const navigate = useNavigate(); navigate("/");
    - [ ] <Link to="/" />
    - [ ] useRoute("/")
    *Explicação: O hook `useNavigate` permite navegação via lógica de programação.*

8. O que acontece se removermos o componente `<Routes>` e deixarmos apenas os `<Route>`?
    - [ ] O app continua funcionando
    - [x] O React Router gerará um erro, pois os Route precisam estar dentro de um provedor de rotas
    - [ ] O site fica mais lento
    - [ ] O menu desaparece
    *Explicação: `<Routes>` é o componente que escolhe qual rota renderizar baseada na URL atual.*

9. Em qual pacote extra encontramos as ferramentas de roteamento do React?
    - [ ] react-dom
    - [ ] react-router
    - [x] react-router-dom
    - [ ] vite-plugin-router
    *Explicação: O `react-router-dom` é a versão específica para navegadores web.*

10. Como definimos um parâmetro dinâmico chamado `slug` na URL?
    - [ ] path="/blog/slug"
    - [x] path="/blog/:slug"
    - [ ] path="/blog/{slug}"
    - [ ] path="/blog/*slug"
    *Explicação: O uso dos dois pontos (`:`) sinaliza que aquela parte da URL é uma variável.*
