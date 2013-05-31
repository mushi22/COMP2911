
public class GUIController {

	/* Constants defined here for clarity */
	
	/* Constructor */
	public GUIController() { 
		
	}
	
	/* Main */
	public static void main(String[] args) {
		
		GUI g = new GUI();
		g.initialise();
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
		
		return board;
	}

}
