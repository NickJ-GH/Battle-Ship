//* Singleton design pattern

import java.util.Arrays;

public class Board {
    private static final int BOARD_SIZE = 10;
    private char[][] board;
    private static Board instance;

    private int numShips = 4;

    public Board() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    public int getNumShips() {
        return this.numShips;
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            Arrays.fill(board[i], '~');
        }
    }

    public void placeShip(int row, int col) {
        if (board[row][col] == '~') {
            board[row][col] = 'O';
        }
    }

    public void hit(int row, int col) {
        if (board[row][col] == '0') {
            board[row][col] = 'X';
            System.out.println("Hit!");
            numShips --;
        } else {
            System.out.println("Miss");
        }
    }

//    public boolean isHit(int row, int col) {
//        return board[row][col] == 'O';
//    }
//
//    public void markHit(int row, int col) {
//        board[row][col] = 'X';
//    }

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
    

    public static int getBoardSize() {
        return BOARD_SIZE;
    }
}
