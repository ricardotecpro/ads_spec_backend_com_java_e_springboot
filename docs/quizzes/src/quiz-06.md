# Quiz 06 - Services e Regras de Negócio 🧠

1. O que acontece se colocarmos toda a lógica de negócio dentro do Controller?
    - [ ] O app fica mais rápido
    - [x] O código fica difícil de testar, manter e reutilizar (o famoso "Controller Gordo")
    - [ ] O banco de dados se apaga sozinho
    - [ ] O roteamento para de funcionar
    *Explicação: Acoplar lógica de negócio ao transporte HTTP cria dívida técnica e dificulta a evolução do sistema.*

2. Qual a principal responsabilidade do Service?
    - [ ] Definir as rotas do app
    - [x] Executar as regras de negócio, validações e cálculos
    - [ ] Gerar as respostas JSON para o cliente
    - [ ] Configurar a porta do servidor
    *Explicação: O Service é onde o conhecimento do domínio da aplicação (as regras do "negócio") reside.*

3. Como um Service deve notificar o Controller sobre uma falha de validação?
    - [ ] Retornando um número 400
    - [x] Lançando uma exceção ou erro (throw Error)
    - [ ] Enviando um e-mail para o administrador
    - [ ] Mudando a cor do console
    *Explicação: O lançamento de erros permite que o Controller capture o fluxo e decida qual resposta HTTP enviar.*

4. Por que o Service não deve acessar os objetos `req` ou `res`?
    - [ ] Porque eles são secretos
    - [x] Para manter o Service independente do protocolo de transporte (podendo ser usado em gRPC, CLI, etc)
    - [ ] Porque isso gasta muita internet
    - [ ] Para economizar linhas de código
    *Explicação: A camada de serviço deve ser "cega" para o transporte, focando apenas nos dados e regras.*

5. O que define uma "Regra de Negócio"?
    - [ ] O nome das variáveis do sistema
    - [x] As diretrizes que ditam como o serviço deve operar (ex: "só maiores de 18 podem comprar")
    - [ ] O tipo de servidor onde o app está rodando
    - [ ] A cor do logotipo da empresa
    *Explicação: Regras de negócio são as "leis" do funcionamento daquela aplicação específica.*

6. Qual a vantagem de reutilizar um Service em diferentes Controllers?
    - [ ] Nenhuma, é melhor copiar o código
    - [x] Consistência: a regra é aplicada da mesma forma em todo o sistema
    - [ ] Economiza espaço de memória no disco
    - [ ] Deixa o site mais colorido
    *Explicação: Centralizar a regra no Service garante que, se a lei mudar, você só precisa alterar em um lugar.*

7. O que é um DTO (Data Transfer Object)?
    - [ ] Um tipo de cabo para conectar servidores
    - [x] Um objeto simples usado para transportar dados entre camadas sem expor a lógica interna
    - [ ] O nome do motor de busca do Google
    - [ ] Um comando do terminal Linux
    *Explicação: DTOs ajudam a filtrar campos sensíveis (como senhas) antes de enviá-los ao mundo externo.*

8. O que significa "Separation of Concerns" (Separação de Preocupações)?
    - [ ] Cada desenvolvedor deve trabalhar sozinho
    - [x] Cada camada do sistema deve ter uma responsabilidade única e bem definida
    - [ ] O banco de dados deve ficar em outro país
    - [ ] O site deve ter várias cores diferentes
    *Explicação: Dividir o sistema em Controller, Service e Repository é aplicar esse princípio fundamental.*

9. Qual o momento ideal para chamar o Service dentro de uma rota?
    - [ ] Antes de receber a requisição
    - [x] Após o Controller validar os parâmetros básicos de entrada
    - [ ] Depois que a resposta já foi enviada ao cliente
    - [ ] Nunca, o Controller deve fazer tudo
    *Explicação: O Controller "limpa" a entrada e passa os dados "puros" para o Service processar.*

10. Como o Controller deve tratar o retorno de um Service?
    - [ ] Ignorando o resultado
    - [x] Capturando o dado retornado e devolvendo em um JSON com Status 200/201
    - [ ] Pedindo para o usuário reiniciar o computador
    - [ ] Exibindo o código fonte na tela
    *Explicação: O Controller é o tradutor final que comunica o sucesso ou erro do Service para o cliente HTTP.*
