
/* This class defines a plain sudoku board for values to be added */
public class SudokuBoard {

	/* Constants defined here for clarity */
	private int sBoard[][];		// this represents the 9x9 board
	//private static final int MAX_NUM_COLUMNS = 8;
	//private static final int MAX_NUM_ROWS = 8;

	/* Constructor */
	/*
	 * This one creates a new board
	 */
	public SudokuBoard() { 
		this.sBoard = new int[9][9];
	}
	
	/*
	 * This one constructs a board with a give board
	 */
	public SudokuBoard(int board[][]) { 
		
		this.sBoard = board;
	}
	
	/* Methods */
	/**
	 * Prints the sudoku board
	 */
	public void printBoard () {
		for (int i = 0; i < sBoard.length; i++) {
			for (int j = 0; j < sBoard[i].length; j++) {
				System.out.print(sBoard[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
      System.out.print("\n");
	}
	
	/**
	 * Gets the board 
	 * @return
	 */
	public int[][] getBoardArray() { 
		
		return sBoard;
	}
	
	/**
	 * Gets the cell number
	 * @param row
	 * @param column
	 * @return provide the number at the given row and column
	 */
	public int getCellNum(int row, int column){
		
		return sBoard[row][column];
	}
	
	/**
	 * Sets the cell number 
	 * @param newnum
	 * @param row
	 * @param column
	 */
	public void setCellNum(int newnum, int row, int column){
		
		sBoard[row][column] = newnum;
	}
	
	
}
