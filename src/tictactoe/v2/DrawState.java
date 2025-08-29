package tictactoe.v2;

public class DrawState implements GameState {
    @Override
    public void play(GameContext context, TicTacToe game) {
        System.out.println("Game End. It is a draw");
    }
}