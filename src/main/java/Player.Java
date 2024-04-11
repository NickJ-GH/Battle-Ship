// Player Class using the Builder Pattern

//player
     //color
     // number of ships
     // alive

//subclass user
//subclass cgp

import java.util.Scanner;

public class Player{
    private final String color;
    private int number_of_ships;
    private Boolean is_alive;

    private Board board;

     // Private constructor to enforce the use of the builder
    private Player(Builder builder) {
        this.color = builder.color;
        this.number_of_ships = builder.number_of_ships;
        this.is_alive = builder.is_alive;
        this.board = builder.board;
    }

    // Getters for the fields
    public String getColor() {
        return color;
    }

    public Board getBoard() {
        return this.board;
    }

    public void turn(Board opponent_board) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter row (0-4): ");
        int x = scanner.nextInt();

        System.out.print("Enter column (0-4): ");
        int y = scanner.nextInt();

        opponent_board.hit(x, y);
    }

    public int getNumber_of_Ships() {
        return number_of_ships;
    }

    public Boolean getIsAlive() {
        if (this.board.getNumShips() > 0){
            return true;
        } else {
            return false;
        }
    }

    // Static nested Builder class
    public static class Builder {
        private String color;
        private int number_of_ships;
        private Boolean is_alive = true;

        private Board board;

        // Setter methods for the builder
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }
        public Builder setNumber_of_Ships(int number_of_ships) {
            this.number_of_ships = number_of_ships;
            return this;
        }

        // Build method to create a new Player instance
        public Player build() {
            return new Player(this);
        }
    }

    // toString method for printing player details
    @Override
    public String toString() {
        return "Player{" +
                "color = '" + color + "\'" + ", has "
                + number_of_ships + " ships, and isAlive = '"
                + is_alive + '\'' +
                '}';
    }
   
}