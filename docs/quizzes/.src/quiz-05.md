# Quiz - Aula 05 ❓

1. **Uma classe abstrata pode ter objetos criados diretamente (`new`)?**
   - (A) Sim.
   - (B) Não.
   - (C) Apenas se todos os métodos forem públicos.
   - (D) Sim, em domingos e feriados.
   *Resposta: (B)* - Classes abstratas servem apenas como base.

2. **Um método abstrato é aquele que:**
   - (A) Tem muito código.
   - (B) Não possui corpo (implementação) e deve ser sobre-escrito pelos filhos.
   - (C) É invisível para os filhos.
   - (D) Só roda em servidores.
   *Resposta: (B)* - Ele define apenas a assinatura (nome, retorno e parâmetros).

3. **Qual palavra-chave é usada para implementar uma interface?**
   - (A) extends
   - (B) implements
   - (C) uses
   - (D) include
   *Resposta: (B)* - 'implements' indica que a classe cumprirá o contrato.

4. **Diferente de classes, uma classe Java pode implementar:**
   - (A) Nenhuma interface.
   - (B) Apenas uma interface.
   - (C) Múltiplas interfaces (sem limite).
   - (D) Apenas interfaces privadas.
   *Resposta: (C)* - Isso permite que uma classe tenha múltiplos comportamentos.

5. **Interfaces podem conter variáveis que mudam de valor?**
   - (A) Sim.
   - (B) Não, apenas constantes (public static final).
   - (C) Apenas se forem strings.
   - (D) Apenas se o banco de dados permitir.
   *Resposta: (B)* - Interfaces definem o "que", não o estado variável.

6. **Se uma classe herda de uma Classe Abstrata, ela é obrigada a:**
   - (A) Deletar todos os métodos.
   - (B) Implementar todos os métodos abstratos (ou também ser abstrata).
   - (C) Mudar de nome.
   - (D) Criar um novo arquivo.
   *Resposta: (B)* - É uma obrigatoriedade do compilador.

7. **Qual o símbolo Mermaid para uma interface?**
   - (A) <<abstract>>
   - (B) <<interface>>
   - (C) [Interface]
   - (D) {Interface}
   *Resposta: (B)* - Usamos estereótipos no classDiagram.

8. **Abstração serve para:**
   - (A) Complicar o sistema.
   - (B) Focar no essencial e esconder a complexidade desnecessária.
   - (C) Usar mais memória RAM.
   - (D) Diminuir o brilho da tela.
   *Resposta: (B)* - É um pilar fundamental da POO.

9. **Podemos ter métodos comuns (com código) dentro de uma Classe Abstrata?**
   - (A) Sim.
   - (B) Não.
   - (C) Apenas se forem estáticos.
   - (D) Apenas se não houver herança.
   *Resposta: (A)* - Esta é uma das diferenças em relação às Interfaces clássicas.

10. **Uma interface é ideal para:**
    - (A) Guardar dados de usuários.
    - (B) Definir comportamentos comuns a classes não relacionadas hierarquicamente.
    - (C) Criar janelas desktop.
    - (D) Configurar o driver de vídeo.
    *Resposta: (B)* - Ex: `Imprimivel`, `Serializavel`.
