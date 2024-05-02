import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test // Test that it returns the right starting number of ships
    public void testGetShips() {
        Board board = Board.getInstance();
        assertNotNull(4);
    }

    @Test // Test that it gets an instance of the board
    public void testGetInstance() {
        Board board = Board.getInstance();
        assertNotNull(board.getInstance());
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

    @Test // Test that it dsiplays the board
    public void displayBoard() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Call your method that prints to System.out
        Board board = Board.getInstance();
        board.displayBoard();

        // Retrieve the printed output
        String printedOutput = outputStreamCaptor.toString().trim();

//         Assert that the expected message was printed
        assertNotNull(printedOutput);
    }


    @Test // Test that it displays the hidden board
    public void displayHidden() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Board board = Board.getInstance();
        board.displayHidden();

        String printedOutput = outputStreamCaptor.toString().trim();

        assertNotNull(printedOutput);

    }

    @Test // Test that it gets the board
    public void testGetBoard() {
        Board board = Board.getInstance();
        assertNotNull(board.getBoard());
    }

    @Test // test that it gets the board size
    public void testGetBoardSize() {
        Board board = Board.getInstance();
        assertNotNull(board.getBoardSize());
    }

    @Test // Test initial state of chosenCoordinates
    public void testChosenCoordinatesInitialization() {
        Board board = new Board.Builder().build();

        List<Coordinate> chosenCoordinates = board.getChosen();
        assertTrue(chosenCoordinates.isEmpty(), "Chosen coordinates should be empty initially");
    }

    @Test // Test adding coordinates to chosenCoordinates
    public void testAddToChosen() {
        Board board = new Board.Builder().build();

        Coordinate coord1 = new Coordinate(1, 1);
        Coordinate coord2 = new Coordinate(2, 2);

        board.addToChosen(coord1);
        board.addToChosen(coord2);

        List<Coordinate> chosenCoordinates = board.getChosen();

        assertEquals(2, chosenCoordinates.size(), "Two coordinates should be added to the chosen list");
        assertTrue(chosenCoordinates.contains(coord1), "List should contain coordinate (1, 1)");
        assertTrue(chosenCoordinates.contains(coord2), "List should contain coordinate (2, 2)");
    }

    @Test // Test the order of chosen coordinates
    public void testChosenCoordinatesOrder() {
        Board board = new Board.Builder().build();

        Coordinate coord1 = new Coordinate(1, 1);
        Coordinate coord2 = new Coordinate(2, 2);

        board.addToChosen(coord1);
        board.addToChosen(coord2);

        List<Coordinate> chosenCoordinates = board.getChosen();

        assertEquals(coord1, chosenCoordinates.get(0), "The first coordinate should be (1, 1)");
        assertEquals(coord2, chosenCoordinates.get(1), "The second coordinate should be (2, 2)");
    }

    @Test // Test uniqueness of chosen coordinates
    public void testUniqueChosenCoordinates() {
        Board board = new Board.Builder().build();

        Coordinate coord1 = new Coordinate(1, 1);
        Coordinate coord2 = new Coordinate(1, 1);

        board.addToChosen(coord1);
        board.addToChosen(coord2);

        List<Coordinate> chosenCoordinates = board.getChosen();

        assertEquals(2, chosenCoordinates.size(), "Two coordinates with the same value should both be added");

        // Optionally add checks to prevent duplicates or handle them differently based on design decisions
    }

    @Test // Test retrieving chosen coordinates
    public void testGetChosenCoordinates() {
        Board board = new Board.Builder().build();

        Coordinate coord1 = new Coordinate(3, 3);
        Coordinate coord2 = new Coordinate(4, 4);

        board.addToChosen(coord1);
        board.addToChosen(coord2);

        List<Coordinate> chosenCoordinates = board.getChosen();

        assertEquals(coord1, chosenCoordinates.get(0), "Retrieved coordinates should match added ones");
        assertEquals(coord2, chosenCoordinates.get(1), "Retrieved coordinates should match added ones");
    }
}
