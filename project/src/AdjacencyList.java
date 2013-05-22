
public class AdjacencyList {

	private int vertnumb;
	private int vertweight;
	
	
	public AdjacencyList(int vn,int vw){
		vertnumb = vn;
		vertweight = vw;
	}
	
	public int getvertnum(){
		return vertnumb;
	}
	
	public void setvertnumb(int vn){
		vertnumb = vn;
	}
	
	public int getvertweight(){
		return vertweight;
	}
	
	public void setvertweight(int vw){
		vertweight = vw;
	}
	
}
