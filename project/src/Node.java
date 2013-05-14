import java.util.LinkedList;

/* Node class defining a single box */
public class Node {

   public Node (int number){
      this.number = number;
   }
   
	/* Class Constants defined here */

	private int number;
	private LinkedList<Edge> box;
	private LinkedList<Edge> column;
	private LinkedList<Edge> row;
	
	/* Constructor */

	
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
