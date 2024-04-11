//*  uses a strategy pattern for players, users, cpu, helped with PlayerStratagy

import java.util.Scanner;

public class Player {

    private Board board;
    private PlayerStrategy strategy;

    public Player(Board board, PlayerStrategy strategy) {
        this.board = board;
        this.strategy = strategy;
    }

    public Board getBoard() {
        return this.board;
    }

    public void turn(Board opponentBoard) {
        strategy.turn(opponentBoard);
    }

    public PlayerStrategy getStrategy() {
        return this.strategy;
    }

    // public void turn(Board opponent_board) {
    //     // leaving this code in but it should be overwritten by both Cpu and User classes

    //     Scanner scanner = new Scanner(System.in);

    //     System.out.print("Enter row (0-4): ");
    //     int x = scanner.nextInt();

    //     System.out.print("Enter column (0-4): ");
    //     int y = scanner.nextInt();

    //     opponent_board.hit(x, y);
    // }

    public Boolean getIsAlive() {
        return this.board.getNumShips() > 0;
    }
}



