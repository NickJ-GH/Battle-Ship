public class GameLoop {
    private Player player1;
    private Player player2;
    private Board player1Board;
    private Board player2Board;

    public GameLoop(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Board = player1.getBoard();
        this.player2Board = player2.getBoard();
        runGameLoop();
    }

    public void runGameLoop() {
        while (!gameOver()) {
            playerTurn(player1, player2Board, "Player 1");
            if (gameOver()) {
                break;
            }
            playerTurn(player2, player1Board, "Player 2");
        }
    }

    public void playerTurn(Player player, Board opponentBoard, String playerName) {
        System.out.println("** " + playerName + " turn **");
        System.out.println("Your board:");
        player.getBoard().displayBoard();
        System.out.println("Your opponent's board:");
        opponentBoard.displayHidden();
        player.turn(opponentBoard);
    }

    public boolean gameOver() {
        if (!player2.getIsAlive() && player1.getIsAlive()) {
            System.out.println("Player 1 wins! Congratulations!");
            return true;
        } else if (!player1.getIsAlive() && player2.getIsAlive()) {
            System.out.println("Player 2 wins! Better luck next time.");
            return true;
        }
        return false;
    }
}