
public class GUIController {

	/* Constants defined here for clarity */
	
	/* Constructor */
	public GUIController() { 
		
	}
	
	/* Main */
	public static void main(String[] args) {
		
		GUI g = new GUI();
		g.initialise();
		testSolver();
	}
	
	/* Methods */
	/**
	 * Gets the read in numbers as a 2D array
	 * @return the 2D array with the sudoku values
	 */
	public SudokuBoard getBoardArray() { 
		
		SudokuFileReader sudokuFileReader = new SudokuFileReader();
		SudokuBoard board = new SudokuBoard();
		board = sudokuFileReader.readInFile();
		board.printBoard();
		return board;
	}
	
   public static void testSolver()
   {
      SudokuFileReader sudokuFileReader = new SudokuFileReader();
      SudokuBoard board = new SudokuBoard();
      board = sudokuFileReader.readInFile();
      SolveSudoku tester = new SolveSudoku();
      board = tester.recursiveBruteForceSolver(board);
      System.out.print("solved\n");
      board.printBoard();
   }


}
