import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test // Both Instances should be the same
    public void testSingletonInstance() {
        Board board1 = Board.getInstance();
        Board board2 = Board.getInstance();
        assertSame(board1, board2, "Both instances should be the same");
    }

    @Test // the board instance is not null
    public void testBoardInitialization() {
        Board board = Board.getInstance();
        assertEquals(Board.getBoardSize(), 10, "Board size should be 10");
        assertNotNull(board, "Board instance should not be null");
    }

    @Test // test the 'placeShip' function
    public void testPlaceShip() {
        Board board = Board.getInstance();
        board.placeShip(1, 1);
        assertEquals(board.getNumShips(), 4, "Number of ships should remain unchanged");
    }

    @Test // test the 'hit' function works properly
    public void testHit() {
        Board board = Board.getInstance();
        board.placeShip(2, 2);
        board.hit(2, 2);
        assertEquals(board.getNumShips(), 3, "Number of ships should decrease by 1");
    }
}
