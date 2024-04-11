import org.junit.jupiter.api.Test;

public class PlayGameTest {

    @Test
    public void playGameTest() {
        Board player1_board = new Board();
        Board player2_board = new Board();

        Player player1 = new Player(player1_board);
        Player player2 = new Player(player2_board);

        PlayGame game = new PlayGame(player1, player2);
    }

}
