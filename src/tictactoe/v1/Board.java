package tictactoe.v1;

public class Board {
    GameState gameState;
    char[][] board;


    public Board() {
        this.gameState = GameState.RUNNING;
        this.board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Symbol.EMPTY.getChar();
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placeSymbol(int row, int col, Symbol symbol) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            System.out.println("Invalid move: Out of bounds.");
            return false;
        }

        if (board[row][col] != Symbol.EMPTY.getChar()) {
            System.out.println("Invalid move: Cell already occupied.");
            return false;
        }

        board[row][col] = symbol.getChar();
        return true;
    }


    public void checkStatus() {
        // 가로/세로 검사
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != Symbol.EMPTY.getChar() && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                gameState = (board[i][0] == Symbol.X.getChar()) ? GameState.X_WINS : GameState.O_WINS;
                return;
            }
            if (board[0][i] != Symbol.EMPTY.getChar() && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                gameState = (board[0][i] == Symbol.X.getChar()) ? GameState.X_WINS : GameState.O_WINS;
                return;
            }
        }

        if (board[1][1] != Symbol.EMPTY.getChar()) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                gameState = (board[1][1] == Symbol.X.getChar()) ? GameState.X_WINS : GameState.O_WINS;
                return;
            }
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                gameState = (board[1][1] == Symbol.X.getChar()) ? GameState.X_WINS : GameState.O_WINS;
                return;
            }
        }

        boolean empty = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Symbol.EMPTY.getChar()) {
                    return;
                }
            }
        }
    }

}
