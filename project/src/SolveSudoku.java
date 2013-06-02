import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* This class is where we solve the sudoku */
public class SolveSudoku
{

   /* Constructor */
   public SolveSudoku()
   {
      // testSolver();
      // testNoSolutions();
   }

   /* Methods */
   /**
    * Tests if the board is valid
    */
   private void testSolver()
   {
      Scanner sc = null;
      int[][] board = new int[9][9];
      int nextNumber = 0;

      try {
         sc = new Scanner(new FileReader("resources/input2"));
         while (sc.hasNext()) {
            for (int row = 0; row < board.length; row++) {
               for (int column = 0; column < board[row].length; column++) {
                  nextNumber = sc.nextInt();
                  board[row][column] = nextNumber;
               }
            }
         }
      } catch (FileNotFoundException e) {
      } catch (NoSuchElementException e) {
      }

      SudokuBoard sBoard = new SudokuBoard(board);
      sBoard.printBoard();
      assertTrue(isValid(sBoard));
   }

   /**
    * Tests whether a the sudoku has a solution or not
    */
   private void testNoSolutions()
   {
      Scanner sc = null;
      int[][] board = new int[9][9];
      int nextNumber = 0;

      try {
         sc = new Scanner(new FileReader("resources/input6"));
         while (sc.hasNext()) {
            for (int row = 0; row < board.length; row++) {
               for (int column = 0; column < board[row].length; column++) {
                  nextNumber = sc.nextInt();
                  board[row][column] = nextNumber;
               }
            }
         }
      } catch (FileNotFoundException e) {
      } catch (NoSuchElementException e) {
      }

      SudokuBoard sBoard = new SudokuBoard(board);
      sBoard.printBoard();
      int noSolutions = noSolutions(sBoard);
      System.out.print(noSolutions + "\n");
      assertEquals(35, noSolutions);
      assertTrue(isValid(sBoard));
   }

   /**
    * A recursive brute force solver.
    * 
    * @param sBoard
    * @return solved board
    */
   public SudokuBoard recursiveBruteForceSolver(SudokuBoard sBoard)
   {
      int i, j;
      int[] emptyCell = findEmptyCell(sBoard);
      i = emptyCell[0];
      j = emptyCell[1];
      if (i == -1 || j == -1) {
         return sBoard;
      }
      LinkedList<Integer> possibilities = getPossibilities(i, j, sBoard);
      for (Integer k : possibilities) {
         sBoard.setCellNum(k.intValue(), i, j);
         SudokuBoard temp = sBoard.copy();
         temp = recursiveBruteForceSolver(temp);
         if (!(temp == null)) {
            // if (isComplete(temp)) {
            // if (isValid(temp)) {
            return temp;
            // }
            // }
         }
      }
      return null;
   }

   /**
    * A recursive brute force solver.
    * 
    * @param sBoard
    * @return solved board
    */
   public SudokuBoard recursiveBruteForceSolverRev(SudokuBoard sBoard)
   {
      int i, j;
      int[] emptyCell = findEmptyCell(sBoard);
      i = emptyCell[0];
      j = emptyCell[1];
      if (i == -1 || j == -1) {
         return sBoard;
      }
      LinkedList<Integer> possibilities = getPossibilitiesRev(i, j, sBoard);
      for (Integer k : possibilities) {
         sBoard.setCellNum(k.intValue(), i, j);
         SudokuBoard temp = sBoard.copy();
         temp = recursiveBruteForceSolver(temp);
         if (!(temp == null)) {
            return temp;
         }
      }
      return null;
   }

   /**
    * Checks if any solutions and returns the number of solutions if there are.
    * 
    * @param sBoard
    * @return number of solutions
    */
   public int noSolutions(SudokuBoard sBoard)
   {
      int solutions = 0;
      int i, j;
      int[] emptyCell = findEmptyCell(sBoard);
      i = emptyCell[0];
      j = emptyCell[1];

      if (i == -1 || j == -1) {
         return 1;
      }
      LinkedList<Integer> possibilities = getPossibilities(i, j, sBoard);
      for (Integer k : possibilities) {
         sBoard.setCellNum(k.intValue(), i, j);
         SudokuBoard temp = sBoard.copy();
         temp = recursiveBruteForceSolver(temp);
         if (!(temp == null)) {
            solutions++;
         }
      }
      return solutions;
   }

   /**
    * Finds and empty cell on the board.
    * 
    * @param sBoard
    * @return emptyCell which is an array of areas
    */
   private int[] findEmptyCell(SudokuBoard sBoard)
   {
      int[] emptyCell = { -1, -1 };
      for (int i = 0; i < 9; i++) {
         for (int j = 0; j < 9; j++) {
            if (sBoard.getBoardArray()[i][j] == 0) {
               emptyCell[0] = i;
               emptyCell[1] = j;
               return emptyCell;
            }
         }
      }
      return emptyCell;
   }

   /**
    * Providing a row, column, and a board we get the possibilities for a cell.
    * 
    * @param row
    * @param column
    * @param sBoard
    * @return an linked list of integers for possibilities
    */
   public LinkedList<Integer> getPossibilities(int row, int column, SudokuBoard sBoard)
   {

      LinkedList<Integer> numbers = new LinkedList<Integer>();
      for (int i = 1; i < 10; i++) {
         numbers.add(i);
      }
      for (int j = 0; j < 9; j++) {
         if (numbers.contains(new Integer(sBoard.getBoardArray()[row][j]))) {
            numbers.remove(new Integer(sBoard.getBoardArray()[row][j]));
         }
         if (numbers.contains(new Integer(sBoard.getBoardArray()[j][column]))) {
            numbers.remove(new Integer(sBoard.getBoardArray()[j][column]));
         }
      }

      int subGridRow = row - (row % 3);
      int subGridColumn = column - (column % 3);

      for (int i = subGridRow; i < subGridRow + 3; i++) {
         for (int j = subGridColumn; j < subGridColumn + 3; j++) {
            if (numbers.contains(new Integer(sBoard.getBoardArray()[i][j]))) {
               numbers.remove(new Integer(sBoard.getBoardArray()[i][j]));
            }
         }
      }
      return numbers;
   }

   /**
    * Providing a row, column, and a board we get the possibilities for a cell
    * (in reverse order).
    * 
    * @param row
    * @param column
    * @param sBoard
    * @return an linked list of integers for possibilities
    */
   public LinkedList<Integer> getPossibilitiesRev(int row, int column, SudokuBoard sBoard)
   {
      LinkedList<Integer> numbers = new LinkedList<Integer>();
      for (int i = 9; i > 0; i--) {
         numbers.add(i);
      }
      for (int j = 0; j < 9; j++) {
         if (numbers.contains(new Integer(sBoard.getBoardArray()[row][j]))) {
            numbers.remove(new Integer(sBoard.getBoardArray()[row][j]));
         }
         if (numbers.contains(new Integer(sBoard.getBoardArray()[j][column]))) {
            numbers.remove(new Integer(sBoard.getBoardArray()[j][column]));
         }
      }

      int subGridRow = row - (row % 3);
      int subGridColumn = column - (column % 3);

      for (int i = subGridRow; i < subGridRow + 3; i++) {
         for (int j = subGridColumn; j < subGridColumn + 3; j++) {
            if (numbers.contains(new Integer(sBoard.getBoardArray()[i][j]))) {
               numbers.remove(new Integer(sBoard.getBoardArray()[i][j]));
            }
         }
      }
      return numbers;
   }

   /**
    * Checks if the board is valid. Uses a helper function to check inner 3x3
    * grids.
    * 
    * @param sBoard
    * @return early exits a boolean
    */
   public boolean isValid(SudokuBoard sBoard)
   {
      for (int i = 0; i < 9; i++) {
         if (!isValidRow(sBoard, i) || !isValidColumn(sBoard, i)) {
            // row or column has repetitions
            return false;
         }
      }
      for (int i = 0; i < 9; i += 3) {
         for (int j = 0; j < 9; j += 3) {
            if (!isValidSubGrid(sBoard, i, j)) {
               // subGrid has repetitions
               return false;
            }
         }
      }
      return true;
   }

   /**
    * Checks if the 3x3 sub grid is valid.
    * 
    * @param sBoard
    * @param row
    * @param column
    * @return boolean whether it is valid or not
    */
   private static boolean isValidSubGrid(SudokuBoard sBoard, int row, int column)
   {
      int subGridRow = row - (row % 3);
      int subGridColumn = column - (column % 3);

      for (int i = subGridRow; i < subGridRow + 3; i++) {
         for (int j = subGridColumn; j < subGridColumn + 3; j++) {
            for (int k = subGridRow; k < subGridRow + 3; k++) {
               for (int l = subGridColumn; l < subGridColumn + 3; l++) {
                  if ((i != k || j != l)
                        && sBoard.getBoardArray()[i][j] == sBoard.getBoardArray()[k][l]
                        && sBoard.getBoardArray()[i][j] != 0
                        && sBoard.getBoardArray()[k][l] != 0) {
                     return false;
                  }
               }
            }
         }
      }
      return true;
   }

   /**
    * Checks whether a column is valid or not
    * 
    * @param sBoard
    * @param column
    * @return boolean
    */
   private static boolean isValidColumn(SudokuBoard sBoard, int column)
   {
      for (int i = 0; i < 9; i++) {
         for (int j = i + 1; j < 9; j++) {
            if (sBoard.getBoardArray()[i][column] == sBoard.getBoardArray()[j][column]
                  && sBoard.getBoardArray()[i][column] != 0
                  && sBoard.getBoardArray()[j][column] != 0) {
               return false;
            }
         }
      }
      return true;
   }

   /**
    * Checks whether a row is valid or not
    * 
    * @param sBoard
    * @param row
    * @return
    */
   private static boolean isValidRow(SudokuBoard sBoard, int row)
   {
      for (int i = 0; i < 9; i++) {
         for (int j = i + 1; j < 9; j++) {
            if (sBoard.getBoardArray()[row][i] == sBoard.getBoardArray()[row][j]
                  && sBoard.getBoardArray()[row][i] != 0
                  && sBoard.getBoardArray()[row][j] != 0) {
               return false;
            }
         }
      }
      return true;
   }

   /**
    * Checks if the board is complete searching for any 0's.
    * 
    * @param sBoard
    * @return boolean
    */
   private static boolean isComplete(SudokuBoard sBoard)
   {
      for (int i = 0; i < 9; i++) {
         for (int j = 0; j < 9; j++) {
            if (sBoard.getBoardArray()[i][j] == 0) {
               return false;
            }
         }
      }
      return true;
   }
}
