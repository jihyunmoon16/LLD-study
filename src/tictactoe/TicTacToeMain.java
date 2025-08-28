package tictactoe;

import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");

        System.out.print("Player 1: Please enter your name: ");
        String name1 = sc.nextLine();
        System.out.print("Player 2: Please enter your name: ");
        String name2 = sc.nextLine();
        Player player1 = new Player(name1, Symbol.X);
        Player player2 = new Player(name2, Symbol.O);

        Player[] players = {player1, player2};

        Board board = new Board();
        board.printBoard();

        int turn = 0;

        while (board.gameState.equals(GameState.RUNNING)) {
            Player currentPlayer = players[turn % 2];

            // 입력 받기
            System.out.println(currentPlayer.getName() + ": enter the coordinate (row col): ");
            String[] input = sc.nextLine().trim().split(" ");
            if (input.length != 2) {
                System.out.println("Invalid input. Please enter two numbers separated by space.");
                continue;
            }

            try {
                int row = Integer.parseInt(input[0]);
                int col = Integer.parseInt(input[1]);

                if (board.placeSymbol(row, col, currentPlayer.getSymbol())) {
                    board.printBoard();
                    board.checkStatus();
                    turn++;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers only.");
            }
        }

        sc.close();

        if (board.gameState == GameState.X_WINS) {
            System.out.println(player1.getName() + " wins!");
        } else if (board.gameState == GameState.O_WINS) {
            System.out.println(player2.getName() + " wins!");
        } else if (board.gameState == GameState.DRAW) {
            System.out.println("It's a draw!");
        }
    }
}
