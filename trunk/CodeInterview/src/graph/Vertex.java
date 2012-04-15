package graph;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
	public int value;
	public Set<Vertex> neighbors;
	public boolean visited;

	public Vertex(int value) {
		this.value = value;
		this.neighbors = new HashSet<Vertex>();
		this.visited = false;
	}

}
