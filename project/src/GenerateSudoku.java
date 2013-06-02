import java.util.Random;

/* This class is designed to generate sudokus */
public class GenerateSudoku {
	
	/* Constants defined here for clarity */
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
		SolveSudoku solver = new SolveSudoku();
		Random rand = new Random();
		
		for (int rows = 0; rows < MAX_NUM_ROWS; rows++) {
			for (int columns = 0; columns < MAX_NUM_COLUMNS; columns++) {
				randomBoard.setCellNum(rand.nextInt(9), rows, columns);
				if (solver.isValid(randomBoard) == false) { 
					randomBoard.setCellNum(0, rows, columns);
				}
			}
		}
		SudokuBoard test = randomBoard.copy();
		SudokuBoard test2 = randomBoard.copy();
		test = solver.recursiveBruteForceSolver(test);
		test2 = solver.recursiveBruteForceSolverRev(test2);		
		if (test != null && test2 != null && test.equals(test2) && test2.equals(test)) {
			return randomBoard;
		} else {
			return generateRandomBoard();
		}
	}
	
//	public boolean noDupes(SudokuBoard sBoard) {
//		
//		int sBoardArray[][] = sBoard.getBoardArray();
//		
//		for (int rows = 0; rows < sBoardArray.length; rows++) {
//			HashSet<Integer> set = new HashSet<Integer>();
//			for (int columns = 0; columns < sBoardArray[rows].length; columns++) {
//				if (set.contains(sBoardArray[rows][columns])) { 
//					return false;
//				}
//				set.add(sBoardArray[columns][rows]);
//			}
//		}
//	    return true;
//	}
//	
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
