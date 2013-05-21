/* Java class defining an Edge */
public class Edge {
	
	/* Class Constants defined here */
	private Node start;
	private Node end;
	
	/* Constructor */
	public Edge (Node startNode, Node endNode){
		
		this.start = startNode;
		this.end = endNode;
		
	}
	
	/* Methods */
	/**
	 * Gets the start node of the edge
	 * @return the start node
	 */
	public Node getStartNode() {
      
		return this.start;
	}
	
	/**
	 * Gets the end node of the edge  
	 * @return the  node 
	 */
	public Node getEndNode() {
      
		return this.end;
	}

	/**
	 * Sets the start of the edge to the given start node
	 * @param start
	 */
	public void setStart(Node start) {
		
		this.start = start;
	}

	/**
	 * Sets the end of the edge to the given end node
	 * @param end
	 */
	public void setEnd(Node end) {
		
		this.end = end;
	}
	
}
