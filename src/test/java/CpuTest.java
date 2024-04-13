import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CpuTest {
    @Test
    public void testTurn() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Cpu cpu = new Cpu();
        Board board = Board.getInstance();
        String printedOutput = outputStreamCaptor.toString().trim();
        assertNotNull(printedOutput);
    }
}
