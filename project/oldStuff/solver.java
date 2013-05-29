

public class solver {

	private Board solvedboard;
	
	/**
	 * initliased board
	 * @param solvedboard
	 */
	public solver(Board solvedboard){
		this.solvedboard = solvedboard;
	}
	
	/**
	 * check if board is valid according to sudoko rules
	 * @param number
	 * @param row
	 * @param column
	 * @return
	 */
	private boolean validboard(int number, int row, int column){
		int r = (row / solvedboard.cubesize) * solvedboard.cubesize;
		int c = (column / solvedboard.cubesize) * solvedboard.cubesize;
	
		for (int i = 0; i < solvedboard.cubesize; i++){
			if(solvedboard.getBox(row, i) == number ||
			   solvedboard.getBox(i, column) == number ||
			   solvedboard.getBox(r +( i % solvedboard.cubesize), c + (i / solvedboard.cubesize)) == number){
				return false;
			}
		}
		return true;
	}
	
	
	public boolean guessvalue(int row, int column){
		int nColumn = (column + 1) % solvedboard.cubesize;
		int nRow    = (nColumn == 0 ) ? row + 1 : row;
		
		try{
			if(solvedboard.getBox(row, column) != solvedboard.EMPTY)
				return guessvalue(nColumn, nRow);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return true;
		}
		
		for (int i = 1; i <= solvedboard.sizeofboard; i++){
			if(validboard(i, row, column)){
				solvedboard.setbox(i, row, column);
				if( guessvalue(nRow, nColumn)){
					return true;
				}
			}
		}
		solvedboard.setbox(solvedboard.EMPTY, row, column);
		return false;
	}
}
