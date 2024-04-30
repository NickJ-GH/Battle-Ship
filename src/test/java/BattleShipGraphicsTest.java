import org.junit.jupiter.api.Test;

import javax.swing.*;

public class BattleShipGraphicsTest {

    @Test
    public void testRun() {
        SwingUtilities.invokeLater(BattleshipGraphics::new);
    }
}
