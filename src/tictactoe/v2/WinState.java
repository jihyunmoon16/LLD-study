package tictactoe.v2;

public class WinState implements GameState {
    private final Player winner;

    public WinState(Player winner) {
        this.winner = winner;
    }

    @Override
    public void play(GameContext context, TicTacToe game) {
        System.out.println("Game End! Winner is : " + winner.getName());
    }
}