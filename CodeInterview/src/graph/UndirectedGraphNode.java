package graph;

import java.util.ArrayList;
import java.util.List;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}
