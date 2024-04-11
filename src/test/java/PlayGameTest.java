import org.junit.jupiter.api.Test;

public class PlayGameTest {

    @Test
    public void playGameTest() {
        Board player1_board = new Board();
        Board player2_board = new Board();

        PlayerStrategy player1Strategy = new User(); 
        PlayerStrategy player2Strategy = new User(); 

        Player player1 = new Player(player1_board, player1Strategy);
        Player player2 = new Player(player2_board, player2Strategy);

        PlayGame game = new PlayGame(player1, player2);
    }

}
