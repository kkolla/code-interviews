package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneUndirectedGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        return dfs(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>(), new HashSet<UndirectedGraphNode>());
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map, Set<UndirectedGraphNode> visited) {
        if (visited.add(node)) {
            UndirectedGraphNode newNode = map.containsKey(node) ? map.get(node) : new UndirectedGraphNode(node.label);
            map.put(node, newNode);
            
            for (UndirectedGraphNode neighbor : node.neighbors) {
                UndirectedGraphNode newNeighbor = map.containsKey(neighbor) ? map.get(neighbor) : new UndirectedGraphNode(neighbor.label);
                map.put(neighbor, newNeighbor);
                newNode.neighbors.add(newNeighbor);
                dfs(neighbor, map, visited);
            }
        }
        return map.get(node);
    }
}
