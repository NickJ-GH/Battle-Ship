// use a builder pattern for Board 

// Use a factory pattern for Board.Builder class 

import java.util.Arrays;
import java.util.ArrayList;

public class Board {
    private static final int BOARD_SIZE = 10;
    private char[][] board;
    private int numShips;
    private static Board instance;
    private ArrayList<Coordinate> chosen;

    // Private constructor to be used by the builder
    private Board() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
        chosen = new ArrayList<>();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            Arrays.fill(board[i], '~');
        }
        numShips = 4;
    }

    public void placeShip(int row, int col) {
        if (board[row][col] == '~') {
            board[row][col] = 'O';
        }
    }

    public void addToChosen(Coordinate cord) {
        chosen.add(cord);
    }

    public ArrayList<Coordinate> getChosen() {
        return chosen;
    }

    public void hit(int row, int col) {
        if (board[row][col] == 'O') {
            System.out.println("Hit!");
            board[row][col] = 'H';
            numShips--;
        } else {
            System.out.println("Miss");
            board[row][col] = 'M';
        }
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
        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 'O') {
                    System.out.print("~ ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public int getNumShips() {
        return numShips;
    }

    public static int getBoardSize() {
        return BOARD_SIZE;
    }

    // Singleton getInstance() method using the Builder
    public static Board getInstance() {
        if (instance == null) {
            instance = new Board.Builder().build();
        }
        return instance;
    }

    // Builder pattern implementation
    public static class Builder {
        private Board board;

        public Builder() {
            board = new Board();
        }

        public Builder withNumShips(int numShips) {
            board.numShips = numShips;
            return this;
        }

        public Board build() {
            // Perform any additional initialization here if needed
            return board;
        }
    }

}
