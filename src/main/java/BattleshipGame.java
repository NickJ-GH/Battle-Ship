
/// Board Class
// Battleship game state class
// player class

import java.util.*;

public class BattleshipGame {
    private static final int BOARD_SIZE = 10;
    private static final int NUM_SHIPS = 4;

    private char[][] board;
    private int numShips;
    private Random random;

    public BattleshipGame() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        numShips = NUM_SHIPS;
        random = new Random();

        initializeBoard();
        placeShips();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            Arrays.fill(board[i], '~');
        }
    }

    private void placeShips() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Place your ships on your board!");

        for (int i = 0; i < numShips; i++) {
            System.out.println("Enter row number");
            int row = scanner.nextInt();
            System.out.println("Enter column number");
            int col = scanner.nextInt();

            if (board[row][col] == '~') {
                board[row][col] = 'O';
            }
            displayBoard();
        }
//        for (int i = 0; i < numShips; i++) {
//            int x = random.nextInt(BOARD_SIZE);
//            int y = random.nextInt(BOARD_SIZE);
//
//            if (board[x][y] == '~') {
//                board[x][y] = 'O';
//            } else {
//                i--; // Try placing the ship again
//            }
//        }
    }

    private boolean isGameOver() {
        return numShips == 0;
    }

    public void displayBoard() {
        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void displayHidden() {
        System.out.println(" ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.println(i + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.println(board[i][j] + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 'X') {
                    System.out.println(board[i][j] + " ");
                } else {
                    System.out.println("~ ");
                }
            }
            System.out.println();
        }
    }

    private void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver()) {
            System.out.println("\n**** Battleship Game ****");
            displayBoard();

            System.out.print("Enter row (0-4): ");
            int x = scanner.nextInt();

            System.out.print("Enter column (0-4): ");
            int y = scanner.nextInt();

            if (board[x][y] == 'O') {
                System.out.println("Hit!");
                board[x][y] = 'X';
                numShips--;
            } else {
                System.out.println("Miss!");
            }
        }

        System.out.println("\n**** Game Over! ****");
        displayBoard();
        System.out.println("You sunk all the battleships!");
        scanner.close();
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.playGame();
    }
}
