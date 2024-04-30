import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTurnTest {

    @Test
    public void testPlayer2HitsPlayer1Ship() {
        Board player1Board = new Board.Builder().build();
        Board player2Board = new Board.Builder().build();

        PlayerStrategy player1Strategy = new User(); // Use User or Cpu based on your needs
        PlayerStrategy player2Strategy = new User(); // Use User or Cpu based on your needs

        Player player1 = new Player(player1Board, player1Strategy);
        Player player2 = new Player(player2Board, player2Strategy);

        // Place a ship for Player 1 at position (0,0)
        player1Board.placeShip(0, 0);

        // Player 2 hits position (0,0)
        player2Strategy.turn(player1Board);

        // Check if Player 1's board has been updated correctly
        assertEquals('X', player1Board.getBoard()[0][0], "Player 2's hit should mark Player 1's ship as hit.");
    }
}
