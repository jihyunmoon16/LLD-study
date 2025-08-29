package tictactoe.v2;

public interface PlayerStrategy {
    Position nextMove(Board board, Symbol symbol);
}
