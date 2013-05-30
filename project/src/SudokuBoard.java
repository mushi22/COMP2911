
/* This class defines a plain sudoku board for values to be added */
public class SudokuBoard {

	/* Constants defined here for clarity */
	private int board[][];		// this represents the 9x9 board
	private static final int MAX_NUM_COLUMNS = 8;
	private static final int MAX_NUM_ROWS = 8;
	
	/* Constructor */
	public SudokuBoard () { 
		// initialising the board
		this.board = new int[8][8];
		
	}
	
	public void printBoard () {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
				System.out.println(" ");
			}
		}
	}
}
