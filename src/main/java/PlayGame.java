import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class PlayGame {
    public static void main(String[] args) {
        BattleshipGraphics graphics = new BattleshipGraphics();
        GameSetup setup = new GameSetup(graphics);
        Player player1 = setup.getPlayer1();
        Player player2 = setup.getPlayer2();

        new GameLoop(player1, player2, graphics);
    }
}
