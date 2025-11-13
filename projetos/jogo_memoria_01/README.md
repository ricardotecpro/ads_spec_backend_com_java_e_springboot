# Primeiro jogo gráfico em Java: o **Jogo da Memória**.

Vamos arregaçar as mangas e construir juntos, passo a passo, o seu primeiro jogo gráfico em Java: o **Jogo da Memória**.

Meu objetivo aqui é focar 100% na **lógica** e em como "conversar" com a interface gráfica usando o **Swing**. Não vamos nos preocupar com arquiteturas complexas ou bibliotecas externas. Apenas Java puro (JDK) e Swing.

-----

### ✅ Etapa 1 e 2: Criando o Projeto e a Janela (JFrame)

Qualquer aplicação gráfica em Swing começa com uma "janela". Em Java, essa janela principal é chamada de `JFrame`. Pense nela como a moldura de um quadro.

**O que vamos fazer:**

1.  Criar um novo projeto Java na sua IDE (Eclipse, IntelliJ, NetBeans).
2.  Criar uma classe chamada `JogoDaMemoria`.
3.  Fazer essa classe "ser" uma janela (usando `extends JFrame`).
4.  Configurar o básico: título, tamanho e o que fazer ao clicar no "X" (fechar).

**Código (JogoDaMemoria.java):**

```java
import javax.swing.JFrame; // Importa a classe da janela

// Nossa classe AGORA É UMA Janela, pois "herda" tudo de JFrame
public class JogoDaMemoria extends JFrame {

    // Este é o "construtor". É o código que executa quando 
    // criamos um "new JogoDaMemoria()"
    public JogoDaMemoria() {
        // 1. Configurações básicas da janela
        setTitle("Jogo da Memória"); // Define o título
        setSize(400, 400); // Define o tamanho (largura, altura)
        
        // Isso é MUITO importante: define que o programa fecha ao clicar no "X"
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        // Centraliza a janela na tela
        setLocationRelativeTo(null); 
        
        // Torna a janela visível
        setVisible(true); 
    }

    // O método "main" é o ponto de partida de qualquer programa Java
    public static void main(String[] args) {
        // Cria uma nova instância do nosso jogo
        new JogoDaMemoria();
    }
}
```

**Para testar:** Rode esse código. Você verá uma janela vazia de 400x400 pixels no centro da tela.

-----

### ✅ Etapa 3: Criando o Tabuleiro (JPanel e GridLayout)

Agora que temos a "moldura" (`JFrame`), precisamos do "quadro" ou "tabuleiro" onde as cartas ficarão. Para isso, usamos o `JPanel`.

**O que vamos fazer:**

1.  Criar um `JPanel`, que será nosso tabuleiro.
2.  Definir como as cartas serão organizadas. Queremos uma grade (linhas e colunas), certo? Para isso, usamos o `GridLayout`.
3.  Adicionar o painel (tabuleiro) dentro da janela (moldura).

**Código (Atualizando JogoDaMemoria.java):**

```java
import javax.swing.JFrame;
import javax.swing.JPanel; // Importa o painel
import java.awt.GridLayout; // Importa o layout de grade

public class JogoDaMemoria extends JFrame {

    // Precisamos de uma referência ao painel para adicionar botões depois
    private JPanel painelPrincipal; 

    public JogoDaMemoria() {
        setTitle("Jogo da Memória");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Novidades Aqui ---
        
        // 1. Cria o painel (tabuleiro)
        painelPrincipal = new JPanel();

        // 2. Define o layout como uma grade 4x4
        // Isso significa 4 linhas e 4 colunas, para um total de 16 cartas.
        painelPrincipal.setLayout(new GridLayout(4, 4)); 

        // 3. Adiciona o painel (tabuleiro) à janela (moldura)
        add(painelPrincipal); 

        // (O setVisible(true) agora vai para o final, 
        //  depois que adicionarmos tudo)
        // setVisible(true); // <<-- Movido para o final do construtor
    }
    
    // ... (método main continua igual) ...
    
    // (Vamos mover o setVisible(true) para o main, 
    //  é uma prática melhor para evitar problemas de "renderização")
    
    public static void main(String[] args) {
        // Boa prática: Garante que a interface rode na thread correta
        javax.swing.SwingUtilities.invokeLater(() -> {
            JogoDaMemoria jogo = new JogoDaMemoria();
            jogo.setVisible(true); // Torna visível DEPOIS de criar
        });
    }
}
```

**Para testar:** Rode de novo. A janela parecerá a mesma, mas agora ela contém um painel invisível pronto para receber nossas cartas (botões).

-----

### ✅ Etapa 4: Adicionando e Embaralhando as Cartas

As "cartas" serão botões (`JButton`). Para um jogo 4x4 (16 cartas), precisamos de 8 pares de valores (ex: 1, 1, 2, 2, ... 8, 8).

**O que vamos fazer:**

1.  Criar uma lista (`ArrayList`) com os valores das cartas (os 8 pares).
2.  Embaralhar essa lista usando `Collections.shuffle()`.
3.  Criar os 16 botões (`JButton`).
4.  Associar cada botão a um valor da lista embaralhada (mas sem mostrar o valor ainda\!).
5.  Adicionar os botões ao `painelPrincipal`.

**Código (Atualizando JogoDaMemoria.java):**

```java
// ... (imports) ...
import javax.swing.JButton; // Importa o botão
import java.util.ArrayList; // Importa a lista
import java.util.Collections; // Importa o "embaralhador"

public class JogoDaMemoria extends JFrame {

    private JPanel painelPrincipal;
    // Lista para guardar os 16 botões
    private ArrayList<JButton> botoes = new ArrayList<>(); 
    // Lista para guardar os 8 pares de valores (ex: "1", "1", "2", "2"...)
    private ArrayList<String> valores = new ArrayList<>();

    public JogoDaMemoria() {
        // ... (configuração da janela e painel) ...
        
        // --- Novidades Aqui ---
        
        // 1. Criar os valores das cartas (8 pares)
        for (int i = 1; i <= 8; i++) {
            valores.add(String.valueOf(i)); // Adiciona o número
            valores.add(String.valueOf(i)); // Adiciona seu par
        }

        // 2. Embaralhar os valores
        Collections.shuffle(valores);

        // 3. Criar e adicionar os botões
        for (int i = 0; i < 16; i++) {
            // Cria um novo botão
            JButton botao = new JButton();
            
            // Definimos um "nome" (ID) para o botão, que é o valor
            // que ele esconde. O usuário não vê isso.
            botao.setName(valores.get(i)); 
            
            // Texto inicial (carta virada para baixo)
            botao.setText("?"); 
            
            // Adiciona o botão ao array de botões
            botoes.add(botao); 
            
            // Adiciona o botão ao painel (tabuleiro)
            painelPrincipal.add(botao); 
        }

        add(painelPrincipal);
    }

    // ... (método main) ...
}
```

**Para testar:** Rode agora. Você verá uma grade 4x4 de botões, todos com um "?"\!

-----

### ✅ Etapa 5: A Lógica do Jogo (O Clique e a Verificação)

Esta é a parte mais importante\! Precisamos "ouvir" quando o jogador clica em um botão. Em Java, isso se chama `ActionListener`.

**O que vamos fazer:**

1.  Adicionar um "ouvinte de clique" (`ActionListener`) a CADA botão.
2.  Controlar a lógica da jogada. Precisamos saber qual foi a 1ª carta e qual foi a 2ª.
3.  **Variáveis de estado:** Vamos precisar de variáveis para guardar o `primeiroBotao` clicado e o `segundoBotao` clicado.
4.  **A Lógica do Clique:**
      * Se for o 1º clique: "Vira" a carta (mostra o valor) e armazena qual botão foi.
      * Se for o 2º clique: "Vira" a carta e compara com a 1ª.
      * **Se combinam:** Deixa as cartas abertas (desabilitando os botões).
      * **Se não combinam:** Espera 1 segundo e "vira" as duas de volta.

**O Desafio do "Esperar 1 Segundo":**
Não podemos simplesmente pausar o programa, pois isso congelaria a interface. Temos que usar um `Timer` do próprio Swing, que agenda uma tarefa para rodar *depois* de um tempo, sem travar o jogo.

**Código (Atualizando JogoDaMemoria.java):**

```java
// ... (imports) ...
import java.awt.event.ActionEvent; // Para "ouvir" o evento de clique
import java.awt.event.ActionListener; // A interface do "ouvinte"
import javax.swing.Timer; // O Timer para o atraso!

// Nossa classe agora "implementa" um ouvinte
public class JogoDaMemoria extends JFrame implements ActionListener {

    // ... (variáveis painelPrincipal, botoes, valores) ...

    // --- Variáveis de Controle do Jogo ---
    private JButton primeiroBotao = null;
    private JButton segundoBotao = null;
    private int paresEncontrados = 0;

    public JogoDaMemoria() {
        // ... (configuração da janela, painel, criação dos valores) ...
        
        // ... (loop de criação dos botões) ...
        for (int i = 0; i < 16; i++) {
            JButton botao = new JButton();
            botao.setName(valores.get(i)); // O valor escondido
            botao.setText("?");
            
            // *** NOVIDADE: Adiciona o "ouvinte" ao botão ***
            // "this" significa que o método "actionPerformed"
            // DESTA PRÓPRIA CLASSE será chamado quando o botão for clicado.
            botao.addActionListener(this); 
            
            botoes.add(botao);
            painelPrincipal.add(botao);
        }

        add(painelPrincipal);
    }

    // --- Este é o "Cérebro" do Jogo ---
    // Este método é chamado AUTOMATICAMENTE sempre que 
    // QUALQUER botão (que registramos) for clicado.
    @Override
    public void actionPerformed(ActionEvent e) {
        // 1. Descobre qual botão foi clicado
        JButton botaoClicado = (JButton) e.getSource();

        // Regra 1: Não fazer nada se já for o 1º ou 2º botão
        if (botaoClicado == primeiroBotao || botaoClicado == segundoBotao) {
            return; 
        }

        // Regra 2: Não fazer nada se o botão já foi encontrado (desabilitado)
        if (!botaoClicado.isEnabled()) {
            return;
        }

        // 2. Revela o valor do botão (pega do "name" que definimos)
        botaoClicado.setText(botaoClicado.getName());

        // 3. Lógica da Jogada
        if (primeiroBotao == null) {
            // Se for o PRIMEIRO clique da rodada
            primeiroBotao = botaoClicado;
        } else {
            // Se for o SEGUNDO clique da rodada
            segundoBotao = botaoClicado;
            
            // Inicia a verificação
            verificarPares();
        }
    }

    // Método auxiliar para verificar se as duas cartas são iguais
    private void verificarPares() {
        // Pega o valor (texto) dos dois botões
        String valor1 = primeiroBotao.getName();
        String valor2 = segundoBotao.getName();

        if (valor1.equals(valor2)) {
            // --- ACERTOU ---
            primeiroBotao.setEnabled(false); // Desabilita o 1º
            segundoBotao.setEnabled(false); // Desabilita o 2º
            
            paresEncontrados++; // Incrementa o contador de pares

            // Limpa os botões da rodada
            resetarSelecao();
            
            // Verifica se o jogo acabou
            if (paresEncontrados == 8) {
                finalizarJogo();
            }
            
        } else {
            // --- ERROU ---
            // Aqui usamos o Timer para dar 1 segundo (1000 ms) 
            // antes de virar as cartas de volta.
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    primeiroBotao.setText("?");
                    segundoBotao.setText("?");
                    
                    // Limpa os botões da rodada
                    resetarSelecao();
                }
            });
            timer.setRepeats(false); // Para o timer rodar só uma vez
            timer.start();
        }
    }
    
    // Método auxiliar para "limpar" a jogada
    private void resetarSelecao() {
        primeiroBotao = null;
        segundoBotao = null;
    }

    // ... (método main) ...
}
```

**Para testar:** Rode o jogo\! Você já pode clicar. Tente acertar e errar. Veja o *delay* de 1 segundo funcionando quando você erra.

-----

### ✅ Etapa 6: Finalizar e Reiniciar o Jogo

O jogo precisa avisar que acabou e, idealmente, permitir um reinício.

**O que vamos fazer:**

1.  Mostrar uma mensagem de "Parabéns\!" quando `paresEncontrados` chegar a 8 (já estamos chamando `finalizarJogo()` no código acima).
2.  Usar um `JOptionPane` (uma caixa de diálogo) para isso.
3.  Perguntar se o jogador quer reiniciar.
4.  Se sim, vamos "resetar" o estado do jogo.

**Código (Atualizando JogoDaMemoria.java):**

```java
// ... (imports) ...
import javax.swing.JOptionPane; // Importa a caixa de diálogo

public class JogoDaMemoria extends JFrame implements ActionListener {
    
    // ... (todas as variáveis e métodos anteriores) ...

    // Método chamado quando paresEncontrados == 8
    private void finalizarJogo() {
        // Mostra uma caixa de diálogo
        int resposta = JOptionPane.showConfirmDialog(this, 
                "Parabéns! Você encontrou todos os pares!\nDeseja jogar novamente?", 
                "Fim de Jogo", 
                JOptionPane.YES_NO_OPTION); // Botões de Sim ou Não

        if (resposta == JOptionPane.YES_OPTION) {
            reiniciarJogo();
        } else {
            System.exit(0); // Fecha o programa
        }
    }

    // Método para reiniciar o jogo
    private void reiniciarJogo() {
        // 1. Resetar contadores
        paresEncontrados = 0;
        resetarSelecao();

        // 2. Re-embaralhar os valores
        Collections.shuffle(valores);

        // 3. Resetar todos os botões (texto e valor)
        for (int i = 0; i < 16; i++) {
            JButton botao = botoes.get(i);
            botao.setText("?");
            botao.setName(valores.get(i)); // Atribui o novo valor embaralhado
            botao.setEnabled(true); // Re-habilita o botão
        }
    }
    
    // ... (método main) ...
}
```

-----

### ✅ Etapa 7: O Código Completo e Como Testar

Aqui está o código-fonte completo em um único arquivo `JogoDaMemoria.java`.

**Como Executar:**

1.  Salve este código como `JogoDaMemoria.java`.
2.  Compile-o (se estiver usando a linha de comando: `javac JogoDaMemoria.java`).
3.  Execute-o (se estiver usando a linha de comando: `java JogoDaMemoria`).
4.  Se estiver em uma IDE (IntelliJ, Eclipse, NetBeans), apenas clique no botão "Run" (▶).

**Código-Fonte Completo e Comentado:**

```java
/**
 * Jogo da Memória Simples em Java Swing
 * Foco: Lógica de Programação, Swing Básico, Eventos (ActionListener) e Timer.
 * Professor: (Seu Professor Experiente de Java)
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer; // Importante: use o timer do SWING
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Nossa classe principal do Jogo.
 * Ela é (extends) uma Janela (JFrame) e
 * ela "ouve" (implements) os cliques (ActionListener).
 */
public class JogoDaMemoria extends JFrame implements ActionListener {

    // Componentes Gráficos
    private JPanel painelPrincipal; // O "tabuleiro" onde os botões ficam
    
    // Lista dos botões (que são nossas "cartas")
    private ArrayList<JButton> botoes = new ArrayList<>(); 
    
    // Lista dos valores (os números "1" a "8", duplicados)
    private ArrayList<String> valores = new ArrayList<>();

    // --- Variáveis de Controle da Lógica do Jogo ---
    
    // Guarda o primeiro botão clicado na rodada
    private JButton primeiroBotao = null; 
    // Guarda o segundo botão clicado na rodada
    private JButton segundoBotao = null; 
    
    // Contador de quantos pares já foram encontrados
    private int paresEncontrados = 0;

    /**
     * Construtor: Onde o jogo é montado.
     */
    public JogoDaMemoria() {
        // 1. Configuração da Janela (JFrame)
        setTitle("Jogo da Memória");
        setSize(500, 500); // Um pouco maior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no "X"
        setLocationRelativeTo(null); // Centraliza na tela

        // 2. Configuração do Painel (JPanel) e Layout
        painelPrincipal = new JPanel();
        // Define o layout como uma grade 4x4
        painelPrincipal.setLayout(new GridLayout(4, 4, 5, 5)); // (4, 4, hgap, vgap)

        // 3. Preparação das Cartas (Lógica)
        // Adiciona 8 pares de números (de "1" a "8")
        for (int i = 1; i <= 8; i++) {
            valores.add(String.valueOf(i));
            valores.add(String.valueOf(i));
        }

        // Embaralha a lista de valores
        Collections.shuffle(valores);

        // 4. Criação dos Botões (Cartas)
        for (int i = 0; i < 16; i++) {
            JButton botao = new JButton();
            
            // O "name" guarda o valor real (escondido) da carta
            botao.setName(valores.get(i)); 
            
            // O "text" é o que o usuário vê (a carta "virada")
            botao.setText("?"); 
            
            // Adiciona o "ouvinte de clique" (ActionListener)
            // "this" significa que o método "actionPerformed" DESTA CLASSE
            // será chamado quando o botão for clicado.
            botao.addActionListener(this);
            
            botoes.add(botao); // Guarda o botão na lista
            painelPrincipal.add(botao); // Adiciona o botão ao tabuleiro
        }

        // 5. Adiciona o painel principal (tabuleiro) à janela
        add(painelPrincipal);
    }

    /**
     * O "Cérebro" do Jogo.
     * Este método é chamado automaticamente sempre que um botão é clicado.
     * @param e O evento (contém informação sobre o que foi clicado)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Pega o botão exato que foi clicado
        JButton botaoClicado = (JButton) e.getSource();

        // --- Regras de "Não-Ação" ---
        // Se o jogador clicar no primeiro OU no segundo botão já selecionado, ignora
        if (botaoClicado == primeiroBotao || botaoClicado == segundoBotao) {
            return; 
        }
        // Se o botão clicado já for um par encontrado (desabilitado), ignora
        if (!botaoClicado.isEnabled()) {
            return;
        }

        // Revela a carta (mostra o valor que estava no "name")
        botaoClicado.setText(botaoClicado.getName());

        // --- Lógica da Jogada ---
        if (primeiroBotao == null) {
            // Se foi o PRIMEIRO clique da rodada
            primeiroBotao = botaoClicado;
        } else {
            // Se foi o SEGUNDO clique da rodada
            segundoBotao = botaoClicado;
            
            // Trava os cliques enquanto verifica (opcional, mas bom)
            // (Poderíamos desabilitar todos os outros botões aqui)

            // Chama o método que verifica se os pares são iguais
            verificarPares();
        }
    }

    /**
     * Método auxiliar que compara os dois botões clicados.
     */
    private void verificarPares() {
        // Usamos o "name" (valor real) para comparar
        String valor1 = primeiroBotao.getName();
        String valor2 = segundoBotao.getName();

        if (valor1.equals(valor2)) {
            // --- ACERTOU ---
            // Desabilita os botões para não poderem ser clicados novamente
            primeiroBotao.setEnabled(false);
            segundoBotao.setEnabled(false);

            paresEncontrados++; // Incrementa o contador

            // "Limpa" as variáveis da rodada
            resetarSelecao();

            // Verifica se o jogo acabou
            if (paresEncontrados == 8) {
                finalizarJogo();
            }
            
        } else {
            // --- ERROU ---
            // Precisamos "virar de volta", mas só depois de um tempo.
            // Usamos um Timer do Swing para isso.
            
            // Cria um Timer que vai rodar daqui a 1000ms (1 segundo)
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Este código SÓ RODA depois de 1 segundo
                    primeiroBotao.setText("?");
                    segundoBotao.setText("?");
                    
                    // "Limpa" as variáveis da rodada
                    resetarSelecao();
                }
            });
            timer.setRepeats(false); // Garante que o timer rode só uma vez
            timer.start(); // Inicia o timer
        }
    }

    /**
     * Método auxiliar para "limpar" as variáveis de controle da rodada.
     */
    private void resetarSelecao() {
        primeiroBotao = null;
        segundoBotao = null;
    }

    /**
     * Chamado quando todos os 8 pares são encontrados.
     */
    private void finalizarJogo() {
        // Mostra uma caixa de diálogo (JOptionPane)
        int resposta = JOptionPane.showConfirmDialog(this, 
                "Parabéns! Você encontrou todos os pares!\nDeseja jogar novamente?", 
                "Fim de Jogo", 
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            reiniciarJogo();
        } else {
            System.exit(0); // Fecha o programa
        }
    }

    /**
     * Reseta o tabuleiro para um novo jogo.
     */
    private void reiniciarJogo() {
        // 1. Reseta os contadores
        paresEncontrados = 0;
        resetarSelecao();

        // 2. Re-embaralha os valores
        Collections.shuffle(valores);

        // 3. Reseta todos os botões
        for (int i = 0; i < 16; i++) {
            JButton botao = botoes.get(i);
            botao.setText("?"); // Esconde o valor
            botao.setName(valores.get(i)); // Atribui o novo valor embaralhado
            botao.setEnabled(true); // Re-habilita o botão
        }
    }

    /**
     * Método Main: O ponto de entrada do programa.
     */
    public static void main(String[] args) {
        // É uma boa prática iniciar a interface gráfica Swing
        // dentro desta "thread" especial (Event Dispatch Thread).
        javax.swing.SwingUtilities.invokeLater(() -> {
            JogoDaMemoria jogo = new JogoDaMemoria();
            jogo.setVisible(true); // Só torna visível DEPOIS de montar tudo.
        });
    }
}
```

-----



**Código-Fonte Completo e Comentado:**

```java

/**
 * Jogo da Memória Simples em Java Swing
 * Foco: Lógica de Programação, Swing Básico, Eventos (ActionListener) e Timer.
 *
 * VERSÃO COM FONTES ALTERADAS (Maiores e em Negrito)
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer; // Importante: use o timer do SWING
import java.awt.GridLayout;
import java.awt.Font; // <-- IMPORT NECESSÁRIO PARA MUDAR A FONTE
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Nossa classe principal do Jogo.
 * Ela é (extends) uma Janela (JFrame) e
 * ela "ouve" (implements) os cliques (ActionListener).
 */
public class JogoDaMemoria extends JFrame implements ActionListener {

    // Componentes Gráficos
    private JPanel painelPrincipal; // O "tabuleiro" onde os botões ficam

    // Lista dos botões (que são nossas "cartas")
    private ArrayList<JButton> botoes = new ArrayList<>();

    // Lista dos valores (os números "1" a "8", duplicados)
    private ArrayList<String> valores = new ArrayList<>();

    // --- Variáveis de Controle da Lógica do Jogo ---

    // Guarda o primeiro botão clicado na rodada
    private JButton primeiroBotao = null;
    // Guarda o segundo botão clicado na rodada
    private JButton segundoBotao = null;

    // Contador de quantos pares já foram encontrados
    private int paresEncontrados = 0;

    /**
     * Construtor: Onde o jogo é montado.
     */
    public JogoDaMemoria() {
        // 1. Configuração da Janela (JFrame)
        setTitle("Jogo da Memória");
        setSize(500, 500); // Um pouco maior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no "X"
        setLocationRelativeTo(null); // Centraliza na tela

        // 2. Configuração do Painel (JPanel) e Layout
        painelPrincipal = new JPanel();
        // Define o layout como uma grade 4x4
        painelPrincipal.setLayout(new GridLayout(4, 4, 5, 5)); // (4, 4, hgap, vgap)

        // 3. Preparação das Cartas (Lógica)
        // Adiciona 8 pares de números (de "1" a "8")
        for (int i = 1; i <= 8; i++) {
            valores.add(String.valueOf(i));
            valores.add(String.valueOf(i));
        }

        // Embaralha a lista de valores
        Collections.shuffle(valores);

        // --- ALTERAÇÃO DA FONTE (Início) ---
        // 1. Criamos um único objeto Font para reutilizar
        // Fonte: Padrão (Dialog), Estilo: Negrito (BOLD), Tamanho: 24
        Font fonteDoBotao = new Font(Font.DIALOG, Font.BOLD, 24);
        // --- ALTERAÇÃO DA FONTE (Fim) ---

        // 4. Criação dos Botões (Cartas)
        for (int i = 0; i < 16; i++) {
            JButton botao = new JButton();

            // O "name" guarda o valor real (escondido) da carta
            botao.setName(valores.get(i));

            // O "text" é o que o usuário vê (a carta "virada")
            botao.setText("?");

            // --- ALTERAÇÃO DA FONTE (Início) ---
            // 2. Aplicamos a fonte criada ao botão
            botao.setFont(fonteDoBotao);
            // --- ALTERAÇÃO DA FONTE (Fim) ---

            // Adiciona o "ouvinte de clique" (ActionListener)
            botao.addActionListener(this);

            botoes.add(botao); // Guarda o botão na lista
            painelPrincipal.add(botao); // Adiciona o botão ao tabuleiro
        }

        // 5. Adiciona o painel principal (tabuleiro) à janela
        add(painelPrincipal);
    }

    /**
     * O "Cérebro" do Jogo.
     * Este método é chamado automaticamente sempre que um botão é clicado.
     * @param e O evento (contém informação sobre o que foi clicado)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Pega o botão exato que foi clicado
        JButton botaoClicado = (JButton) e.getSource();

        // --- Regras de "Não-Ação" ---
        if (botaoClicado == primeiroBotao || botaoClicado == segundoBotao) {
            return;
        }
        if (!botaoClicado.isEnabled()) {
            return;
        }

        // Revela a carta (mostra o valor que estava no "name")
        botaoClicado.setText(botaoClicado.getName());

        // --- Lógica da Jogada ---
        if (primeiroBotao == null) {
            // Se foi o PRIMEIRO clique da rodada
            primeiroBotao = botaoClicado;
        } else {
            // Se foi o SEGUNDO clique da rodada
            segundoBotao = botaoClicado;
            verificarPares();
        }
    }

    /**
     * Método auxiliar que compara os dois botões clicados.
     */
    private void verificarPares() {
        String valor1 = primeiroBotao.getName();
        String valor2 = segundoBotao.getName();

        if (valor1.equals(valor2)) {
            // --- ACERTOU ---
            primeiroBotao.setEnabled(false);
            segundoBotao.setEnabled(false);

            paresEncontrados++;
            resetarSelecao();

            if (paresEncontrados == 8) {
                finalizarJogo();
            }

        } else {
            // --- ERROU ---
            // Usa um Timer do Swing para esperar 1 segundo antes de virar
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Este código SÓ RODA depois de 1 segundo
                    primeiroBotao.setText("?");
                    segundoBotao.setText("?");
                    resetarSelecao();
                }
            });
            timer.setRepeats(false); // Roda só uma vez
            timer.start();
        }
    }

    /**
     * Método auxiliar para "limpar" as variáveis de controle da rodada.
     */
    private void resetarSelecao() {
        primeiroBotao = null;
        segundoBotao = null;
    }

    /**
     * Chamado quando todos os 8 pares são encontrados.
     */
    private void finalizarJogo() {
        // Mostra uma caixa de diálogo (JOptionPane)
        int resposta = JOptionPane.showConfirmDialog(this,
                "Parabéns! Você encontrou todos os pares!\nDeseja jogar novamente?",
                "Fim de Jogo",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            reiniciarJogo();
        } else {
            System.exit(0); // Fecha o programa
        }
    }

    /**
     * Reseta o tabuleiro para um novo jogo.
     */
    private void reiniciarJogo() {
        // 1. Reseta os contadores
        paresEncontrados = 0;
        resetarSelecao();

        // 2. Re-embaralha os valores
        Collections.shuffle(valores);

        // 3. Reseta todos os botões
        for (int i = 0; i < 16; i++) {
            JButton botao = botoes.get(i);
            botao.setText("?"); // Esconde o valor
            botao.setName(valores.get(i)); // Atribui o novo valor embaralhado
            botao.setEnabled(true); // Re-habilita o botão
        }
    }

    /**
     * Método Main: O ponto de entrada do programa.
     */
    public static void main(String[] args) {
        // É uma boa prática iniciar a interface gráfica Swing
        // dentro desta "thread" especial (Event Dispatch Thread).
        javax.swing.SwingUtilities.invokeLater(() -> {
            JogoDaMemoria jogo = new JogoDaMemoria();
            jogo.setVisible(true); // Só torna visível DEPOIS de montar tudo.
        });
    }
}

```

---


### ✅ Etapa 8: Melhorias Opcionais (Desafios)

Parabéns\! Se você chegou até aqui, você tem um Jogo da Memória completo e funcional.

Como professor, eu sempre deixo alguns desafios para os alunos curiosos:

1.  **Contador de Jogadas:** Crie uma variável `int tentativas` e incremente-a toda vez que o jogador errar (ou toda vez que `verificarPares()` for chamado). Mostre isso na janela (talvez usando um `JLabel` no topo).
2.  **Usar Imagens (Ícones):** Em vez de números ("1", "2"...), tente usar `ImageIcon`. Você terá que associar o `ImageIcon` ao `JButton` (`botao.setIcon(...)`) em vez de `botao.setText(...)`. O desafio aqui é como comparar se dois ícones são "iguais". (Dica: compare os *nomes dos arquivos* das imagens\!).
3.  **Cronômetro:** Use um `javax.swing.Timer` (dessa vez um que se repete a cada segundo) para contar o tempo que o jogador leva.

