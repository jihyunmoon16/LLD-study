package tictactoe.v2;

public class Board {
    private final char[][] board;
    private final int rows;
    private final int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
        // 보드 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = Symbol.EMPTY.getChar();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    // 보드 출력
    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 빈 칸 여부 체크
    public boolean isEmpty(int r, int c) {
        return board[r][c] == Symbol.EMPTY.getChar();
    }

    // 말 놓기
    public boolean placeSymbol(int r, int c, Symbol symbol) {
        if (isEmpty(r, c)) {
            board[r][c] = symbol.getChar();
            return true;
        }
        return false;
    }

    // 보드가 가득 찼는지 확인
    public boolean isFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == Symbol.EMPTY.getChar()) {
                    return false;
                }
            }
        }
        return true;
    }

    // 승리 조건 검사
    public boolean checkWin(Symbol symbol) {
        char ch = symbol.getChar();

        // 가로
        for (int i = 0; i < rows; i++) {
            boolean win = true;
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != ch) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // 세로
        for (int j = 0; j < cols; j++) {
            boolean win = true;
            for (int i = 0; i < rows; i++) {
                if (board[i][j] != ch) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // 대각선 ↘
        boolean diag1 = true;
        for (int i = 0; i < rows; i++) {
            if (board[i][i] != ch) {
                diag1 = false;
                break;
            }
        }

        // 대각선 ↙
        boolean diag2 = true;
        for (int i = 0; i < rows; i++) {
            if (board[i][rows - i - 1] != ch) {
                diag2 = false;
                break;
            }
        }

        return diag1 || diag2;
    }
}