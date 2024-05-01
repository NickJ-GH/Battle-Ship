import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    public void testTurn() {
        InputStream inputStream = new ByteArrayInputStream("1\n1\n".getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Board board = new Board.Builder().build();
        User user = new User();

        user.turn(board);

        // Check if the prompts are present in the output
        String output = outContent.toString();
        assertTrue(output.contains("Enter row (0-9):"));
        assertTrue(output.contains("Enter column (0-9):"));
    }
}
