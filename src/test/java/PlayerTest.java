import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    @Test
    public void playerCreation() {
        Board board = new Board();
        PlayerStrategy strategy = new User(); 
        Player player1 = new Player(board, strategy);

        assertNotNull(player1);
    }
}
