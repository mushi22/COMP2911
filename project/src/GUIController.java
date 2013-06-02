
public class GUIController {

	/* Constants defined here for clarity */
	
	/* Constructor */
	public GUIController() { 
		
	}
	
	/* Main */
	public static void main(String[] args) throws InterruptedException {
		
		GUI g = new GUI();
		g.initialise();
	}
	
	/* Methods */
	/**
	 * Gets the read in numbers as a 2D array
	 * @return the 2D array with the sudoku values
	 */
	public SudokuBoard getBoard() { 
		
		SudokuFileReader sudokuFileReader = new SudokuFileReader();
		SudokuBoard board = new SudokuBoard();
		board = sudokuFileReader.readInFile();
		//board.printBoard();
		return board;
	}
	
	/** 
	 * Gets the solved array.
	 * @return the 2D solved array
	 */
	public SudokuBoard getSolvedBoardArray() { 
		
		SudokuFileReader sudokuFileReader = new SudokuFileReader();
		SudokuBoard Board = new SudokuBoard();
		Board = sudokuFileReader.readInFile();
		SolveSudoku tester = new SolveSudoku();
		Board = tester.recursiveBruteForceSolver(Board);
		return Board;	
	 }
	 
//   public static void testSolver()
//   {
//      SudokuFileReader sudokuFileReader = new SudokuFileReader();
//      SudokuBoard board = new SudokuBoard();
//      board = sudokuFileReader.readInFile();
//      SolveSudoku tester = new SolveSudoku();
//      board = tester.recursiveBruteForceSolver(board);
//      //System.out.print("solved\n");
//      //board.printBoard();
//   }

//   public static void testSolver()
//   {
//      SudokuFileReader sudokuFileReader = new SudokuFileReader();
//      SudokuBoard board = new SudokuBoard();
//      board = sudokuFileReader.readInFile();
//      SolveSudoku tester = new SolveSudoku();
//      board = tester.recursiveBruteForceSolver(board);
//      System.out.print("solved\n");
//      board.printBoard();
//   }


}
