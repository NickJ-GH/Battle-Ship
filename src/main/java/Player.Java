// Player Class using the Builder Pattern

//player
     //color
     // number of ships
     // alive

//subclass user
//subclass cgp

public class Player{
    private final String color;
    private int number_of_ships;
    private Boolean is_alive;

     // Private constructor to enforce the use of the builder
    private Player(Builder builder) {
        this.color = builder.color;
        this.number_of_ships = builder.number_of_ships;
        this.is_alive = builder.is_alive;
    }

    // Getters for the fields
    public String getColor() {
        return color;
    }

    public int getNumber_of_Ships() {
        return number_of_ships;
    }

    public Boolean getIsAlive() {
        if (number_of_ships > 0){
            is_alive = true;
        } else {
            is_alive = false
        }

        return is_alive;
    }

    // Static nested Builder class
    public static class Builder {
        private String color;
        private int number_of_ships;
        private Boolean is_alive = true;

        // Setter methods for the builder
        public Builder setColor(String color) {
            this.color = color;
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