
public class Board {

	final int sizeofboard;
	final int cubesize;
	final int EMPTY = 0;
	
	private int[][] board;
	
	/**
	 * Create empty board
	 * @param sizeofboard
	 */
	public Board(int sizeofboard) {
		
		board = new int [sizeofboard][sizeofboard];
		this.sizeofboard = sizeofboard;
		this.cubesize = (int) Math.sqrt(sizeofboard);
	}
	
	/**
	 * initalize the board
	 * @param board
	 */
	public Board(int [][] board){
		
		this(board.length);
		this.board = board;
	}
	
	/**
	 * places values into the board
	 * @param number
	 * @param row
	 * @param column
	 */
	public void setbox(int number,int row, int column ){
		
		number = board[row][column];
	}
	
	/**
	 * get the number in a certain field
	 * @param row
	 * @param column
	 * @return
	 */
	public int getBox(int row, int column){
		
		return board[row][column];
	}
	
	/**
	 * Prints the board
	 */
	public void printBoard() {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
