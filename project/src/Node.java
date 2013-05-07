import java.util.LinkedList;

/* Node class */
public class Node {

	/* Class Constants defined here */
	private static int number;
	private static LinkedList<Node> box;
	private static LinkedList<Node> column;
	private static LinkedList<Node> row;
	
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
