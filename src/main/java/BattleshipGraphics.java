import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BattleshipGraphics extends JFrame {

    public enum MouseClickMode {
        PLAYER_1_PLACE,
        PLAYER_2_PLACE,
        PLAYER_1_HIT,
        PLAYER_2_HIT
    }

    public int player = 1;

    private int maxClicks = 0;

    private int selectedOption;

    private int spacesClicked = 0;

    private MouseClickMode currentMode = MouseClickMode.PLAYER_1_PLACE;

    private static final int GRID_SIZE = 10;
    private static final int NUM_SHIPS = 1;

    private JLabel[][] gridLabels;
    private int shipsRemaining;

    private ArrayList<Integer> shipLocation;

    public Board board1;

    public Board board2 = new Board();
    public BattleshipGraphics() {
        setTitle("Battleship Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for the game grid with GridLayout
        JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        gridLabels = new JLabel[GRID_SIZE][GRID_SIZE];
        initializeGrid(gridPanel);

        // Add the grid panel to the content pane
        getContentPane().add(gridPanel, BorderLayout.CENTER);

        // Set frame size based on grid size (plus padding for title bar)
        int gridSizePixels = 400; // Adjust size as needed
        setSize(gridSizePixels, gridSizePixels + 50); // Adding extra height for title bar

        setLocationRelativeTo(null);
        setVisible(true);

        startGame();
    }

    public void setMouseClickMode(MouseClickMode mode) {
        this.currentMode = mode;
    }

    private void initializeGrid(JPanel gridPanel) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBackground(Color.BLUE); // Default ocean color
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.addMouseListener(new GridMouseListener(row, col));
                gridPanel.add(label); // Add label to grid panel
                gridLabels[row][col] = label;
            }
        }
    }

    private void startGame() {
        JOptionPane.showMessageDialog(this, "Welcome to Battleship!");
    }

    public void placeShipsDialog(int player, Board board) {

        if (player == 1) {
            this.board1 = board;
        } else {
            this.board2 = board;
        }

        if (player == 2) {
            // Create a panel for the game grid with GridLayout
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int col = 0; col < GRID_SIZE; col++) {
                    JLabel label = gridLabels[row][col];
                    label.setBackground(Color.BLUE);
                    label.addMouseListener(new GridMouseListener(row, col));
                }
            }
        }

        String message = "Player " + player + " , place your ships.";
        JOptionPane.showMessageDialog(this, "Click anywhere on the grid to place your ship",
                message, JOptionPane.INFORMATION_MESSAGE);

        if (player == 1) {
            this.currentMode = MouseClickMode.PLAYER_1_PLACE;
        } else {
            this.currentMode = MouseClickMode.PLAYER_2_PLACE;
        }
        this.maxClicks = 4;
        this.spacesClicked = 0;
        waitForClick();
    }

    public void placeCPUDialog() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                JLabel label = gridLabels[row][col];
                label.setBackground(Color.BLUE);
            }
        }
        ShipPlacement.placeShipsRandomly(this.board2);
        JOptionPane.showMessageDialog(this, "CPU will now place its ships.", "Your ships are placed", JOptionPane.INFORMATION_MESSAGE);
    }

    public void turnDialog(int player) {
        this.spacesClicked = 0;
        this.maxClicks = 1;

        String title = "Player" + player;
        JOptionPane.showMessageDialog(this, "Click anywhere to shoot a cannon", title, JOptionPane.INFORMATION_MESSAGE);

        if (player == 1) {
            this.currentMode = MouseClickMode.PLAYER_1_HIT;
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int col = 0; col < GRID_SIZE; col++) {
                    JLabel label = gridLabels[row][col];
                    if (this.board2.getBoard()[row][col] == 'M') {
                        label.setBackground(Color.WHITE);
                    }
                    else if (this.board2.getBoard()[row][col] == 'H') {
                        label.setBackground(Color.RED);
                    } else {
                        label.setBackground(Color.BLUE);
                    }
                    label.addMouseListener(new GridMouseListener(row, col));
                }
            }
        } else if (selectedOption == 1) {
            this.currentMode = MouseClickMode.PLAYER_2_HIT;
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int col = 0; col < GRID_SIZE; col++) {
                    JLabel label = gridLabels[row][col];
                    if (this.board1.getBoard()[row][col] == 'M') {
                        label.setBackground(Color.WHITE);
                    } else if (this.board1.getBoard()[row][col] == 'H') {
                        label.setBackground(Color.RED);
                    } else {
                        label.setBackground(Color.BLUE);
                    }
                    label.addMouseListener(new GridMouseListener(row, col));
                }
            }
        } else {
            int row = (int) (Math.random() * Board.getBoardSize());
            int col = (int) (Math.random() * Board.getBoardSize());

            handleTurn(row, col, 2);

        }
        waitForClick();
    }

    private void handleShipPlacement(int row, int col, int player) {
        if (spacesClicked < maxClicks) {
            JLabel clickedLabel = gridLabels[row][col];
            clickedLabel.setBackground(Color.GREEN);
            spacesClicked++;

            if (player == 1) {
                board1.placeShip(row, col);
            } else {
                board2.placeShip(row, col);
            }

            if (spacesClicked == maxClicks) {
                disableFurtherClicks();
            }
        }
    }

    private void handleTurn(int row, int col, int player) {
        if (spacesClicked < maxClicks) {
            JLabel clickedLabel = gridLabels[row][col];

            if (player == 1) {
                if (board2.hit(row, col)) {
                    clickedLabel.setBackground(Color.RED);
                    JOptionPane.showMessageDialog(this, "Hit", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    clickedLabel.setBackground(Color.WHITE);
                    JOptionPane.showMessageDialog(this, "Miss", "", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                if (board1.hit(row, col)) {
                    clickedLabel.setBackground(Color.RED);
                    JOptionPane.showMessageDialog(this, "Hit", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    clickedLabel.setBackground(Color.WHITE);
                    JOptionPane.showMessageDialog(this, "Miss", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            spacesClicked++;

            if (player == 1) {
                board1.placeShip(row, col);
            } else {
                board2.placeShip(row, col);
            }

            if (spacesClicked == maxClicks) {
                disableFurtherClicks();
            }
        }
    }

    private void waitForClick() {
        while (spacesClicked < maxClicks) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void disableFurtherClicks() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                gridLabels[row][col].removeMouseListener(gridLabels[row][col].getMouseListeners()[0]);
            }
        }
    }

    public void gameOver(int player) {
        if (selectedOption == 1) {
            String message = "Player " + player + " wins!";
            JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        } else if (player == 1){
            JOptionPane.showMessageDialog(this, "Congratulations! You sank all the ships!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Boo! CPU wins.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
        dispose();
    }


//    private class GridMouseListener extends MouseAdapter {
//        private int row;
//        private int col;
//
//        public GridMouseListener(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            handleGuess(row, col);
//        }
//    }

    public int chooseGameMode() {
        String[] options = {"Player vs. CPU", "Player vs. Player"};
        int selectedOption = JOptionPane.showOptionDialog(this,
                "Choose a Game Mode", "Game Mode Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        this.selectedOption = selectedOption;
        return selectedOption;
    }

    private class GridMouseListener extends MouseAdapter {
        private int row;
        private int col;

        public GridMouseListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel clickedLabel = (JLabel) e.getSource();

            switch (currentMode){
                case PLAYER_1_PLACE:
                    handleShipPlacement(row, col, 1);
                    break;
                case PLAYER_2_PLACE:
                    handleShipPlacement(row, col, 2);
                    break;
                case PLAYER_1_HIT:
                    handleTurn(row, col, 1);
                    break;
                case PLAYER_2_HIT:
                    handleTurn(row, col, 2);
                    break;
                default:
                    break;
            }
            // Handle ship placement logic here (e.g., change label color, store ship location)
            clickedLabel.setBackground(Color.GREEN); // Example: Change color to indicate ship placement
        }
    }

    public Board getBoard1() {
        return this.board1;
    }

    public Board getBoard2() {
        return this.board2;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BattleshipGraphics::new);
    }
}
