// Data Class
// Adapter pattern: takes the battleship game and makes it recognizable to RF/DT 
// Encapsulation: the turn class makes sure if the output of the game is weird we can still give understandable info to the RF/DT

import java.util.*;

public class Data {
   
    public static class Turn {
        private int turnNum;
        private String move;
        private int risk;
        private boolean hit;
        private List<Integer> downedShips;
        private List<String> downedLocations;
        private List<String> hitLocations;
    
        public Turn() {
        }

        public Turn(int turnNum, String move, int risk, boolean hit, List<Integer> downedShips, List<String> downedLocations, List<String> hitLocations) {
            this.turnNum = turnNum;
            this.move = move;
            this.risk = risk;
            this.hit = hit;
            this.downedShips = downedShips;
            this.downedLocations = downedLocations;
            this.hitLocations = hitLocations;
        }
    
        public int getTurnNum() {
            return turnNum;
        }
    
        public String getMove() {
            return move;
        }

        public int getRisk() {
            return risk;
        }
    
        public Boolean getHit() {
            return hit;
        }
    
        public List<Integer> getDownedShips() {
            return downedShips;
        }
    
        public List<String> getDownedLocations() {
            return downedLocations;
        }

        public List<String> getHitLocations() {
            return hitLocations;
        }
    
        public void setTurnNum(int turnNum) {
            this.turnNum = turnNum;
        }
    
        public void setMove(String move) {
            this.move = move;
        }

        public void setRisk(int risk) {
            this.risk = risk;
        }
    
        public void setHit(boolean hit) {
            this.hit = hit;
        }
    
        public void setDownedShips(List<Integer> downedShips) {
            this.downedShips = downedShips;
        }

        public void setDownedLocations(List<String> downedLocations) {
            this.downedLocations = downedLocations;
        }  

        public void setHitLocations(List<String> hitLocations) {
            this.hitLocations = hitLocations;
        }    

    }

    private ArrayList<Turn> listOfTurns;

    public Data() {
        listOfTurns = new ArrayList<>();
    }
    
    public ArrayList<Turn> getListOfTurns() {
        return listOfTurns;
    }

    public void addNewTurn (ArrayList<Turn> listOfTurns, Turn turn) {
        listOfTurns.add(turn);
    }

    // Takes output of battleship and converts it to useful input for DT/RF
    public Turn gameStateToInputs(int turnNum, String move, Boolean hit, List<Integer> downedShips, List<String> downedLocations, ArrayList<String> opponentBoard) {
        Turn turn = new Turn();
        turn.setTurnNum(turnNum);
        turn.setMove(move);
        turn.setHit(hit);
        turn.setDownedShips(downedShips);
        turn.setDownedLocations(downedLocations);

        // risk: how many hits before all opponents ships are destroyed
        // hitLocations: hits that are not downed ships
        int risk = 17;
        List<String> hitLocations = new ArrayList<>();

        for (String row : opponentBoard) {
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == 'X') {
                    String location = row + i;
                    if (!downedLocations.contains(location)) {
                        hitLocations.add(location);
                    }
                    risk --;
                }
            }
        }

        turn.setRisk(risk);
        turn.setHitLocations(hitLocations);
        return(turn);
    }

    // Plays a game of battleship with two random opponents, creates data object
    public ArrayList<Turn> playTrainingGame(List<String> initialBoardSetup) {
        Data gameDataPlayer1 = new Data();
        Data gameDataPlayer2 = new Data();
        Boolean player1Wins = false;

        // This function plays a game with two random players
        /* At each turn, the following is collected and sent to gameStateToInputs. x represent player's number. 
         * int turnNumx 
         * String movex 
         * Boolean hitx
         * List<Integer> downedShipsx (opponents)
         * List<String> downedLocationsx (opponents)
         * ArrayList<String> opponentBoardx
         */
        BattleshipGraphics graphics = new BattleshipGraphics();
        GameSetup setup = new GameSetup(graphics);
        Player player1 = setup.getPlayer1();
        Player player2 = setup.getPlayer2();

        GameLoop gameLoop = GameLoop.getInstance(player1, player2, graphics);

    
        // Return the winning player's "strategy"
        if(player1Wins) {
            return gameDataPlayer1.getListOfTurns();
        }
        // This also includes the case of a tie
        else
        {
            return gameDataPlayer2.getListOfTurns();
        }

    }
    
}

// TODO: THIS NEEDS TO GO IN A DIFFERENT FILE, it is for training 
/* Main
 * playTrainingGame for x different initial board setups
 * result of each game: turns_x 
 * for turn in turns_x{DataObjectx.append(gameStateToInputs(turn))}
 */

//  public static void main(String[] args) {
//     Data trainingData = new Data();
//     int numTrainingGames = 100;
//     ArrayList<String> initialBoardSetups = [['setup1'], ['setup2'], ['etc']];

//     // Playing training games for different initial board setups
//     // Initial setups for both players will be random b/c that's the best strategy
//     for (int i = 0; i < numTrainingGames; i++) {
//         // Simulating a training game and appending the turns to the training data
//         ArrayList<Turn> turns = data.playTrainingGame(initialBoardSetups[i]);
//         trainingData.add(turns);
//     }
//     // Using transformedData to train models
// }