import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameSetupTest {
    BattleshipGraphics graphics = new BattleshipGraphics();
    GameSetup setup = new GameSetup(graphics);
    @Test
    public void testInit() {
        assertNotNull(setup);
    }

    @Test
    public void testGetPlayer1() {
        assertNotNull(setup.getPlayer1());
    }

    @Test
    public void testGetPlayer2() {
        assertNotNull(setup.getPlayer2());
    }
}
