## 🚀 Guia Didático: Seu Primeiro App Java Swing (Botão e Contador)

Este guia é uma **sequência didática** projetada para estudantes de computação. Vamos criar, do zero, uma janela com um botão e um texto. Cada clique no botão incrementará um número no texto.

### O que vamos usar?

  * **Java Swing:** É a biblioteca (parte do Java) para criar componentes visuais (janelas, botões, textos).
  * **`JFrame`:** A classe que representa a "janela" principal do nosso aplicativo.
  * **`JButton`:** A classe para o nosso botão clicável.
  * **`JLabel`:** A classe para exibir nosso texto (o contador).
  * **`ActionListener`:** A "mágica" que nos permite *ouvir* o clique do botão e executar um código.

-----

### Passo 1: O Esqueleto do Projeto (A Janela)

Tudo começa com uma janela. Em Swing, a janela principal é um `JFrame`. Vamos criar uma classe que *é* um `JFrame`.

**Arquivo:** `ContadorApp.java`

```java
import javax.swing.JFrame; // Importa a classe da janela

/**
 * Nossa classe principal.
 * Usar "extends JFrame" significa que nossa classe ContadorApp É uma janela.
 */
public class ContadorApp extends JFrame {

    // O "construtor": é o código que roda quando criamos um "new ContadorApp()"
    public ContadorApp() {
        // 1. Título da Janela
        setTitle("Meu Primeiro Contador Swing");

        // 2. Tamanho da Janela (Largura, Altura em pixels)
        setSize(300, 150);

        // 3. O que fazer quando o usuário clicar no "X" de fechar
        // JFrame.EXIT_ON_CLOSE = Terminar o programa.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. (Opcional, mas bom) Centralizar a janela na tela
        setLocationRelativeTo(null);
    }

    // O método main: o ponto de entrada do nosso programa
    public static void main(String[] args) {
        // Cria e exibe nossa janela
        ContadorApp minhaJanela = new ContadorApp();
        minhaJanela.setVisible(true); // <-- IMPORTANTE! Torna a janela visível.
    }
}
```

**➡️ O que fazer:** Salve este código como `ContadorApp.java`, compile e execute. Você deve ver uma janela vazia aparecer no centro da tela.

-----

### Passo 2: Adicionando os Componentes (Botão e Rótulo)

Agora, vamos adicionar as "peças" dentro da nossa janela.

1.  **Declarar as variáveis:** Precisamos que o botão e o rótulo sejam acessíveis em toda a classe.
2.  **Declarar o contador:** Precisamos de uma variável para guardar o número.
3.  **Inicializar os componentes:** No construtor, vamos criar os objetos.
4.  **Adicionar à janela:** Vamos dizer à janela para exibir esses componentes.

Vamos modificar nosso `ContadorApp.java`:

```java
// Importações necessárias
import javax.swing.JFrame;
import javax.swing.JButton; // Importa o botão
import javax.swing.JLabel;  // Importa o rótulo de texto
import java.awt.FlowLayout; // Importa o organizador de layout mais simples

/**
 * Nossa classe principal da janela
 */
public class ContadorApp extends JFrame {

    // --- Variáveis dos Componentes ---
    private JButton botaoClique;   // O botão
    private JLabel labelContador;  // O texto que mostrará o número

    // --- Variável de Estado ---
    private int contador; // O número que vamos incrementar

    // Construtor
    public ContadorApp() {
        // ... (configurações da janela do Passo 1) ...
        setTitle("Meu Primeiro Contador Swing");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Configurando o Layout ---
        // O FlowLayout organiza os componentes um ao lado do outro.
        setLayout(new FlowLayout());

        // --- Inicializando o Estado ---
        contador = 0; // Começamos em zero

        // --- Inicializando os Componentes ---
        botaoClique = new JButton("Clique em mim!");
        
        // O JLabel inicial mostra o contador no estado inicial
        labelContador = new JLabel("Contador: " + contador);

        // --- Adicionando os Componentes na Janela ---
        // A ordem importa no FlowLayout
        add(botaoClique);
        add(labelContador);
    }

    // ... (método main do Passo 1) ...
    public static void main(String[] args) {
        ContadorApp minhaJanela = new ContadorApp();
        minhaJanela.setVisible(true);
    }
}
```

**➡️ O que fazer:** Compile e execute novamente. Agora você verá a janela com um botão e um texto ("Contador: 0"). Clicar no botão ainda não faz nada.

-----

### Passo 3: A Lógica (Ouvindo o Clique)

Este é o passo mais importante: **event handling** (manipulação de eventos).

Queremos que um código seja executado *quando* o botão for clicado. Para isso, usamos um `ActionListener`.

1.  **Implementar a interface:** Dizemos que nossa classe `ContadorApp` *é* um "Ouvinte de Ações" (`implements ActionListener`).
2.  **Registrar o ouvinte:** Dizemos ao `botaoClique` que *esta classe* (`this`) deve ser notificada quando ele for clicado.
3.  **Escrever o código do evento:** Implementamos o método `actionPerformed`, que é chamado automaticamente no clique.

Vamos à alteração final do `ContadorApp.java`:

```java
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener; // Importa o "Ouvinte"
import java.awt.event.ActionEvent;   // Importa o "Evento" que o ouvinte recebe

/**
 * Nossa classe AGORA TAMBÉM é um Ouvinte de Ações (ActionListener)
 */
public class ContadorApp extends JFrame implements ActionListener {

    // ... (variáveis do Passo 2) ...
    private JButton botaoClique;
    private JLabel labelContador;
    private int contador;

    // Construtor
    public ContadorApp() {
        // ... (configurações da janela do Passo 1) ...
        setTitle("Meu Primeiro Contador Swing");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // ... (inicialização do Passo 2) ...
        contador = 0;
        botaoClique = new JButton("Clique em mim!");
        labelContador = new JLabel("Contador: " + contador);

        // --- Passo 3: REGISTRANDO O OUVINTE ---
        // Dizemos ao botão: "Ei, quando alguém clicar em você,
        // avise a ESTA classe (this) chamando o método actionPerformed."
        botaoClique.addActionListener(this);

        // ... (adicionando componentes do Passo 2) ...
        add(botaoClique);
        add(labelContador);
    }

    /**
     * Este método é OBRIGATÓRIO por causa do "implements ActionListener".
     * Ele é chamado automaticamente sempre que o "botaoClique" for pressionado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 1. Incrementa a variável
        contador++;
        
        // 2. Atualiza o texto do JLabel
        labelContador.setText("Contador: " + contador);
    }

    // ... (método main do Passo 1) ...
    // ATUALIZAÇÃO NO MAIN (BOA PRÁTICA)
    public static void main(String[] args) {
        // Interfaces gráficas em Swing devem ser criadas na "Event Dispatch Thread" (EDT)
        // Usar SwingUtilities.invokeLater garante isso.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ContadorApp minhaJanela = new ContadorApp();
                minhaJanela.setVisible(true);
            }
        });
    }
}
```

**➡️ O que fazer:** Compile e execute. Agora, cada vez que você clicar no botão, o número no `JLabel` será incrementado\!

-----

### 🎓 Dissecando o Código (Revisão Didática)

Vamos entender os conceitos-chave que você acabou de usar:

1.  **`import`:** Você está trazendo "caixas de ferramentas" (pacotes) para dentro do seu código. `javax.swing` é o pacote principal de Swing. `java.awt.event` é o pacote para eventos (como cliques).
2.  **`extends JFrame`:** Isso é **Herança**. Sua classe `ContadorApp` herda todas as características de uma `JFrame` (título, tamanho, botão de fechar, etc.).
3.  **`implements ActionListener`:** Isso é **Interface**. É um "contrato". Ao assinar (implementar) este contrato, sua classe *promete* que terá um método chamado `actionPerformed(ActionEvent e)`.
4.  **`private int contador;`:** Esta é a variável de **estado**. É a memória do seu aplicativo. Ela "lembra" qual é o número atual.
5.  **`botaoClique.addActionListener(this);`:** Este é o **Registro de Evento**. Você está conectando o *Componente* (o botão) ao *Ouvinte* (sua classe, representada por `this`).
6.  **`actionPerformed(ActionEvent e)`:** Este é o **Manipulador de Evento (Event Handler)**. É o coração da lógica. É o código que *reage* à ação do usuário.
7.  **`labelContador.setText(...)`:** Este é o **feedback visual**. Você está atualizando a interface gráfica para refletir a mudança no *estado* (a variável `contador`).
8.  **`SwingUtilities.invokeLater(...)`:** Esta é a regra de ouro do Swing. Garante que sua interface gráfica seja criada e atualizada na *thread* correta (a Event Dispatch Thread), evitando problemas de concorrência.

Você acabou de criar um aplicativo completo com interface gráfica, estado e manipulação de eventos, que são os três pilares de qualquer aplicação GUI.

-----

```java

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities; // Para a boa prática de inicialização
import java.awt.FlowLayout;        // Para organizar os componentes
import java.awt.event.ActionListener; // Interface para "ouvir" eventos
import java.awt.event.ActionEvent;   // Objeto do evento (o clique)

/**
 * Aplicação Java Swing completa com um botão de incremento e um rótulo (label)
 * que exibe a contagem.
 *
 * Esta classe funciona como:
 * 1. A Janela principal (pois "extends JFrame")
 * 2. O Ouvinte do clique do botão (pois "implements ActionListener")
 */
public class ContadorApp extends JFrame implements ActionListener {

    // --- 1. Declaração dos Componentes e Estado ---

    /** O botão que o usuário irá clicar. */
    private JButton botaoClique;

    /** O rótulo que exibirá o número do contador. */
    private JLabel labelContador;

    /** A variável que guarda o estado (o número atual) do contador. */
    private int contador;

    /**
     * Construtor da aplicação.
     * É aqui que configuramos a janela e inicializamos os componentes.
     */
    public ContadorApp() {
        // --- 2. Configuração da Janela (JFrame) ---

        // Define o título que aparece na barra da janela
        setTitle("Meu Primeiro Contador Swing");

        // Define o tamanho da janela em pixels (Largura, Altura)
        setSize(300, 150);

        // Define a ação padrão ao fechar a janela (terminar o programa)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Define o "organizador de layout". FlowLayout coloca os
        // componentes um ao lado do outro, da esquerda para a direita.
        setLayout(new FlowLayout());

        // --- 3. Inicialização do Estado e Componentes ---

        // O contador começa em 0
        contador = 0;

        // Cria o objeto JButton com o texto "Clique em mim!"
        botaoClique = new JButton("Clique em mim!");

        // Cria o objeto JLabel mostrando o valor inicial do contador
        labelContador = new JLabel("Contador: " + contador);

        // --- 4. Registro do Ouvinte (Event Handling) ---

        // Informa ao botão que *esta* classe (this) deve ser
        // notificada quando ele for clicado.
        botaoClique.addActionListener(this);

        // --- 5. Adição dos Componentes na Janela ---

        // Adiciona o botão ao painel de conteúdo da janela
        add(botaoClique);

        // Adiciona o rótulo ao painel de conteúdo da janela
        add(labelContador);
    }

    /**
     * Este é o método obrigatório da interface ActionListener.
     * Ele é chamado automaticamente pelo Swing toda vez que o
     * 'botaoClique' (que registramos) for pressionado.
     *
     * @param e O objeto ActionEvent que contém informações sobre o evento (o clique).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 1. Atualiza o estado: incrementa a variável
        contador++;
        
        // 2. Atualiza a interface: muda o texto do rótulo
        labelContador.setText("Contador: " + contador);
    }

    /**
     * Método principal (main) - O ponto de entrada do programa.
     */
    public static void main(String[] args) {
        // Boa prática do Swing:
        // Garante que a interface gráfica (GUI) seja criada e
        // executada na Thread de Despacho de Eventos (Event Dispatch Thread - EDT).
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Cria uma instância da nossa janela
                ContadorApp minhaJanela = new ContadorApp();
                
                // Torna a janela visível para o usuário
                minhaJanela.setVisible(true);
            }
        });
    }
}

```

-----

### [ricardotecpro.github.io](https://ricardotecpro.github.io/)
