import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameLoopTest {
    Board board1 = Board.getInstance();
    Board board2 = Board.getInstance();
    PlayerStrategy strategy = new User();
    Player player1 = new Player(board1, strategy);
    Player player2 = new Player(board2, strategy);
    BattleshipGraphics graphics = new BattleshipGraphics();
    GameLoop game = new GameLoop(player1, player2, graphics );

    @Test
    public void testGameLoopInstantiation() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        GameLoop game = new GameLoop(player1, player2, graphics );
//         Retrieve the printed output
        String printedOutput = outputStreamCaptor.toString().trim();
        assertNotNull(printedOutput);
    }

    @Test
    public void testRun() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        game.runGameLoop();
//         Retrieve the printed output
        String printedOutput = outputStreamCaptor.toString().trim();
        assertNotNull(printedOutput);
    }

    @Test
    public void testPlayerTurn() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        game.playerTurn(player1, board2, "Mark",1);
//         Retrieve the printed output
        String printedOutput = outputStreamCaptor.toString().trim();
        assertNotNull(printedOutput);
    }
//
    @Test
    public void testGameOver() {
        assertNotNull(game.gameOver());
    }
}
