# Quiz 13 - Estado e Reatividade (useState) 🎣

1. O que acontece quando o valor de um "State" muda no React?
    - [ ] O computador reinicia
    - [x] O React re-seta (redesenha) o componente na tela com os novos dados
    - [ ] O código Javascript é deletado
    - [ ] Nada, o desenvolvedor deve atualizar a tela manualmente
    *Explicação: A reatividade automática é um dos maiores poderes do React.*

2. Qual a forma correta de criar um estado para guardar um número?
    - [ ] let x = 0;
    - [ ] const x = 0;
    - [x] const [x, setX] = useState(0);
    - [ ] val x by state(0);
    *Explicação: Usamos o "Array Destructuring" para pegar a variável e a função disparadora.*

3. Por que não podemos fazer `contador = contador + 1` diretamente?
    - [ ] Porque gasta muita energia
    - [ ] Porque o Javascript proíbe
    - [x] Porque o React não ficará sabendo da mudança e não atualizará a tela
    - [ ] Porque isso apaga o banco de dados
    *Explicação: A função `set...` é quem avisa ao React que algo mudou.*

4. O que é um Hook?
    - [ ] Um erro CSS
    - [x] Uma função especial (como useState) que permite "enganchar" recursos do React em componentes de função
    - [ ] Um tipo de cabo USB
    - [ ] O vilão do Peter Pan
    *Explicação: Hooks revolucionaram o React, removendo a necessidade de usar "Classes" complexas.*

5. Qual o evento correto para detectar o clique em um botão no React?
    - [ ] onclick
    - [x] onClick (com o C maiúsculo)
    - [ ] click
    - [ ] on-press
    *Explicação: Eventos no React seguem o padrão CamelCase.*

6. Como você adiciona um novo elemento em um array de estado `lista` sem quebrar a imutabilidade?
    - [ ] lista.push(novo)
    - [ ] lista += novo
    - [x] setLista([...lista, novo])
    - [ ] setLista(novo)
    *Explicação: Usamos o "Spread Operator" (...) para criar uma cópia da lista original com o novo item.*

7. Em um "Input Controlado", quem manda no valor que aparece na caixinha de texto?
    - [ ] O usuário
    - [ ] O Teclado
    - [x] O Estado (State)
    - [ ] O CSS
    *Explicação: O valor do input é amarrado ao estado, garantindo que o JS tenha controle total do que é digitado.*

8. O que o parâmetro `e` em `onChange={(e) => ...}` representa?
    - [ ] Erro
    - [ ] Estilo
    - [x] O Objeto de Evento que contém dados como `target.value`
    - [ ] Email
    *Explicação: O evento contém todas as informações sobre a interação que acabou de acontecer.*

9. Qual o valor inicial de `cont` em `const [cont, setCont] = useState(10)`?
    - [ ] 0
    - [ ] null
    - [x] 10
    - [ ] undefined
    *Explicação: O valor dentro dos parênteses do useState define o ponto de partida.*

10. Se um componente pai muda seu estado, o que acontece com seus componentes filhos?
    - [ ] Eles param de funcionar
    - [x] Eles também são re-renderizados pelo React
    - [ ] Eles ficam travados
    - [ ] Eles mudam de cor sozinhos
    *Explicação: O fluxo de dados no React é descendente; se o pai muda, a árvore abaixo dele se atualiza.*
