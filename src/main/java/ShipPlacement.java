import java.util.Scanner;

public class ShipPlacement {
    private static final int NUM_SHIPS = 4;

    public static void placeShips(Board board) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM_SHIPS; i++) {
            System.out.println("Enter row number for ship " + (i + 1) + " (0-9):");
            int row = scanner.nextInt();
            System.out.println("Enter column number for ship " + (i + 1) + " (0-9):");
            int col = scanner.nextInt();
            board.placeShip(row, col);
        }
    }

    public static void placeShipsRandomly(Board board) {
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