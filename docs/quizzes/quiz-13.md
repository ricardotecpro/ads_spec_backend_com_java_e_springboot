# Quiz 13 - Estado e Reatividade (useState) 🎣

--8<-- "assets/quiz.html"

<div class="quiz-container">
  <div class="quiz-question">1. O que acontece quando o valor de um "State" muda no React?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A reatividade automática é um dos maiores poderes do React.">O computador reinicia</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! A reatividade automática é um dos maiores poderes do React.">O React re-seta (redesenha) o componente na tela com os novos dados</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A reatividade automática é um dos maiores poderes do React.">O código Javascript é deletado</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A reatividade automática é um dos maiores poderes do React.">Nada, o desenvolvedor deve atualizar a tela manualmente</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">2. Qual a forma correta de criar um estado para guardar um número?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Usamos o "Array Destructuring" para pegar a variável e a função disparadora.">let x = 0;</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Usamos o "Array Destructuring" para pegar a variável e a função disparadora.">const x = 0;</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Usamos o "Array Destructuring" para pegar a variável e a função disparadora.">const [x, setX] = useState(0);</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Usamos o "Array Destructuring" para pegar a variável e a função disparadora.">val x by state(0);</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">3. Por que não podemos fazer `contador = contador + 1` diretamente?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A função `set...` é quem avisa ao React que algo mudou.">Porque gasta muita energia</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A função `set...` é quem avisa ao React que algo mudou.">Porque o Javascript proíbe</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! A função `set...` é quem avisa ao React que algo mudou.">Porque o React não ficará sabendo da mudança e não atualizará a tela</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. A função `set...` é quem avisa ao React que algo mudou.">Porque isso apaga o banco de dados</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">4. O que é um Hook?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Hooks revolucionaram o React, removendo a necessidade de usar "Classes" complexas.">Um erro CSS</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Hooks revolucionaram o React, removendo a necessidade de usar "Classes" complexas.">Uma função especial (como useState) que permite "enganchar" recursos do React em componentes de função</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Hooks revolucionaram o React, removendo a necessidade de usar "Classes" complexas.">Um tipo de cabo USB</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Hooks revolucionaram o React, removendo a necessidade de usar "Classes" complexas.">O vilão do Peter Pan</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">5. Qual o evento correto para detectar o clique em um botão no React?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Eventos no React seguem o padrão CamelCase.">onclick</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Eventos no React seguem o padrão CamelCase.">onClick (com o C maiúsculo)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Eventos no React seguem o padrão CamelCase.">click</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Eventos no React seguem o padrão CamelCase.">on-press</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">6. Como você adiciona um novo elemento em um array de estado `lista` sem quebrar a imutabilidade?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Usamos o "Spread Operator" (...) para criar uma cópia da lista original com o novo item.">lista.push(novo)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Usamos o "Spread Operator" (...) para criar uma cópia da lista original com o novo item.">lista += novo</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! Usamos o "Spread Operator" (...) para criar uma cópia da lista original com o novo item.">setLista([...lista, novo])</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. Usamos o "Spread Operator" (...) para criar uma cópia da lista original com o novo item.">setLista(novo)</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">7. Em um "Input Controlado", quem manda no valor que aparece na caixinha de texto?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O valor do input é amarrado ao estado, garantindo que o JS tenha controle total do que é digitado.">O usuário</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O valor do input é amarrado ao estado, garantindo que o JS tenha controle total do que é digitado.">O Teclado</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O valor do input é amarrado ao estado, garantindo que o JS tenha controle total do que é digitado.">O Estado (State)</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O valor do input é amarrado ao estado, garantindo que o JS tenha controle total do que é digitado.">O CSS</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">8. O que o parâmetro `e` em `onChange={(e) => ...}` representa?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O evento contém todas as informações sobre a interação que acabou de acontecer.">Erro</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O evento contém todas as informações sobre a interação que acabou de acontecer.">Estilo</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O evento contém todas as informações sobre a interação que acabou de acontecer.">O Objeto de Evento que contém dados como `target.value`</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O evento contém todas as informações sobre a interação que acabou de acontecer.">Email</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">9. Qual o valor inicial de `cont` em `const [cont, setCont] = useState(10)`?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O valor dentro dos parênteses do useState define o ponto de partida.">0</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O valor dentro dos parênteses do useState define o ponto de partida.">null</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O valor dentro dos parênteses do useState define o ponto de partida.">10</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O valor dentro dos parênteses do useState define o ponto de partida.">undefined</div>
  <div class="quiz-feedback"></div>
</div>

<div class="quiz-container">
  <div class="quiz-question">10. Se um componente pai muda seu estado, o que acontece com seus componentes filhos?</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O fluxo de dados no React é descendente; se o pai muda, a árvore abaixo dele se atualiza.">Eles param de funcionar</div>
  <div class="quiz-option" data-correct="true" data-feedback="✅ Correto! O fluxo de dados no React é descendente; se o pai muda, a árvore abaixo dele se atualiza.">Eles também são re-renderizados pelo React</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O fluxo de dados no React é descendente; se o pai muda, a árvore abaixo dele se atualiza.">Eles ficam travados</div>
  <div class="quiz-option" data-correct="false" data-feedback="❌ Incorreto. O fluxo de dados no React é descendente; se o pai muda, a árvore abaixo dele se atualiza.">Eles mudam de cor sozinhos</div>
  <div class="quiz-feedback"></div>
</div>
