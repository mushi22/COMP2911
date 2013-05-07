import java.util.LinkedList;

/* Node class defining a single box */
public class Node {

	/* Class Constants defined here */
	// number inside the box
	private static int number;
	// a list for the 3x3 boxes
	private static LinkedList<Node> box;
	// a list for the column
	private static LinkedList<Node> column;
	// a list for the row
	private static LinkedList<Node> row;
	
	/* Constructor */
	public Node (int aNumber) { 
		
		number = aNumber;
	}
	
	/* Getters */
	public int getNumber() {
		
		return number;
	}
	
	public LinkedList<Node> getRow() { 
		
		return row;
	}
	
	public LinkedList<Node> getColumn() { 
		
		return column;
	}
	
	public LinkedList<Node> getBox() { 
		
		return box;
	}
		
	/* Setters */
	public static void setNumber(int number) {
		
		Node.number = number;
	}

	public static void setBox(LinkedList<Node> box) {
		
		Node.box = box;
	}

	public static void setColumn(LinkedList<Node> column) {
		
		Node.column = column;
	}

	public static void setRow(LinkedList<Node> row) {
		
		Node.row = row;
	}
	
}
