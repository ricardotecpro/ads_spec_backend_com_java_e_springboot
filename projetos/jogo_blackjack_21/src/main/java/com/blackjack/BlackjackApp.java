package com.blackjack;

import com.blackjack.model.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BlackjackApp extends Application {

    // --- Estado do Jogo ---
    private Baralho baralho;
    private Mao maoJogador;
    private Mao maoDealer;
    private boolean jogoEmAndamento;

    // --- Elementos de UI ---
    private HBox containerCartasDealer;
    private HBox containerCartasJogador;
    private Label lblPontosDealer;
    private Label lblPontosJogador;
    private Label lblMensagem;

    private Button btnPedir;
    private Button btnParar;
    private Button btnNovoJogo;

    @Override
    public void start(Stage stage) {
        // Inicialização dos Modelos
        baralho = new Baralho();
        maoJogador = new Mao();
        maoDealer = new Mao();

        // --- Construção da Interface ---

        // 1. Cabeçalho
        Label titulo = new Label("BLACKJACK 21");
        titulo.getStyleClass().add("titulo-principal");

        // 2. Área do Dealer
        lblPontosDealer = new Label("Dealer: 0");
        lblPontosDealer.getStyleClass().add("titulo-area");

        containerCartasDealer = new HBox(10);
        containerCartasDealer.setAlignment(Pos.CENTER);

        VBox areaDealer = new VBox(10, lblPontosDealer, containerCartasDealer);
        areaDealer.getStyleClass().add("area-jogo");

        // 3. Status do Jogo
        lblMensagem = new Label("Bem-vindo!");
        lblMensagem.getStyleClass().add("status-msg");

        // 4. Área do Jogador
        lblPontosJogador = new Label("Você: 0");
        lblPontosJogador.getStyleClass().add("titulo-area");

        containerCartasJogador = new HBox(10);
        containerCartasJogador.setAlignment(Pos.CENTER);

        VBox areaJogador = new VBox(10, lblPontosJogador, containerCartasJogador);
        areaJogador.getStyleClass().add("area-jogo");

        // 5. Controles
        HBox controles = new HBox(20);
        controles.setAlignment(Pos.CENTER);
        controles.setPadding(new Insets(20));

        btnPedir = new Button("PEDIR CARTA");
        btnParar = new Button("PARAR (STAND)");
        btnNovoJogo = new Button("NOVO JOGO");

        // Ações dos Botões
        btnPedir.setOnAction(e -> acaoPedirCarta());
        btnParar.setOnAction(e -> acaoParar());
        btnNovoJogo.setOnAction(e -> iniciarJogo());

        controles.getChildren().addAll(btnPedir, btnParar, btnNovoJogo);

        // --- Layout Principal ---
        VBox root = new VBox(20);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titulo, areaDealer, lblMensagem, areaJogador, controles);

        // Configuração da Cena
        Scene scene = new Scene(root, 900, 700);

        // Importante: Carregando o CSS
        String css = getClass().getResource("/styles.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("Blackjack Desktop - JavaFX");
        stage.setScene(scene);
        stage.show();

        // Começar o primeiro jogo
        iniciarJogo();
    }

    // --- Lógica do Jogo (Game Loop) ---

    private void iniciarJogo() {
        jogoEmAndamento = true;
        baralho.reiniciar();
        maoJogador.limpar();
        maoDealer.limpar();

        lblMensagem.setText("Sua vez. Pedir ou Parar?");
        atualizarBotoes(true);

        // Distribuição inicial
        maoJogador.adicionar(baralho.comprar());
        maoDealer.adicionar(baralho.comprar());
        maoJogador.adicionar(baralho.comprar());
        maoDealer.adicionar(baralho.comprar());

        // Verifica Blackjack instantâneo
        if (maoJogador.calcularPontuacao() == 21) {
            finalizarJogo("Blackjack! Você venceu!");
        }

        atualizarMesa(false); // false = esconde a primeira carta do dealer
    }

    private void acaoPedirCarta() {
        if (!jogoEmAndamento) return;

        maoJogador.adicionar(baralho.comprar());
        atualizarMesa(false);

        if (maoJogador.calcularPontuacao() > 21) {
            finalizarJogo("Você estourou! Dealer vence.");
        }
    }

    private void acaoParar() {
        if (!jogoEmAndamento) return;

        // Vez do Dealer
        while (maoDealer.calcularPontuacao() < 17) {
            maoDealer.adicionar(baralho.comprar());
        }

        determinarVencedor();
    }

    private void determinarVencedor() {
        int ptsJogador = maoJogador.calcularPontuacao();
        int ptsDealer = maoDealer.calcularPontuacao();

        // Atualiza mostrando a carta oculta
        atualizarMesa(true);

        if (ptsDealer > 21) {
            finalizarJogo("Dealer estourou! Você venceu!");
        } else if (ptsJogador > ptsDealer) {
            finalizarJogo("Você venceu!");
        } else if (ptsDealer > ptsJogador) {
            finalizarJogo("Dealer venceu.");
        } else {
            finalizarJogo("Empate!");
        }
    }

    private void finalizarJogo(String msg) {
        jogoEmAndamento = false;
        lblMensagem.setText(msg);
        atualizarBotoes(false);
        atualizarMesa(true); // Revela tudo no final
    }

    private void atualizarBotoes(boolean jogando) {
        btnPedir.setDisable(!jogando);
        btnParar.setDisable(!jogando);
        btnNovoJogo.setDisable(jogando);
    }

    // --- Renderização Visual (O "DOM" do JavaFX) ---

    private void atualizarMesa(boolean mostrarTudoDealer) {
        // 1. Renderizar Jogador
        containerCartasJogador.getChildren().clear();
        for (Carta c : maoJogador.getCartas()) {
            containerCartasJogador.getChildren().add(criarCartaVisual(c));
        }
        lblPontosJogador.setText("Você: " + maoJogador.calcularPontuacao());

        // 2. Renderizar Dealer
        containerCartasDealer.getChildren().clear();
        var cartasD = maoDealer.getCartas();

        for (int i = 0; i < cartasD.size(); i++) {
            if (i == 0 && !mostrarTudoDealer) {
                containerCartasDealer.getChildren().add(criarCartaVerso());
            } else {
                containerCartasDealer.getChildren().add(criarCartaVisual(cartasD.get(i)));
            }
        }

        // Placar Dealer (esconde pontuação total se carta estiver oculta)
        if (mostrarTudoDealer) {
            lblPontosDealer.setText("Dealer: " + maoDealer.calcularPontuacao());
        } else {
            // Mostra pontuação apenas das cartas visíveis (a partir da segunda)
            // Simplificação: mostra "?" ou recalcula sem a primeira
            lblPontosDealer.setText("Dealer: ?");
        }
    }

    // Cria o componente visual da carta (StackPane)
    private StackPane criarCartaVisual(Carta carta) {
        StackPane cardPane = new StackPane();
        cardPane.getStyleClass().add("carta");

        // Rank Topo Esquerdo
        Label lblRankTop = new Label(carta.rank().display);
        lblRankTop.getStyleClass().addAll("carta-texto", carta.nipe().corCss);
        StackPane.setAlignment(lblRankTop, Pos.TOP_LEFT);
        StackPane.setMargin(lblRankTop, new Insets(5));

        // Naipe Centro
        Label lblNaipe = new Label(carta.nipe().simbolo);
        lblNaipe.getStyleClass().addAll("carta-naipe-grande", carta.nipe().corCss);
        StackPane.setAlignment(lblNaipe, Pos.CENTER);

        // Rank Base Direito (invertido opcionalmente, aqui normal)
        Label lblRankBot = new Label(carta.rank().display);
        lblRankBot.getStyleClass().addAll("carta-texto", carta.nipe().corCss);
        StackPane.setAlignment(lblRankBot, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(lblRankBot, new Insets(5));

        cardPane.getChildren().addAll(lblRankTop, lblNaipe, lblRankBot);
        return cardPane;
    }

    private StackPane criarCartaVerso() {
        StackPane cardPane = new StackPane();
        cardPane.getStyleClass().addAll("carta", "carta-oculta");
        Label inter = new Label("?");
        inter.setStyle("-fx-text-fill: white; -fx-font-size: 30px;");
        cardPane.getChildren().add(inter);
        return cardPane;
    }

    public static void main(String[] args) {
        launch();
    }
}