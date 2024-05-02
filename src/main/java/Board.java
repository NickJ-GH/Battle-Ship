//* Builder design pattern

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private static final int BOARD_SIZE = 10;
    private char[][] board;
    private List<Coordinate> chosenCoordinates;
    private int numShips;

    private static Board instance;

    private Board(Builder builder) {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        this.chosenCoordinates = builder.chosenCoordinates;
        this.numShips = builder.numShips;
        initializeBoard();
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Builder().build();
        }
        return instance;
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            Arrays.fill(board[i], '~');
        }
    }

    public static class Builder {
        private List<Coordinate> chosenCoordinates = new ArrayList<>();
        private int numShips = 4;

        public Builder addChosenCoordinate(Coordinate coordinate) {
            this.chosenCoordinates.add(coordinate);
            return this;
        }

        public Builder setNumShips(int numShips) {
            this.numShips = numShips;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }

    public int getNumShips() {
        return this.numShips;
    }

    public void placeShip(int row, int col) {
        if (board[row][col] == '~') {
            board[row][col] = 'O';
        }
    }

    public boolean hit(int row, int col) {
        if (board[row][col] == 'O') {
            System.out.println("Hit!");
            board[row][col] = 'H';
            numShips--;
            return true;
        } else {
            System.out.println("Miss");
        }
        board[row][col] = 'M';
        return false;
    }

    public void addToChosen(Coordinate coordinate) {
        chosenCoordinates.add(coordinate);
    }

    public List<Coordinate> getChosen() {
        return chosenCoordinates;
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
            for (int j = 0; i < BOARD_SIZE; i++) {
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

    public static int getBoardSize() {
        return BOARD_SIZE;
    }
}
