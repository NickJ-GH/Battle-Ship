//*  

import java.util.Scanner;

public class Player {

    private Board board;

    public Player(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return this.board;
    }

    public void turn(Board opponent_board) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter row (0-4): ");
        int x = scanner.nextInt();

        System.out.print("Enter column (0-4): ");
        int y = scanner.nextInt();

        opponent_board.hit(x, y);
    }

    public Boolean getIsAlive() {
        if (this.board.getNumShips() > 0){
            return true;
        } else {
            return false;
        }
    }
}
