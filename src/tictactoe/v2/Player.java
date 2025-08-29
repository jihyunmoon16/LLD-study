package tictactoe.v2;

public class Player {
    private final String name;
    private final Symbol symbol;
    private final PlayerStrategy strategy;

    public Player(String name, Symbol symbol, PlayerStrategy strategy) {
        this.name = name;
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public Position makeMove(Board board) {
        return strategy.nextMove(board, symbol);
    }

}
