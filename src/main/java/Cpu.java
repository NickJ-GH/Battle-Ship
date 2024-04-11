//*  uses a strategy pattern for players, users, cpu, helped with PlayerStratagy

class Cpu implements PlayerStrategy {

    @Override
    public void turn(Board opponent_board) {
        //random choice implimentation
        int row = (int) (Math.random() * Board.getBoardSize());
        int col = (int) (Math.random() * Board.getBoardSize());
        opponent_board.hit(row, col);
    }
}
