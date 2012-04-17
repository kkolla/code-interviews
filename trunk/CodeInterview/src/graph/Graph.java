package graph;

public class Graph {
	private int[][] edges;
	private String[] labels;

	public Graph(String[] labels, int[][] edges) {
		assert (labels.length == edges.length && edges.length == edges[0].length);
		this.labels = labels;
		this.edges = edges;
	}

	public boolean hasEdge(int i, int j) {
		return edges[i][j] != 0;
	}

	public int setEdge(int i, int j, int weight) {
		int t = edges[i][j];
		edges[i][j] = weight;
		return t;
	}

	public int nodes() {
		return edges.length;
	}

	public String getLabel(int i) {
		return labels[i];
	}
}
