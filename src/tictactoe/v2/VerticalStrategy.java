package tictactoe.v2;

public class VerticalStrategy implements PlayerStrategy {
    @Override
    public Position nextMove(Board board, Symbol symbol) {
        for (int c = 0; c < board.getCols(); c++) {
            for (int r = 0; r < board.getRows(); r++) {
                if (board.isEmpty(r, c)) {
                    return new Position(r, c);
                }
            }
        }
        return null;
    }
}
