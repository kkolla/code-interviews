package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find the number connected component in the undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * (a connected component (or just component) of an undirected graph is a 
 * subgraph in which any two vertices are connected to each other by paths, 
 * and which is connected to no additional vertices in the supergraph.)
 *
 */
public class FindTheConnectedComponentInTheUndirectedGraph {
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> components = new ArrayList<List<Integer>>();
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                List<Integer> component = new ArrayList<Integer>();
                dfs(node, visited, component);
                Collections.sort(component);
                components.add(component);
            }
        }
        return components;
    }
    
    private void dfs(UndirectedGraphNode node, Set<UndirectedGraphNode> visited, List<Integer> component) {
        if (!visited.add(node)) return;
        component.add(node.label);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            dfs(neighbor, visited, component);
        }
    }
}
