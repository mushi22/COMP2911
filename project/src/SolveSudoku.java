/* This class is where we solve the sudoku */
public class SolveSudoku {
	
	// TODO: write your shit here to solve the read in sudoku sohaib
	//		 if it doesn't work do it in the SudokuFileReader and i'll just rename the class
	//		 daniel feel free to do some work
	
   
	private SudokuBoard sBoard;
	
	public SolveSudoku(SudokuBoard sBoard){
		this.sBoard = sBoard;
	}
	public SudokuBoard recursiveBruteForceSolver(SudokuBoard boardToSolve) {
		
		SudokuBoard board = new SudokuBoard();
		
		return board;
	}
   public SudokuBoard recursiveBruteForceSolver(SudokuBoard board)
   {
      
      
      
      
      return board;
      
   }
   /**
    * checks if board is legal and according to laws of Sudoku
    * @param number
    * @param row
    * @param column
    * @return
    */
   private boolean legalboard(int number, int row, int column){
	   int boardrow = (row/sBoard.smallbox_size) * sBoard.smallbox_size;
	   int boardcolumn = (row/sBoard.smallbox_size) * sBoard.smallbox_size;
	   
	   for (int  i = 0; i < 9; i++){
		   if(sBoard.getcellnum(row, i)== number ||
			  sBoard.getcellnum(i, column) == number ||
			  sBoard.getcellnum(boardrow + (i % sBoard.smallbox_size), boardcolumn + (i / sBoard.smallbox_size) ) == number){
			   return false;
		   }
			   
	   }
	   return true;
   }
   
}
