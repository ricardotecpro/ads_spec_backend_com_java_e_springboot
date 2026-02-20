# Quiz 15 - Navegação com React Router 🚦

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. O que é uma SPA (Single Page Application)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. SPAs oferecem uma experiência fluida, parecida com um app nativo, sem recarregamentos de página.">Um site que só funciona em um navegador</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! SPAs oferecem uma experiência fluida, parecida com um app nativo, sem recarregamentos de página.">Uma aplicação onde o HTML é carregado uma única vez e o Javascript troca o conteúdo da tela</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. SPAs oferecem uma experiência fluida, parecida com um app nativo, sem recarregamentos de página.">Um site que não tem Javascript</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. SPAs oferecem uma experiência fluida, parecida com um app nativo, sem recarregamentos de página.">Um aplicativo de celular que não usa internet</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. Qual componente é obrigatório para envolver toda a aplicação que usará rotas?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele é o "contexto" que permite ao React monitorar a URL do navegador."><Route></div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele é o "contexto" que permite ao React monitorar a URL do navegador."><Link></div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Ele é o "contexto" que permite ao React monitorar a URL do navegador."><BrowserRouter></div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Ele é o "contexto" que permite ao React monitorar a URL do navegador."><RouterManager></div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Como definimos uma rota específica para a página de contato?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No React Router v6, usamos os atributos `path` e `element`."><Route url="/contato" component={Contato} /></div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! No React Router v6, usamos os atributos `path` e `element`."><Route path="/contato" element={<Contato />} /></div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No React Router v6, usamos os atributos `path` e `element`."><Link to="/contato" /></div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. No React Router v6, usamos os atributos `path` e `element`."><a href="/contato"></div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Por que não devemos usar a tag `<a>` para navegar entre rotas no React?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O componente `<Link>` intercepta o clique para manter a troca de telas interna.">Porque ela é proibida pelo Google</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O componente `<Link>` intercepta o clique para manter a troca de telas interna.">Porque ela gasta mais bateria</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O componente `<Link>` intercepta o clique para manter a troca de telas interna.">Porque ela causa um recarregamento total da página, perdendo o estado do React</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O componente `<Link>` intercepta o clique para manter a troca de telas interna.">Porque ela não aceita CSS</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. Para que serve o caractere `*` no atributo `path`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É a forma padrão de lidar com links inexistentes.">Para indicar uma rota secreta</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É a forma padrão de lidar com links inexistentes.">Como um "coringa" para capturar qualquer URL que não foi definida anteriormente (Página 404)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É a forma padrão de lidar com links inexistentes.">Para multiplicar o número de páginas</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É a forma padrão de lidar com links inexistentes.">Para aceitar qualquer tipo de arquivo</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Qual hook usamos para capturar parâmetros da URL (ex: o ID em `/post/10`)?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Os parâmetros definidos com `:` na rota são extraídos por este hook.">useID()</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Os parâmetros definidos com `:` na rota são extraídos por este hook.">useRoute()</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Os parâmetros definidos com `:` na rota são extraídos por este hook.">useParams()</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Os parâmetros definidos com `:` na rota são extraídos por este hook.">useQuery()</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. Como redirecionamos o usuário para a Home após ele clicar em um botão de "Sair"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O hook `useNavigate` permite navegação via lógica de programação.">window.location.href = "/"</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O hook `useNavigate` permite navegação via lógica de programação.">const navigate = useNavigate(); navigate("/");</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O hook `useNavigate` permite navegação via lógica de programação."><Link to="/" /></div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O hook `useNavigate` permite navegação via lógica de programação.">useRoute("/")</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que acontece se removermos o componente `<Routes>` e deixarmos apenas os `<Route>`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. `<Routes>` é o componente que escolhe qual rota renderizar baseada na URL atual.">O app continua funcionando</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! `<Routes>` é o componente que escolhe qual rota renderizar baseada na URL atual.">O React Router gerará um erro, pois os Route precisam estar dentro de um provedor de rotas</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. `<Routes>` é o componente que escolhe qual rota renderizar baseada na URL atual.">O site fica mais lento</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. `<Routes>` é o componente que escolhe qual rota renderizar baseada na URL atual.">O menu desaparece</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Em qual pacote extra encontramos as ferramentas de roteamento do React?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O `react-router-dom` é a versão específica para navegadores web.">react-dom</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O `react-router-dom` é a versão específica para navegadores web.">react-router</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O `react-router-dom` é a versão específica para navegadores web.">react-router-dom</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O `react-router-dom` é a versão específica para navegadores web.">vite-plugin-router</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Como definimos um parâmetro dinâmico chamado `slug` na URL?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O uso dos dois pontos (`:`) sinaliza que aquela parte da URL é uma variável.">path="/blog/slug"</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O uso dos dois pontos (`:`) sinaliza que aquela parte da URL é uma variável.">path="/blog/:slug"</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O uso dos dois pontos (`:`) sinaliza que aquela parte da URL é uma variável.">path="/blog/{slug}"</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O uso dos dois pontos (`:`) sinaliza que aquela parte da URL é uma variável.">path="/blog/*slug"</div>
  <div class="quiz-feedback"></div>
</div>
