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
	public int getNumber() {
		
		return number;
	}
	
	public LinkedList<Edge> getRow() { 
		
		return row;
	}
	
	public LinkedList<Edge> getColumn() { 
		
		return column;
	}
	
	public LinkedList<Edge> getBox() { 
		
		return box;
	}
		
	/* Setters */
	public void setNumber(int aNumber) {
		
		number = aNumber;
	}

	public void setBox(LinkedList<Edge> aBox) {
		
		box = aBox;
	}

	public void setColumn(LinkedList<Edge> aColumn) {
		
		column = aColumn;
	}

	public void setRow(LinkedList<Edge> aRow) {
		
		row = aRow;
	}
	
}
