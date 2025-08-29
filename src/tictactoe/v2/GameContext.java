package tictactoe.v2;

public class GameContext {
    private GameState state;

    public GameContext() {
        this.state = new PlayingState();
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void request(TicTacToe game) {
        state.play(this, game);
    }
}
