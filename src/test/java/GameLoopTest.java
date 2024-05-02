import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameLoopTest {
    Board board1 = Board.getInstance();
    Board board2 = Board.getInstance();
    PlayerStrategy strategy = new User();
    Player player1 = new Player(board1, strategy);
    Player player2 = new Player(board2, strategy);
    BattleshipGraphics graphics = new BattleshipGraphics();
    GameLoop gameLoop = GameLoop.getInstance(player1, player2, graphics);

    // @Test
    // public void testGameLoopInstantiation() {
    //     BattleshipGraphics graphics = new BattleshipGraphics(); // You need to provide actual BattleshipGraphics implementation
    //     GameSetup setup = new GameSetup(graphics);
    //     Player player1 = setup.getPlayer1();
    //     Player player2 = setup.getPlayer2();
    //     // Create a game loop
    //     GameLoop gameLoop = GameLoop.getInstance(player1, player2, graphics);

    //     // Verify that the instance variables are initialized correctly
    //     assertEquals(player1, gameLoop.getPlayer1());
    //     assertEquals(player2, gameLoop.getPlayer2());
    //     assertEquals(player1.getBoard(), gameLoop.getPlayer1Board());
    //     assertEquals(player2.getBoard(), gameLoop.getPlayer2Board());
    //     assertEquals(graphics, gameLoop.getGraphics());
    // }
   
//    @Test
//    public void testRun() {
//        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStreamCaptor));
//
//        game.runGameLoop();
////         Retrieve the printed output
//        String printedOutput = outputStreamCaptor.toString().trim();
//        assertNotNull(printedOutput);
//    }

//    @Test
//    public void testPlayerTurn() {
//        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStreamCaptor));
//
//        game.playerTurn(player1, board2, "Mark",1);
////         Retrieve the printed output
//        String printedOutput = outputStreamCaptor.toString().trim();
//        assertNotNull(printedOutput);
//    }
//
//    @Test
//    public void testGameOver() {
//        assertNotNull(game.gameOver());
//    }
}
