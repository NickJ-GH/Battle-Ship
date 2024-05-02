import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class CpuTest {
    @Test // Test turn
    public void testTurn() {

        Board opponent_board = new Board.Builder().build();
        Cpu cpu = new Cpu();

        cpu.turn(opponent_board);

        List<Coordinate> chosenCoordinates = opponent_board.getChosen();
        assertEquals(1, chosenCoordinates.size(), "One coordinate should be chosen on the opponent board");

        Coordinate chosenCoordinate = chosenCoordinates.iterator().next();
        assertTrue(chosenCoordinate.getX() >= 0 && chosenCoordinate.getX() < Board.getBoardSize(), "Chosen coordinate X should be valid");
        assertTrue(chosenCoordinate.getY() >= 0 && chosenCoordinate.getY() < Board.getBoardSize(), "Chosen coordinate Y should be valid");
    }
}
