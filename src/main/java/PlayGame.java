import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    final int BOARD_SIZE = 10;
    private static final int NUM_SHIPS = 4;

    private int numShips;
    private Random random;
    private static Board player1_board = new Board();
    private static Board player2_board = new Board();
    private static Player player1 = new Player(player1_board);

    private static Player player2 = new Player(player2_board);

    public static void main(String[] args) {
        PlayGame game = new PlayGame(player1, player2);
    }


    public PlayGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1_board = player1.getBoard();
        this.player2_board = player2.getBoard();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 place your ships on your board!");

        for (int i = 0; i < 4; i++) {
            System.out.println("Enter row number");
            int row = scanner.nextInt();
            System.out.println("Enter column number");
            int col = scanner.nextInt();

            player1_board.placeShip(row, col);
        }
        player1_board.displayBoard();

        System.out.println("Player 2 place your ships on the board!");
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter row number");
            int row = scanner.nextInt();
            System.out.println("Enter column number");
            int col = scanner.nextInt();

            player2_board.placeShip(row, col);
        }
        player2_board.displayBoard();


        while (!gameOver()) {
            System.out.println("** PLayer 1 turn **");
            System.out.println("Your board");
            player1_board.displayBoard();
            System.out.println("Your opponents board");
            player2_board.displayHidden();
            player1.turn(player2_board);
            System.out.println("** Player 2 turn **");
            System.out.println("Your board");
            player2_board.displayBoard();
            System.out.println("Your opponents board");
            player1_board.displayHidden();
            player2.turn(player1_board);
        }

    }

    private boolean gameOver() {
        boolean gameOver = false;
        if (!player2.getIsAlive() && player1.getIsAlive()) {
            System.out.println("You win, congratulations!");
            gameOver = true;
        } else if (!player1.getIsAlive() && player2.getIsAlive()) {
            System.out.println("Your opponent wins! Better luck next time");
            gameOver = true;
        }
        return gameOver;
    }
}
