/* This class is where we solve the sudoku */
public class SolveSudoku {
	
	// TODO: write your shit here to solve the read in sudoku sohaib
	//		 if it doesn't work do it in the SudokuFileReader and i'll just rename the class
	//		 daniel feel free to do some work
   private static final int SMALLBOX_SIZE = 3;
   
	private SudokuBoard sBoard;
	
	public SolveSudoku(SudokuBoard sBoard){
		this.sBoard = sBoard;
	}
	
   public SudokuBoard recursiveBruteForceSolver(SudokuBoard boardToSolve) {
      int[][] board = boardToSolve.getBoard();
      
      for (int i = 0; i < board.length; i++)
      {
         for (int j = 0; i < board[i].length; i++)
         {
            if (board[i][j]==0) {
               
            }
         }
      }
      return null;
   }

   private int[] getPossibilities(int row, int column)
   {
      int[] numbers = {1,2,3,4,5,6,7,8,9};
      
   }
   /**
    * checks if board is legal and according to laws of Sudoku
    * @param number
    * @param row
    * @param column
    * @return
    */
   private boolean legalboard(int number, int row, int column){
	   int boardrow = (row/SMALLBOX_SIZE) * SMALLBOX_SIZE;
	   int boardcolumn = (row/SMALLBOX_SIZE) * SMALLBOX_SIZE;
	   
	   for (int  i = 0; i < 9; i++){
		   if(sBoard.getcellnum(row, i)== number ||
			  sBoard.getcellnum(i, column) == number ||
			  sBoard.getcellnum(boardrow + (i % SMALLBOX_SIZE), boardcolumn + (i / SMALLBOX_SIZE) ) == number){
			   return false;
		   }
			   
	   }
	   return true;
   }
   
}
