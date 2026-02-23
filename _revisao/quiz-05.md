# Quiz 05 - Implementação de APIs ⚙️

1. Qual a principal responsabilidade da camada de Controller?
    - [ ] Salvar dados no banco de dados
    - [x] Gerenciar a requisição HTTP e retornar a resposta adequada
    - [ ] Fazer cálculos complexos de impostos
    - [ ] Criar a interface gráfica do usuário
    *Explicação: O Controller age como um intermediário entre o mundo externo (HTTP) e a lógica interna do sistema.*

2. O que é um "Handler" em um sistema de rotas?
    - [ ] Um tipo de vírus de computador
    - [x] A função específica que é executada quando uma rota é chamada
    - [ ] O nome do servidor de hospedagem
    - [ ] O arquivo onde guardamos as senhas
    *Explicação: Cada rota (Verbo + Path) é mapeada para um Handler que processa aquela ação específica.*

3. Qual a melhor forma de capturar o ID de um usuário para uma busca individual (ex: /usuarios/10)?
    - [ ] Query Param (?id=10)
    - [x] Path Param (/usuarios/:id)
    - [ ] Request Body ({ "id": 10 })
    - [ ] Através de um cookie
    *Explicação: Path Params são ideais para identificar recursos de forma única e hierárquica na URI.*

4. Quando devemos usar "Query Params"?
    - [ ] Para enviar a senha do usuário
    - [x] Para filtros, ordenação e paginação (ex: ?cor=azul)
    - [ ] Para atualizar o nome de um produto
    - [ ] Para deletar o banco de dados
    *Explicação: Query Params são usados para modificar ou filtrar a representação dos dados retornados.*

5. Em qual objeto da requisição costuma vir o JSON enviado via POST?
    - [ ] req.params
    - [ ] req.query
    - [x] req.body
    - [ ] req.headers
    *Explicação: O Body é a parte da mensagem HTTP reservada para o transporte de dados complexos e volumosos.*

6. Qual analogia melhor define o papel do Controller?
    - [ ] O cozinheiro que prepara o prato
    - [x] O garçom que anota o pedido e entrega o prato
    - [ ] O dono do restaurante que cuida do banco de dados
    - [ ] O cliente que come a comida
    *Explicação: O Controller apenas coordena a entrada e a saída, delegando a "preparação" para outras camadas.*

7. Por que a Injeção de Dependência é útil nos Controllers?
    - [ ] Para o código ficar mais pesado e seguro
    - [x] Para facilitar a troca de comportamentos e a criação de testes automatizados
    - [ ] Para economizar espaço no HD
    - [ ] Porque o Google obriga
    *Explicação: Receber dependências prontas torna o Controller menos acoplado e mais fácil de manter.*

8. O que acontece se o Controller não retornar um Status Code?
    - [ ] O servidor explode
    - [x] O cliente pode receber um status padrão (ex: 200) que não condiz com o resultado real
    - [ ] O computador trava
    - [ ] A internet cai
    *Explicação: É vital ser explícito sobre o que aconteceu (201 para sucesso, 400 para erro, etc).*

9. Onde configuramos o mapeamento de Verbo + Path no backend?
    - [ ] No banco de dados
    - [x] No arquivo de roteamento (Router)
    - [ ] No arquivo de interface (CSS)
    - [ ] Dentro do arquivo de imagem .png
    *Explicação: O roteador é quem diz: "Se chegar esse verbo nesse caminho, chame essa função".*

10. Qual a vantagem de padronizar as respostas de erro em JSON?
    - [ ] Para o erro ficar mais bonito
    - [x] Para que o frontend consiga ler a mensagem e exibir um alerta amigável ao usuário
    - [ ] Para economizar bateria do servidor
    - [ ] Para esconder o código do erro
    *Explicação: Um JSON de erro estruturado permite que o app reaja de forma inteligente a falhas.*