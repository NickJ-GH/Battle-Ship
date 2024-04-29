//*  uses a strategy pattern for players, users, cpu, helped with PlayerStratagy

import java.util.Scanner;

class User implements PlayerStrategy {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void turn(Board opponent_board) {
        
        int row;
        int col;
        Coordinate coordinate;

        do {
            System.out.print("Enter row (0-9): ");
            row = scanner.nextInt();
            while (row < 0 || row >= Board.getBoardSize()) {
                System.out.print("Please re-enter a row (0-9): ");
                row = scanner.nextInt();
            }

            System.out.print("Enter column (0-9): ");
            col = scanner.nextInt();
            while (col < 0 || col >= Board.getBoardSize()) {
                System.out.print("Please re-enter a column (0-9): ");
                col = scanner.nextInt();
            }

            coordinate = new Coordinate(row, col);

            if (opponent_board.getChosen().contains(coordinate)) {
                System.out.println("You have already chosen this coordinate. Please choose another one.");
            }

        } while (opponent_board.getChosen().contains(coordinate));

        opponent_board.addToChosen(coordinate);

        opponent_board.hit(row, col);
    }

}
