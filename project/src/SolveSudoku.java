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
	
   public SudokuBoard recursiveBruteForceSolver() {
      for (int i = 0; i < sBoard.getBoard().length; i++)
      {
         for (int j = 0; i < sBoard.getBoard()[i].length; i++)
         {
            if (sBoard.getBoard()[i][j]==0) {
               for (Integer k : getPossibilities(i, j))
               {
                  sBoard.setCellNum(k.intValue(), i, j);
                  sBoard = recursiveBruteForceSolver();
                  if (isComplete() && isLegalBoard()) {
                     return sBoard;
                  }
               } 
            }
         }
      }
      return null;
   }

   private LinkedList<Integer> getPossibilities(int row, int column)
   {
      LinkedList<Integer> numbers = new LinkedList<Integer>();
      for (int i = 1; i < 10; i++) 
      {
         numbers.add(i);
      }
      for (Integer i: numbers)
      {
         for (int j = 0; j < 9; j++)
         {
            if (sBoard.getBoard()[row][j] == i.intValue() ||
                sBoard.getBoard()[j][column] == i.intValue()) {
               numbers.remove(i);
            }
         }
      }
      return numbers;
   }
   
   private boolean isLegalBoard()
   {
      
   }
   
   
   /**
    * checks if board is legal and according to laws of Sudoku
    * @param number
    * @param row
    * @param column
    * @return
    */
   private boolean isLegalBoardCell(int number, int row, int column){
	   int boardrow = (row/SMALLBOX_SIZE) * SMALLBOX_SIZE;
	   int boardcolumn = (row/SMALLBOX_SIZE) * SMALLBOX_SIZE;
	   
	   for (int  i = 0; i < 9; i++){
		   if(sBoard.getCellNum(row, i)== number ||
			  sBoard.getCellNum(i, column) == number ||
			  sBoard.getCellNum(boardrow + (i % SMALLBOX_SIZE), boardcolumn + (i / SMALLBOX_SIZE) ) == number){
			   return false;
		   }
			   
	   }
	   return true;
   }
   
   private boolean isComplete()
   {
      for (int i = 0; i < 9; i++)
      {
         for (int j = 0; j < 9; j++)
         {
            if (sBoard.getBoard()[i][j] == 0) {
               return false;
            }
         }
      }
      return true;
   }
   
}
