package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RouteBetweenTwoNodesInGraph {
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
            DirectedGraphNode s, DirectedGraphNode t) {
		return hasRoute(graph, s, t, new HashSet<DirectedGraphNode>());
	}
	
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
	    DirectedGraphNode s, DirectedGraphNode t,
	    Set<DirectedGraphNode> visited) {
		if (!visited.add(s)) return false;
		if (s == t) return true;
		for (DirectedGraphNode n : s.neighbors) {
			if (hasRoute(graph, n, t, visited)) return true;
		}
		return false;
	}
}
