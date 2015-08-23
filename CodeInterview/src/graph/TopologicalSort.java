package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import utils.CreateUtils;
import utils.PrintUtils;

public class TopologicalSort {
	
	public ArrayList<DirectedGraphNode> topSortBFS(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> nodeToInDegree = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                int count = 1 + (nodeToInDegree.containsKey(neighbor) ? nodeToInDegree.get(neighbor) : 0);
                nodeToInDegree.put(neighbor, count);
            }
        }
        
        // enqueue nodes without incoming edge
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph)
            if (!nodeToInDegree.containsKey(node)) q.offer(node);

        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            result.add(node);
            
            // decrease in degree by one for all neighbors of the node
            for (DirectedGraphNode neighbor : node.neighbors) {
                int count = nodeToInDegree.get(neighbor) - 1;
                nodeToInDegree.put(neighbor, count);
                if (count == 0) {
                    // enqueue if the neighbor has no incoming edge
                    q.offer(neighbor);
                }
            }
        }
        
        // top logical order doesn't exist if nodeToInDegree has non-zero value
        
        return result;
    }
	
	public ArrayList<DirectedGraphNode> topSortDFS(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		for (DirectedGraphNode node :  graph) {
			dfs(node, result, visited);
		}
		Collections.reverse(result);
		return result;
	}
	
	private void dfs(DirectedGraphNode node, List<DirectedGraphNode> result, Set<DirectedGraphNode> visited) {
		if (visited.contains(node)) return;
		visited.add(node);
		
		for (DirectedGraphNode neighbor : node.neighbors)
			dfs(neighbor, result, visited);
		
		result.add(node);
	}

	// old lame code
	public static List<String> sort(Graph g) {
		List<Integer> l = new ArrayList<Integer>();
		List<String> r = new ArrayList<String>();
		for (int i = 0; i < g.nodes(); i++) {
			int incomings = 0;
			for (int j = 0; j < g.nodes(); j++)
				if (g.hasEdge(j, i))
					incomings++;
			if (incomings == 0)
				l.add(i);
		}
		while (l.size() != 0) {
			int n = l.remove(l.size() - 1);
			r.add(g.getLabel(n));
			for (int i = 0; i < g.nodes(); i++)
				if (g.hasEdge(n, i)) {
					g.setEdge(n, i, 0);
					int incomings = 0;
					for (int j = 0; j < g.nodes(); j++)
						if (g.hasEdge(j, i))
							incomings++;
					if (incomings == 0)
						l.add(i);
				}
		}
		for (int i = 0; i < g.nodes(); i++)
			for (int j = 0; j < g.nodes(); j++)
				if (g.hasEdge(i, j))
					return null;
		return r;
	}

	public static void main(String[] args) {
		Graph g = CreateUtils.dagWithEightVertices();
		List<String> l = sort(g);
		if (l == null) {
			System.out.println("at least one cycle is contained in the graph");
		} else {
			PrintUtils.printList(l);
		}
	}
}
