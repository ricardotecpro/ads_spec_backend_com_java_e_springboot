# Quiz 04 - Documentação e Mocks 📝

1. O que é o OpenAPI (OAS)?
    - [ ] Uma linguagem de programação para backend
    - [x] Uma especificação padrão para descrever e documentar APIs RESTful
    - [ ] Um navegador web para desenvolvedores
    - [ ] Um banco de dados em nuvem
    *Explicação: O OpenAPI define um formato padrão para descrever recursos, rotas e respostas de uma API.*

2. Qual a principal diferença entre OpenAPI e Swagger?
    - [ ] Swagger é pago e OpenAPI é gratuito
    - [x] OpenAPI é a especificação e Swagger é o conjunto de ferramentas (UI, Editor, etc)
    - [ ] OpenAPI foi substituída pelo Swagger em 2021
    - [ ] Não há diferença, são nomes para a mesma cor
    *Explicação: Pense no OpenAPI como as "regras" e no Swagger como as "ferramentas" que usam essas regras.*

3. Para que serve o Swagger UI?
    - [ ] Para editar o banco de dados diretamente
    - [x] Para gerar uma página visual e interativa onde se pode testar os endpoints documentados
    - [ ] Para compilar o código Java para o servidor
    - [ ] Para baixar músicas gratuitas
    *Explicação: O Swagger UI lê o arquivo YAML/JSON e cria uma interface amigável para humanos.*

4. Qual o objetivo principal de um "Mock de API"?
    - [ ] Substituir o backup do sistema
    - [x] Simular o comportamento de uma API real para permitir o desenvolvimento paralelo
    - [ ] Aumentar a segurança contra vírus
    - [ ] Esconder o endereço IP do servidor
    *Explicação: Mocks permitem que o Frontend programe contra um servidor "de mentira" enquanto o real não está pronto.*

5. O que significa "Developer Experience" (DX)?
    - [ ] O tempo que o desenvolvedor gasta jogando videogame
    - [x] A facilidade e satisfação de um desenvolvedor ao usar sua ferramenta ou API
    - [ ] A quantidade de memória RAM do monitor
    - [ ] O nome do sistema operacional dos servidores
    *Explicação: Uma boa DX significa documentação clara, erros úteis e facilidade de integração.*

6. Qual formato de arquivo é mais utilizado para escrever especificações OpenAPI?
    - [ ] .html
    - [x] .yaml ou .json
    - [ ] .docx
    - [ ] .pdf
    *Explicação: YAML é preferido por ser mais legível por humanos e suportar identação clara.*

7. Por que retornar mensagens de erro explicativas no corpo da resposta (Body) é uma boa prática?
    - [ ] Para o log ficar mais colorido
    - [x] Para ajudar o consumidor da API a entender exatamente o que errou sem precisar perguntar ao autor
    - [ ] Porque o HTTP obriga a escrever textos longos
    - [ ] Para ocupar mais espaço no servidor
    *Explicação: Um erro `400` com a mensagem `"Data de nascimento é obrigatória"` economiza horas de suporte.*

8. Qual componente do Swagger permite digitar e validar a especificação da API em tempo real?
    - [ ] Swagger Hub
    - [x] Swagger Editor
    - [ ] Swagger Inspector
    - [ ] Swagger Play
    *Explicação: O Editor valida a sintaxe YAML e mostra o preview da documentação instantaneamente.*

9. Em qual fase do projeto o "Design de Contrato" deve ocorrer?
    - [ ] Somente no fim do projeto para arquivar
    - [x] No início, antes mesmo de começar a codificar as rotas (API First)
    - [ ] Apenas se o cliente pedir
    - [ ] Nunca, é perda de tempo
    *Explicação: No API First, o contrato é acordado primeiro para que as equipes de Front e Back trabalhem em sintaxe.*

10. Qual ferramenta pode ser usada para subir um mock server local a partir de uma collection?
    - [ ] Microsoft Excel
    - [x] Postman / Mockoon
    - [ ] Notepad++
    - [ ] Windows Paint
    *Explicação: Postman e Mockoon facilitam a criação de respostas estáticas baseadas em rotas.*
