# Quiz 14 - Efeitos e APIs (useEffect) 🌐

1. O que é um "Efeito Colateral" no React?
    - [ ] É um bug que trava o computador
    - [x] Uma ação que acontece fora do fluxo normal de renderizar a interface (ex: buscar dados, timers)
    - [ ] É o nome de uma biblioteca de animação
    - [ ] É quando o CSS muda a cor do botão
    *Explicação: Efeitos saem do campo puro de "desenhar componentes" e tocam o mundo externo.*

2. Qual o segundo parâmetro do `useEffect`?
    - [ ] Um número inteiro
    - [x] O array de dependências
    - [ ] O nome do componente
    - [ ] Um arquivo CSS
    *Explicação: Esse array decide quando o efeito deve ser re-executado.*

3. O que acontece se passarmos um array de dependências vazio `[]`?
    - [ ] O efeito nunca roda
    - [ ] O efeito roda em todo "re-render"
    - [x] O efeito roda apenas uma vez, quando o componente é montado (aparece na tela)
    - [ ] O app fecha com erro
    *Explicação: É o padrão usado para buscar dados iniciais de uma API.*

4. Como fazemos para que um efeito rode toda vez que o estado `tema` mudar?
    - [ ] useEffect(() => { ... })
    - [ ] useEffect(() => { ... }, [])
    - [x] useEffect(() => { ... }, [tema])
    - [ ] useEffect([tema], () => { ... })
    *Explicação: Incluir a variável no array obriga o React a monitorá-la.*

5. O que a função `fetch()` retorna?
    - [ ] O dado final em formato JSON
    - [x] Uma Promise (Promessa)
    - [ ] Um número de erro
    - [ ] Uma string de texto
    *Explicação: Chamadas de rede são assíncronas; o fetch promete que trará o dado no futuro.*

6. Para que serve o `.then(res => res.json())`?
    - [ ] Para salvar o dado no disco
    - [ ] Para fechar a conexão
    - [x] Para converter a resposta bruta da rede em um objeto Javascript que possamos usar
    - [ ] Para criptografar os dados
    *Explicação: A resposta inicial é um objeto de rede; precisamos extrair o corpo dela em JSON.*

7. Qual a maneira correta de lidar com o estado de "Carregando"?
    - [ ] Usar um cronômetro de 5 segundos
    - [x] Criar um estado booleano `isLoading` e exibi-lo enquanto a API não responde
    - [ ] Pedir para o usuário clicar em "Refresh"
    - [ ] Não precisa lidar, o React faz sozinho
    *Explicação: Feedback para o usuário é essencial para uma boa experiência (UX).*

8. O que acontece se você atualizar um estado dentro de um `useEffect` sem o array `[]`?
    - [ ] O estado não muda
    - [x] Pode gerar um loop infinito (o efeito muda o estado, que re-renderiza, que roda o efeito...)
    - [ ] O site fica mais rápido
    - [ ] O computador reinicia
    *Explicação: Este é um dos erros mais comuns de iniciantes no React.*

9. Onde devemos colocar a chamada `fetch` para que ela não rode milhares de vezes sem necessidade?
    - [ ] Fora do componente
    - [ ] No meio do JSX
    - [x] Dentro de um `useEffect` com dependências controladas
    - [ ] Dentro do CSS
    *Explicação: O useEffect isola a lógica de disparos de rede.*

10. Se quisermos limpar um timer ou fechar um socket quando o componente sumir da tela, onde fazemos isso?
    - [ ] Em outro componente
    - [ ] No `useState`
    - [x] Na função de "cleanup" retornada pelo `useEffect`
    - [ ] Deletando o arquivo
    *Explicação: O useEffect permite retornar uma função que o React chama ao "desmontar" o componente.*
