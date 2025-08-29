package tictactoe.v2;

public class TicTacToeV2Main {
    public static void main(String[] args) {
        PlayerStrategy ps1 = new HorizontalStrategy();
        PlayerStrategy ps2 = new VerticalStrategy();

        Player playerX = new Player("player1", Symbol.X, ps1);
        Player playerO = new Player("player2", Symbol.O, ps2);

        Board board = new Board(3, 3);
        GameContext gc = new GameContext();
        TicTacToe game = new TicTacToe(playerX, playerO, board, gc);
        game.play();
    }
}
