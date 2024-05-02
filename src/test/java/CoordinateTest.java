import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    @Test // Test coordinate initialization with parameters
    public void testCoordinateInitialization() {
        Coordinate coordinate = new Coordinate(3, 5);
        assertEquals(3, coordinate.getX(), "X coordinate should be 3");
        assertEquals(5, coordinate.getY(), "Y coordinate should be 5");
    }

    @Test // Test default coordinate initialization
    public void testDefaultCoordinateInitialization() {
        Coordinate coordinate = new Coordinate();
        assertEquals(0, coordinate.getX(), "X coordinate should be 0 by default");
        assertEquals(0, coordinate.getY(), "Y coordinate should be 0 by default");
    }

    @Test // Test setting the X coordinate
    public void testSetX() {
        Coordinate coordinate = new Coordinate();
        coordinate.setX(7);
        assertEquals(7, coordinate.getX(), "X coordinate should be 7 after setting it");
    }

    @Test // Test setting the Y coordinate
    public void testSetY() {
        Coordinate coordinate = new Coordinate();
        coordinate.setY(9);
        assertEquals(9, coordinate.getY(), "Y coordinate should be 9 after setting it");
    }

    @Test // Test equality of two Coordinate instances
    public void testCoordinateEquality() {
        Coordinate coordinate1 = new Coordinate(4, 6);
        Coordinate coordinate2 = new Coordinate(4, 6);
        assertEquals(coordinate1, coordinate2, "Coordinate instances with the same values should be equal");
    }

    @Test // Test inequality of two Coordinate instances
    public void testCoordinateInequality() {
        Coordinate coordinate1 = new Coordinate(1, 2);
        Coordinate coordinate2 = new Coordinate(3, 4);
        assertNotEquals(coordinate1, coordinate2, "Coordinate instances with different values should not be equal");
    }
}
