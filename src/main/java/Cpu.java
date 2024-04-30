//*  uses a strategy pattern for players, users, cpu, helped with PlayerStratagy

class Cpu implements PlayerStrategy {

    @Override
    public void turn(Board opponent_board) {
        //random choice implimentation

        int row = 0;
        int col = 0;
        Coordinate cordinate = new Coordinate(0, 0);

        do{
            row = (int) (Math.random() * Board.getBoardSize());
            col = (int) (Math.random() * Board.getBoardSize());

            cordinate.setX(row);
            cordinate.setY(col);

        } while (opponent_board.getChosen().contains(cordinate));

        opponent_board.addToChosen(cordinate);
        opponent_board.hit(row, col);
    }
}
