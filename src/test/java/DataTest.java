import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class DataTest {

    @Test // Test initializing a Turn object
    public void testTurnInitialization() {
        List<Integer> downedShips = new ArrayList<>(List.of(1, 2));
        List<String> downedLocations = new ArrayList<>(List.of("A1", "B2"));
        List<String> hitLocations = new ArrayList<>(List.of("C3"));

        Data.Turn turn = new Data.Turn(1, "A1 -> B2", 5, true, downedShips, downedLocations, hitLocations);

        assertEquals(1, turn.getTurnNum(), "Turn number should be 1");
        assertEquals("A1 -> B2", turn.getMove(), "Move should be 'A1 -> B2'");
        assertEquals(5, turn.getRisk(), "Risk should be 5");
        assertTrue(turn.getHit(), "Hit should be true");
        assertEquals(downedShips, turn.getDownedShips(), "Downed ships should be [1, 2]");
        assertEquals(downedLocations, turn.getDownedLocations(), "Downed locations should be ['A1', 'B2']");
        assertEquals(hitLocations, turn.getHitLocations(), "Hit locations should be ['C3']");
    }

    @Test // Test updating a Turn object
    public void testTurnSetters() {
        Data.Turn turn = new Data.Turn(); // Default constructor

        turn.setTurnNum(3);
        turn.setMove("C3 -> D4");
        turn.setRisk(2);
        turn.setHit(false);
        turn.setDownedShips(List.of(3));
        turn.setDownedLocations(List.of("D4"));
        turn.setHitLocations(List.of("C3"));

        assertEquals(3, turn.getTurnNum(), "Turn number should be 3");
        assertEquals("C3 -> D4", turn.getMove(), "Move should be 'C3 -> D4'");
        assertEquals(2, turn.getRisk(), "Risk should be 2");
        assertFalse(turn.getHit(), "Hit should be false");
        assertEquals(List.of(3), turn.getDownedShips(), "Downed ships should be [3]");
        assertEquals(List.of("D4"), turn.getDownedLocations(), "Downed locations should be ['D4']");
        assertEquals(List.of("C3"), turn.getHitLocations(), "Hit locations should be ['C3']");
    }

    @Test // Test adding a new turn to Data's list
    public void testAddNewTurn() {
        Data data = new Data(); // Create a Data instance
        Data.Turn turn = new Data.Turn(1, "A1 -> B1", 5, true, List.of(1), List.of("A1"), List.of("B1"));

        data.addNewTurn(data.getListOfTurns(), turn);

        List<Data.Turn> turns = data.getListOfTurns();

        assertEquals(1, turns.size(), "Data should contain one turn");
        assertEquals(turn, turns.get(0), "Turn should be as added");
    }

}
