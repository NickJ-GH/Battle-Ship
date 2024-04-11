import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    final int BOARD_SIZE = 10;
    private static final int NUM_SHIPS = 4;

    private static Board player1_board = new Board();
    private static Board player2_board = new Board();
    private static Player player1 = new User(player1_board);
    private static Player player2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for game mode
        System.out.println("Choose game mode:");
        System.out.println("1. Player vs CPU");
        System.out.println("2. Player vs Player");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            player2 = new Cpu(player2_board);
        } else {
            player2 = new User(player2_board);
        }

        PlayGame game = new PlayGame(player1, player2);
    }


    public PlayGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1_board = player1.getBoard();
        this.player2_board = player2.getBoard();


         // Place ships for Player 1
         System.out.println("Player 1, place your ships on your board!");
         placeShips(player1_board);
         player1_board.displayBoard();
 
        // Place ships for Player 2 or CPU
        if (player2 instanceof User) {
            System.out.println("Player 2, place your ships on your board!");
            placeShips(player2_board);
            player2_board.displayBoard();
        } else {
            System.out.println("CPU is placing its ships...");
            placeShipsRandomly(player2_board);
            System.out.println("CPU has placed its ships.");
        }

         // Game loop
        while (!gameOver()) {
            playerTurn(player1, player2_board, "Player 1");
            if (gameOver()) {
                break;
            }
            playerTurn(player2, player2_board, "Player 2");
        }
    }


    private void playerTurn(Player player, Board opponentBoard, String playerName) {
        System.out.println("** " + playerName + " turn **");
        System.out.println("Your board:");
        player.getBoard().displayBoard();
        System.out.println("Your opponent's board:");
        opponentBoard.displayHidden();
        player.turn(opponentBoard);
    }

    private boolean gameOver() {
        if (!player2.getIsAlive() && player1.getIsAlive()) {
            System.out.println("Player 1 wins! Congratulations!");
            return true;
        } else if (!player1.getIsAlive() && player2.getIsAlive()) {
            System.out.println("Player 2 wins! Better luck next time.");
            return true;
        }
        return false;
    }


    private void placeShips(Board board) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM_SHIPS; i++) {
            System.out.println("Enter row number for ship " + (i + 1) + " (0-9):");
            int row = scanner.nextInt();
            System.out.println("Enter column number for ship " + (i + 1) + " (0-9):");
            int col = scanner.nextInt();
            board.placeShip(row, col);
        }
    }


    private void placeShipsRandomly(Board board) {
        for (int i = 0; i < NUM_SHIPS; i++) {
            int row, col;
            do {
                row = (int) (Math.random() * Board.getBoardSize());
                col = (int) (Math.random() * Board.getBoardSize());
            } while (board.getBoard()[row][col] == 'O');
            board.placeShip(row, col);
        }
    }

}
