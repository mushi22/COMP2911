import java.util.LinkedList;

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

   private LinkedList<Integer> getPossibilities(int row, int column,SudokuBoard board)
   {
      LinkedList<Integer> numbers = new LinkedList<Integer>();
      numbers.add(1);
      numbers.add(2);
      numbers.add(3);
      numbers.add(4);
      numbers.add(5);
      numbers.add(6);
      numbers.add(7);
      numbers.add(8);
      numbers.add(9);
      for (Integer i: numbers)
      {
         for (int j = 0; j < 9; j++)
         {
            if (board.getBoard()[row][j] == i.intValue() ||
                board.getBoard()[j][column] == i.intValue()) {
               numbers.remove(i);
            }
         }
      }
      return numbers;
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
