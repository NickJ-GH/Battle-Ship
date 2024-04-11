import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    @Test
    public void playerCreation() {
        Board board = new Board();
        Player player1 = new Player(board);

//        assertNotNull(player1);
    }
}
