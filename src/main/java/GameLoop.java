public class GameLoop {
    private Player player1;
    private Player player2;
    private Board player1Board;
    private Board player2Board;

    private BattleshipGraphics graphics;

    public GameLoop(Player player1, Player player2, BattleshipGraphics graphics) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Board = player1.getBoard();
        this.player2Board = player2.getBoard();
        this.graphics = graphics;
        runGameLoop();
    }

    public void runGameLoop() {
        while (!gameOver()) {
            playerTurn(player1, player2Board, "Player 1", 1);
            if (gameOver()) {
                break;
            }
            playerTurn(player2, player1Board, "Player 2", 2);
        }
    }

    public void playerTurn(Player player, Board opponentBoard, String playerName, int player_num) {
//        System.out.println("** " + playerName + " turn **");
//        System.out.println("Your board:");
//        player.getBoard().displayBoard();
//        System.out.println("Your opponent's board:");
//        opponentBoard.displayHidden();
        graphics.turnDialog(player_num);
//        player.turn(opponentBoard);
    }

    public boolean gameOver() {
        if (!player2.getIsAlive() && player1.getIsAlive()) {
            System.out.println("Player 1 wins! Congratulations!");
            graphics.gameOver(1);
            return true;
        } else if (!player1.getIsAlive() && player2.getIsAlive()) {
            System.out.println("Player 2 wins! Better luck next time.");
            graphics.gameOver(2);
            return true;
        }
        return false;
    }
}