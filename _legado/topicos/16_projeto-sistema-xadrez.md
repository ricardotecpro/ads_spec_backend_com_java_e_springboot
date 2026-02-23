# Projeto: Sistema de Xadrez em Java
A base deste projeto é uma **arquitetura em camadas** bem definida, que desacopla as responsabilidades do sistema. Isso é fundamental para a manutenibilidade e evolução do software.

1.  **Camada de Jogo de Tabuleiro (Board Layer):** O núcleo agnóstico. Contém a lógica para um tabuleiro genérico, posições e peças, sem qualquer conhecimento sobre xadrez.
2.  **Camada de Xadrez (Chess Layer):** Implementa as regras específicas do xadrez. Utiliza a camada de tabuleiro e adiciona conceitos como cores, tipos de peças, movimentos especiais e a lógica de xeque/xeque-mate.
3.  **Camada de Aplicação/UI (Application Layer):** A interface com o usuário. Responsável por renderizar o tabuleiro no console, ler as entradas do jogador e apresentar o estado do jogo.

### **Estrutura do Projeto (Estrutura de Pacotes)**

Para refletir essa arquitetura em nosso código, organizaremos o projeto na seguinte estrutura de pacotes. Esta organização torna o projeto intuitivo e fácil de navegar.

```
src
└── com
    └── yourdomain
        ├── application
        │   ├── Program.java      // Classe principal, com o método main()
        │   └── UI.java           // Classe responsável por toda a interação no console
        │
        ├── boardgame
        │   ├── Board.java        // Representa o tabuleiro genérico
        │   ├── BoardException.java // Exceção para erros relacionados ao tabuleiro
        │   ├── Piece.java        // Representa uma peça genérica (abstrata)
        │   └── Position.java     // Representa uma posição na matriz
        │
        └── chess
            ├── ChessException.java   // Exceção para erros de regras do xadrez
            ├── ChessMatch.java     // Coração do jogo, orquestra as regras
            ├── ChessPiece.java     // Peça específica de xadrez (com cor)
            ├── ChessPosition.java  // Posição no formato de xadrez (ex: a1, h8)
            ├── Color.java          // Enum para as cores das peças (BLACK, WHITE)
            └── pieces              // Sub-pacote para as implementações concretas das peças
                ├── King.java
                ├── Rook.java
                ├── Pawn.java
                └── ... (demais peças)
```

-----

### **Fase 1: Configuração do Ambiente e Estrutura do Projeto**

Esta fase inicial prepara o terreno para um desenvolvimento organizado e versionado.

**Checklist de Ações:**

  * **Pré-requisitos:** Garanta que JDK, uma IDE (como IntelliJ ou Eclipse) e o Git estejam instalados.
  * **Repositório Git:** Crie um novo projeto no GitHub, selecionando o template `.gitignore` para Java.
  * **Projeto Local:** Na sua IDE, crie um novo projeto Java e, no terminal dentro da pasta do projeto, execute os comandos para vincular ao repositório remoto:
    ```bash
    git init
    git remote add origin <URL_DO_SEU_REPOSITORIO_NO_GITHUB>
    git add .
    git commit -m "Initial project structure"
    git push -u origin main
    ```

### **Fase 2: Implementação do Núcleo do Tabuleiro (boardgame)**

Construímos a base reutilizável do nosso sistema.

**1. Classe `Position.java`**
Representa uma coordenada (linha, coluna) na matriz.

```java
// package com.yourdomain.boardgame;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Getters e Setters
    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }
    public int getColumn() { return column; }
    public void setColumn(int column) { this.column = column; }

    @Override
    public String toString() {
        return row + ", " + column;
    }
}
```

**2. Classe `Board.java`**
Gerencia a matriz de peças e as operações básicas.

```java
// package com.yourdomain.boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces; // Matriz de peças

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    // ... Getters para rows e columns ...

    // Retorna a peça em uma dada posição
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    // Sobrecarga para usar o objeto Position
    public Piece piece(Position position) {
        return piece(position.getRow(), position.getColumn());
    }
    
    // Coloca uma peça no tabuleiro
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position; // Informa à peça sua posição no tabuleiro
    }

    // Valida se uma posição existe
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    // Valida se já existe uma peça na posição
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
```

### **Fase 3: Implementação da Camada de Xadrez (chess)**

Adicionamos a inteligência e as regras do jogo.

**1. Classe `ChessPiece.java`**
Classe base para as peças de xadrez, estendendo `Piece` e adicionando o atributo `Color`.

```java
// package com.yourdomain.chess;

import com.yourdomain.boardgame.Board;
import com.yourdomain.boardgame.Piece;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board); // Chama o construtor da classe mãe
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
```

**2. Implementação de uma Peça Concreta: `Rook.java` (Torre)**

```java
// package com.yourdomain.chess.pieces;

import com.yourdomain.boardgame.Board;
import com.yourdomain.chess.ChessPiece;
import com.yourdomain.chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R"; // "R" de Rook (Torre)
    }
    
    @Override
    public boolean[][] possibleMoves() {
        // Lógica de movimentos da torre será implementada na Fase 5
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        // ... implementação ...
        return mat;
    }
}
```

**3. Classe `ChessMatch.java`**
O cérebro da partida, responsável por gerenciar turnos, colocar peças e orquestrar as jogadas.

```java
// package com.yourdomain.chess;

import com.yourdomain.boardgame.Board;
import com.yourdomain.chess.pieces.King;
import com.yourdomain.chess.pieces.Rook;

public class ChessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }
    
    public int getTurn() { return turn; }
    public Color getCurrentPlayer() { return currentPlayer; }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    // Coloca uma nova peça no tabuleiro, convertendo da notação de xadrez
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    // Método para posicionar as peças no início do jogo
    private void initialSetup() {
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        // ... outras peças brancas

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        // ... outras peças pretas
    }
}
```

### **Fase 4: Interface com o Usuário (application)**

A camada que permite a interação do jogador com o sistema.

**Classe `UI.java`**

```java
// package com.yourdomain.application;

import com.yourdomain.chess.ChessPiece;
import com.yourdomain.chess.Color;

public class UI {
    // Códigos de cores para o console (exemplo)
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_WHITE = "\u001B[37m";

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");
        } else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
}
```

**Classe `Program.java` (Loop Principal)**

```java
// package com.yourdomain.application;

import com.yourdomain.chess.ChessMatch;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) { // O loop terminará com a lógica de xeque-mate
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.println("Turn: " + chessMatch.getTurn());
            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
            
            // Lógica para ler a jogada do usuário, validar e executar
            // ... será detalhada nas próximas fases ...
            sc.nextLine(); // Pausa temporária
        }
    }
}
```

### **Fases 5, 6 e 7: Movimentos, Regras e Lógica Avançada**

Com a estrutura montada, o foco passa a ser a implementação da lógica complexa dentro das classes já criadas, como preencher o método `possibleMoves()` para cada peça, desenvolver a lógica de captura, xeque, xeque-mate e os movimentos especiais no `ChessMatch`.

Este design detalhado fornece um roteiro claro e robusto. Cada componente tem seu lugar e sua responsabilidade, o que é a marca de uma engenharia de software de qualidade.