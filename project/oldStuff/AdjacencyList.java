
public class AdjacencyList {

	/* Constants defined here for clarity */
	private int vertnumb;
	private int vertweight;
	
	/* Constructor */
	public AdjacencyList(int vn,int vw){
		vertnumb = vn;
		vertweight = vw;
	}
	
	/* Methods */
	public int getVertNum(){
		return vertnumb;
	}
	
	public void setVertNumb(int vn){
		vertnumb = vn;
	}
	
	public int getvertweight(){
		return vertweight;
	}
	
	public void setvertweight(int vw){
		vertweight = vw;
	}
	
}
