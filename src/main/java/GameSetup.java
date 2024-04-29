import java.util.Scanner;

public class GameSetup {
    private Player player1;
    private Player player2;
    private Board player1Board;
    private Board player2Board;

    public GameSetup() {
        this.player1Board = new Board.Builder()
            .withNumShips(4)
            .build();
        this.player2Board = new Board.Builder()
            .withNumShips(4)
            .build();
        this.player1 = new Player(player1Board, new User());
        chooseGameMode();
        placeShips();
    }

    private void chooseGameMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose game mode:");
        System.out.println("1. Player vs CPU");
        System.out.println("2. Player vs Player");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            this.player2 = new Player(player2Board, new Cpu());
        } else {
            this.player2 = new Player(player2Board, new User());
        }
    }

    private void placeShips() {
        System.out.println("Player 1, place your ships on your board!");
        ShipPlacement.placeShips(player1Board);
        player1Board.displayBoard();

        if (player2.getStrategy() instanceof User) {
            System.out.println("Player 2, place your ships on your board!");
            ShipPlacement.placeShips(player2Board);
            player2Board.displayBoard();
        } else {
            System.out.println("CPU is placing its ships...");
            ShipPlacement.placeShipsRandomly(player2Board);
            System.out.println("CPU has placed its ships.");
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}