import java.util.LinkedList;
import java.util.Random;

/* This class is designed to generate sudokus */
public class GenerateSudoku {
	
	/* Constants defined here for clarity */
	private final int NUMBER_ZERO = 0;
	private final int MAX_NUM_COLUMNS = 9;
	private final int MAX_NUM_ROWS = 9;

	/* Constructor */
	public GenerateSudoku() { 
		
	}
	
	/* Methods */
	/**
	 * Generates a 2D array of random numbers
	 * @return a random sudoku board
	 */
	public SudokuBoard generateRandomBoard() { 
		
		SudokuBoard randomBoard = new SudokuBoard();
		SolveSudoku sBoard = new SolveSudoku();
		Random rand = new Random();
		
		for (int rows = 0; rows < MAX_NUM_ROWS; rows++) {
			for (int columns = 0; columns < MAX_NUM_COLUMNS; columns++) {
				randomBoard.setCellNum(rand.nextInt(9), rows, columns);
				if (sBoard.isValid(randomBoard) == false) { 
					//randomBoard.setZero(rows, columns, NUMBER_ZERO);
					
				}
			}
		}

		
		return randomBoard; 
	}
	
//	public void checkGeneratedBoard (SudokuBoard gBoard) { 
//		
//		LinkedList<Integer> possibilities = null;
//		SolveSudoku sBoard = new SolveSudoku();
//		
//		int row = 0;
//		int column = 0;
//		int[] emptyCell = findEmptyCell(sBoard);
//		
//		sBoard.getPossibilities();
//	}	
		
	
	
}
