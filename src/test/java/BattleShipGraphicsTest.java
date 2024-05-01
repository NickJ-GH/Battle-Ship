import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BattleShipGraphicsTest {

    BattleshipGraphics graphics = new BattleshipGraphics();
    @Test
    public void testInit() {
        assertNotNull(graphics);
    }
}
