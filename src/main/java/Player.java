//*  uses a strategy pattern for players, users, cpu, helped with PlayerStratagy

import java.util.Scanner;

public class Player {

    private Board board;
    private PlayerStrategy strategy;

    public Player(Board board, PlayerStrategy strategy) {
        this.board = board;
        this.strategy = strategy;
    }

    public Board getBoard() {
        return this.board;
    }

    public void turn(Board opponentBoard) {
        strategy.turn(opponentBoard);
    }

    public PlayerStrategy getStrategy() {
        return this.strategy;
    }

    public Boolean getIsAlive() {
        return this.board.getNumShips() > 0;
    }
}



