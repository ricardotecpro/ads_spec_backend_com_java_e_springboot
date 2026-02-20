# Quiz 14 - Efeitos e APIs (useEffect) 🌐

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. O que é um "Efeito Colateral" no React?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Efeitos saem do campo puro de "desenhar componentes" e tocam o mundo externo.">É um bug que trava o computador</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Efeitos saem do campo puro de "desenhar componentes" e tocam o mundo externo.">Uma ação que acontece fora do fluxo normal de renderizar a interface (ex: buscar dados, timers)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Efeitos saem do campo puro de "desenhar componentes" e tocam o mundo externo.">É o nome de uma biblioteca de animação</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Efeitos saem do campo puro de "desenhar componentes" e tocam o mundo externo.">É quando o CSS muda a cor do botão</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. Qual o segundo parâmetro do `useEffect`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Esse array decide quando o efeito deve ser re-executado.">Um número inteiro</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Esse array decide quando o efeito deve ser re-executado.">O array de dependências</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Esse array decide quando o efeito deve ser re-executado.">O nome do componente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Esse array decide quando o efeito deve ser re-executado.">Um arquivo CSS</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. O que acontece se passarmos um array de dependências vazio `[]`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o padrão usado para buscar dados iniciais de uma API.">O efeito nunca roda</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o padrão usado para buscar dados iniciais de uma API.">O efeito roda em todo "re-render"</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! É o padrão usado para buscar dados iniciais de uma API.">O efeito roda apenas uma vez, quando o componente é montado (aparece na tela)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. É o padrão usado para buscar dados iniciais de uma API.">O app fecha com erro</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. Como fazemos para que um efeito rode toda vez que o estado `tema` mudar?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Incluir a variável no array obriga o React a monitorá-la.">useEffect(() => { ... })</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Incluir a variável no array obriga o React a monitorá-la.">useEffect(() => { ... }, [])</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Incluir a variável no array obriga o React a monitorá-la.">useEffect(() => { ... }, [tema])</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Incluir a variável no array obriga o React a monitorá-la.">useEffect([tema], () => { ... })</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. O que a função `fetch()` retorna?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Chamadas de rede são assíncronas; o fetch promete que trará o dado no futuro.">O dado final em formato JSON</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Chamadas de rede são assíncronas; o fetch promete que trará o dado no futuro.">Uma Promise (Promessa)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Chamadas de rede são assíncronas; o fetch promete que trará o dado no futuro.">Um número de erro</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Chamadas de rede são assíncronas; o fetch promete que trará o dado no futuro.">Uma string de texto</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Para que serve o `.then(res => res.json())`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A resposta inicial é um objeto de rede; precisamos extrair o corpo dela em JSON.">Para salvar o dado no disco</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A resposta inicial é um objeto de rede; precisamos extrair o corpo dela em JSON.">Para fechar a conexão</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! A resposta inicial é um objeto de rede; precisamos extrair o corpo dela em JSON.">Para converter a resposta bruta da rede em um objeto Javascript que possamos usar</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A resposta inicial é um objeto de rede; precisamos extrair o corpo dela em JSON.">Para criptografar os dados</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. Qual a maneira correta de lidar com o estado de "Carregando"?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Feedback para o usuário é essencial para uma boa experiência (UX).">Usar um cronômetro de 5 segundos</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Feedback para o usuário é essencial para uma boa experiência (UX).">Criar um estado booleano `isLoading` e exibi-lo enquanto a API não responde</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Feedback para o usuário é essencial para uma boa experiência (UX).">Pedir para o usuário clicar em "Refresh"</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Feedback para o usuário é essencial para uma boa experiência (UX).">Não precisa lidar, o React faz sozinho</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que acontece se você atualizar um estado dentro de um `useEffect` sem o array `[]`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Este é um dos erros mais comuns de iniciantes no React.">O estado não muda</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Este é um dos erros mais comuns de iniciantes no React.">Pode gerar um loop infinito (o efeito muda o estado, que re-renderiza, que roda o efeito...)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Este é um dos erros mais comuns de iniciantes no React.">O site fica mais rápido</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Este é um dos erros mais comuns de iniciantes no React.">O computador reinicia</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Onde devemos colocar a chamada `fetch` para que ela não rode milhares de vezes sem necessidade?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O useEffect isola a lógica de disparos de rede.">Fora do componente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O useEffect isola a lógica de disparos de rede.">No meio do JSX</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O useEffect isola a lógica de disparos de rede.">Dentro de um `useEffect` com dependências controladas</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O useEffect isola a lógica de disparos de rede.">Dentro do CSS</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Se quisermos limpar um timer ou fechar um socket quando o componente sumir da tela, onde fazemos isso?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O useEffect permite retornar uma função que o React chama ao "desmontar" o componente.">Em outro componente</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O useEffect permite retornar uma função que o React chama ao "desmontar" o componente.">No `useState`</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O useEffect permite retornar uma função que o React chama ao "desmontar" o componente.">Na função de "cleanup" retornada pelo `useEffect`</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O useEffect permite retornar uma função que o React chama ao "desmontar" o componente.">Deletando o arquivo</div>
  <div class="quiz-feedback"></div>
</div>
