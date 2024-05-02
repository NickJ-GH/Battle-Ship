import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    Board board = new Board.Builder().build();
    PlayerStrategy strategy = new User();
    Player player1 = new Player(board, strategy);
    

    @Test // Test Player initialization
    public void playerCreation() {
        Board board = new Board.Builder().build();
        PlayerStrategy strategy = new User(); 
        Player player1 = new Player(board, strategy);

        assertNotNull(player1);
    }

    @Test // Test getBoard 
    public void testGetBoard() {
        assertNotNull(player1.getBoard());
    }

    @Test // Test getStrategy
    public void testGetStrategy() {
        assertNotNull(player1.getStrategy());
    }

    @Test // Test getIsAlive
    public void testIsAlive() {
        assertNotNull(player1.getIsAlive());
    }
}
