import java.util.LinkedList;
import java.util.Random;

/* This class is designed to generate sudokus */
public class GenerateSudoku {
	
	/* Constants defined here for clarity */
	private final int NUMBER_ZERO = 0;
	private final int MAX_NUM_COLUMNS = 9;
	private final int MAX_NUM_ROWS = 9;

	private SudokuBoard board = new SudokuBoard();
	/* Constructor */
	public GenerateSudoku() { 
		
	}
	
	public SudokuBoard getBoard(){
		return this.board;
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
					if ()
					randomBoard.setCellNum(rand.nextInt(9), rows, columns);
				}
			}
		}

		
		return randomBoard; 
	}
	
	public boolean noDupes(SudokuBoard sBoard) {
		
		
		
	    for (int i=0; i < MAX_NUM_ROWS ; i++) {
	        HashSet<Integer> set = new HashSet<Integer>();
	        for (int j=0; j < array.length; j++) {
	            if (set.contains(array[j][i])) return false;
	            set.add(array[j][i]);
	        }
	    }
	    return true;
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
		
//	private void digging (int number){
//		
//		int c = 0;
//		int depth = 0;
//		
//		while(depth < number){
//			int a = randomNumber();
//			int b = randomNumber();
//			if(board.getCellNum(a, b)  || !board.getCellNum(a, b).equals(0)) {
//				if(board.getCellNum(a, b) == null){
//					c=0;
//				}
//			}
//		}
//		
//		
//	}
//	
//	private int randomNumber(){
//		Random random = new Random();
//		return random.nextInt(9);
//	}
	
	
}
