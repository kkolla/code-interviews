package unionfindset;

import graph.DirectedGraphNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the number Weak Connected Component in the directed graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * (a connected set of a directed graph is a subgraph in which any two 
 * vertices are connected by direct edge path.)
 * Example
 * Given graph:
 * 
 * A----->B  C
 *  \     |  | 
 *   \    |  |
 *    \   |  |
 *     \  v  v
 *      ->D  E <- F
 * Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}
 * 
 * Note
 * Sort the element in the set in increasing order
 */
public class FindTheWeakConnectedComponentInTheDirectedGraph {
	public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
		Map<Integer, Integer> nodeToRootMap = new HashMap<Integer, Integer>();
        
		for (DirectedGraphNode node : nodes) {
		    // add node to map and use it as root
    		if (!nodeToRootMap.containsKey(node.label)) {
    			nodeToRootMap.put(node.label, node.label);
    		}
			for (DirectedGraphNode neighbor : node.neighbors) {				
				int nodeRootLable = find(node.label, nodeToRootMap);
				
				// create mapping for an edge
				if (!nodeToRootMap.containsKey(neighbor.label)) {
    			    nodeToRootMap.put(neighbor.label, node.label);
    		    }
				int neighborRootLabel = find(neighbor.label, nodeToRootMap);
				
				// merge roots since they're in a connect component
				nodeToRootMap.put(neighborRootLabel, nodeRootLable);
			}
		}

		Map<Integer, List<Integer>> rootToComponentMap = new HashMap<Integer, List<Integer>>();
		for (int nodeLabel : nodeToRootMap.keySet()) {
			int rootLabel = find(nodeLabel, nodeToRootMap);
			List<Integer> component = rootToComponentMap.containsKey(rootLabel) ? 
				rootToComponentMap.get(rootLabel) : new ArrayList<Integer>();
			component.add(nodeLabel);
			rootToComponentMap.put(rootLabel, component);
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (List<Integer> component : rootToComponentMap.values()) {
			Collections.sort(component);
			result.add(component);
		}
		return result;
    }

	private int find(int nodeLabel, Map<Integer, Integer> nodeToRootMap) {
		int label = nodeToRootMap.get(nodeLabel);
		while (label != nodeToRootMap.get(label))
			label = nodeToRootMap.get(label);
		return label;
	}
}
