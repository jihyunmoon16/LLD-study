package tictactoe.v2;

public class TicTacToe {
    private final Player playerX;
    private final Player playerO;
    private final Player currentPlayer;
    private final Board board;
    private final GameContext gameContext;
    private final Player winner; // 승자 저장

    public TicTacToe(Player playerX, Player playerO, Board board, GameContext gameContext) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = board;
        this.gameContext = gameContext;
        this.currentPlayer = playerX; // X 먼저 시작
    }

    // 게임 실행
    public void play() {
        while (!isOver()) {
            gameContext.request(this); // 현재 상태에서 행동 실행
        }
    }

    // 현재 플레이어의 턴 수행
    public void takeTurn() {
        Position move = currentPlayer.makeMove(board);
        board.placeSymbol(move.getRow(), move.getCol(), currentPlayer.getSymbol());
        System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ") → "
                + "(" + move.getRow() + "," + move.getCol() + ")");
        board.printBoard();

        if (board.checkWin(currentPlayer.getSymbol())) {
            winner = currentPlayer;
        } else if (!board.isFull()) {
            switchPlayer();
        }
    }

    // 플레이어 교체
    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    // 게임 종료 여부
    public boolean isOver() {
        return winner != null || board.isFull();
    }

    // 승자 반환
    public Player getWinner() {
        return winner;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
