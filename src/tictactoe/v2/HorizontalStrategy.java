package tictactoe.v2;

public class HorizontalStrategy implements PlayerStrategy {
    @Override
    public Position nextMove(Board board, Symbol symbol) {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                if (board.isEmpty(r, c)) {
                    return new Position(r, c);
                }
            }
        }
        return null;
    }
}
