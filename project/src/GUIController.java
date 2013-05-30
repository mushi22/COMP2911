
public class GUIController {

	/* Constants defined here for clarity */
	private int board[][];
	
	/* Constructor */
	public GUIController() { 
		
	}
	
	/* Methods */
	/**
	 * Gets the read in numbers as a 2D array
	 * @return the 2D array with the sudoku values
	 */
	public int[][] getBoardArray() { 
		
		SudokuFileReader sudokuFileReader = new SudokuFileReader();
		board = sudokuFileReader.readInFile();
		
		return board;
	}

}
