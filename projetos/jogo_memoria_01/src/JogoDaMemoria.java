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