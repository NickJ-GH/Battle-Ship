import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        GameSetup setup = new GameSetup();
        Player player1 = setup.getPlayer1();
        Player player2 = setup.getPlayer2();

        new GameLoop(player1, player2);
    }
}
