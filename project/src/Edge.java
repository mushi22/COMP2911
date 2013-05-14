/* Java class defining an Edge */
public class Edge {

	/* Class Constants defined here */
	private Node to;
	
	/* Constructor */
	public Edge (Node to){
      
		this.to = to;
	}
	
	/**
	 * Gets the node connected to a specific node 
	 * @return the connected node 
	 */
	public Node getToNode() {
      
		return to;
	}
   
	
}
