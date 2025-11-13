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
        setTitle("Meu Primeiro Contador Java Swing");

        // Define o tamanho da janela em pixels (Largura, Altura)
        setSize(600, 300);

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