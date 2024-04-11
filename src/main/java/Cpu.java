class Cpu extends Player {
    public Cpu(Board board) {
        super(board);
    }

    @Override
    public void turn(Board opponent_board) {
        //random choice implimentation
        int row = (int) (Math.random() * Board.getBoardSize());
        int col = (int) (Math.random() * Board.getBoardSize());
        opponent_board.hit(row, col);
    }
}
