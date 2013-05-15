
import java.util.LinkedList;
import java.util.Queue;


public class Graph {
	private Vertex[] vertices; // the (array of) vertices
	private int numVertices = 0; // number of vertices
	
	public Graph(int n) {
		numVertices = n;
		vertices = new Vertex[n];
		for (int i = 0; i < n; i++)
			vertices[i] = new Vertex(i);
	}
	
	public int size() {
		return numVertices;
	}
	
	public Vertex getVertex(int i) {
		return vertices[i];
	}

	public void setVertex(int i) {
		vertices[i] = new Vertex(i);
	}

	public Vertex[] getVertices() { return vertices; }

}
