import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* Reads in a text file with the sudoku to be solved
 * Sudoku is represented in the text file as follows:
 * 		0 3 5 2 9 0 8 6 4
 * 		0 8 2 4 1 0 7 0 3
 * 		7 6 4 3 8 0 0 9 0
 * 		2 1 8 7 3 9 0 4 0
 * 		0 0 0 8 0 4 2 3 0
 * 		0 4 3 0 5 2 9 7 0
 *		4 0 6 5 7 1 0 0 9
 *		3 5 9 0 2 8 4 1 7
 *		8 0 0 9 0 0 5 2 6 
 * The 0's represents an empty cell to be solved 
 *
 */
public class SudokuFileReader {
	
	/* Constants defined here for clarity */
	private static int board[][];
	private static final int MAX_NUM_COLUMNS = 8;
	private static final int MAX_NUM_ROWS = 8;
	
	/* Main file to scan in file and parse numbers for each cell */
	public static void main(String [] args) { 
		
		Scanner sc = null;
		board = new int[9][9];
		int nextNumber = 0;
		
		try { 
			sc = new Scanner (new FileReader ("resources/input1"));
			while (sc.hasNext()) { 
				for (int row = 0; row < board.length; row++) {
					for (int column = 0; column < board[row].length; column++) {
						nextNumber = sc.nextInt();
						board[row][column] = nextNumber;
					}
				}
			}
		} catch (FileNotFoundException e) {}
		  catch (NoSuchElementException e) {}
		Board newBoard = new Board(board);
		newBoard.printBoard();
	}
}
