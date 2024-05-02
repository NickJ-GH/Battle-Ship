import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShipPlacementTest {

    @Test
    public void testPlace() {
        InputStream inputStream = new ByteArrayInputStream("0\n0\n1\n1\n2\n2\n3\n3\n4\n4\n".getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Board board = new Board.Builder().build();

        ShipPlacement.placeShips(board);

        // Check if the prompts are present in the output
        String output = outContent.toString();
        assertTrue(output.contains("Enter row number for ship 1 (0-9):"));
        assertTrue(output.contains("Enter column number for ship 1 (0-9):"));
        assertTrue(output.contains("Enter row number for ship 2 (0-9):"));
        assertTrue(output.contains("Enter column number for ship 2 (0-9):"));
        assertTrue(output.contains("Enter row number for ship 3 (0-9):"));
        assertTrue(output.contains("Enter column number for ship 3 (0-9):"));
        assertTrue(output.contains("Enter row number for ship 4 (0-9):"));
        assertTrue(output.contains("Enter column number for ship 4 (0-9):"));
    }

    @Test
    public void testPlaceRandomly() {
        Board board = new Board.Builder().build();
        ShipPlacement.placeShipsRandomly(board);

        assertEquals(board.getNumShips(), 4);
    }

}
