import java.util.LinkedList;

/* Node class defining a node */
public class Node {
   
	/* Class Constants defined here */
	private int number; 				// number installed in box
	private LinkedList<Edge> box;		// defines a 3x3 box of numbers
	private LinkedList<Edge> column;	// defines a 1x9 column of numbers 
	private LinkedList<Edge> row;		// defines a 1x9 row of numbers 
	
	/* Constructor */
	public Node (int number){
		
		this.number = number;
	}
	
	/* Getters */
	/**
	 * Gets the number associated with the node
	 * @return number in the box
	 */
	public int getNumber() {
		
		return number;
	}
	
	/**
	 * Gets the row associated with the node
	 * @return the 8 numbers in the row of the intial box
	 */
	public LinkedList<Edge> getRow() { 
		
		return row;
	}
	
	/**
	 * Gets the column associated with the node
	 * @return the 8 numbers in the column of the initial box
	 */
	public LinkedList<Edge> getColumn() { 
		
		return column;
	}
	
	/**
	 * Gets the box associated with the node
	 * @return the 8 numbers surrounding the initial box
	 */
	public LinkedList<Edge> getBox() { 
		
		return box;
	}
		
	/* Setters */
	/**
	 * Sets the number in the specific box 
	 * @param aNumber
	 */
	public void setNumber(int aNumber) {
		
		number = aNumber;
	}

	/**	
	 * Sets the numbers in the row for the specific box
	 * @param aRow
	 */
	public void setRow(LinkedList<Edge> aRow) {
		
		row = aRow;
	}
	
	/**
	 * Sets the numbers in the column for the specific box
	 * @param aColumn
	 */
	public void setColumn(LinkedList<Edge> aColumn) {
		
		column = aColumn;
	}
	
	/**
	 * Sets numbers in the surrounding box for the specific box
	 * @param aBox
	 */
	public void setBox(LinkedList<Edge> aBox) {
		
		box = aBox;
	}
	
}
