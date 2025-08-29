package tictactoe.v2;

public class PlayingState implements GameState {
    @Override
    public void play(GameContext context, TicTacToe game) {
        game.takeTurn();
        if (game.isOver()) {
            if (game.getWinner() != null) {
                context.setState(new WinState(game.getWinner()));
            } else {
                context.setState(new DrawState());
            }
        }
    }
}
