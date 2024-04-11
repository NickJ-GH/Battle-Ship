import java.util.Scanner;

class User extends Player {

    private Scanner scanner = new Scanner(System.in);

    public User(Board board) {
        super(board);
    }

    @Override
    public void turn(Board opponent_board) {
        System.out.print("Enter row (0-9): ");
        int row = scanner.nextInt();
        while(row > 9 || row < 0){
            System.out.print("Please re-enter a row (0-9): ");
            row = scanner.nextInt();
        }

        System.out.print("Enter column (0-9): ");
        int col = scanner.nextInt();
        while(col > 9 || col < 0){
            System.out.print("Please re-enter a col (0-9): ");
            col = scanner.nextInt();
        }

        opponent_board.hit(row, col);
    }

}