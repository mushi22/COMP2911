
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
	 * Gets the randomly generated board.
	 * @return board that has been randomly generated
	 */
	public SudokuBoard getGeneratedBoard() {
		
		GenerateSudoku gBoard = new GenerateSudoku();
		SudokuBoard sBoard = new SudokuBoard();
		sBoard = gBoard.generateRandomBoard();
		//sBoard.printBoard();
		
		return sBoard;
	}

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
