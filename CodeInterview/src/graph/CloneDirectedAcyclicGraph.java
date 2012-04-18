package graph;

import java.util.HashMap;
import java.util.Map;

import utils.CreateUtils;
import utils.PrintUtils;

// assume there is no null vertex
// should have a better way which recursively solves this
public class CloneDirectedAcyclicGraph {

	public static void dfsForConstruction(Vertex v, Map<Vertex, Vertex> map) {
		if (!v.visited) {
			v.visited = true;
			Vertex newV = new Vertex(v.value);
			map.put(v, newV);
			for (Vertex n : v.neighbors) {
				dfsForConstruction(n, map);
			}
		}
	}

	public static void dfsForLinkingNeighbors(Vertex v, Map<Vertex, Vertex> map) {
		if (!v.visited) {
			v.visited = true;
			Vertex newV = map.get(v);
			for (Vertex n : v.neighbors) {
				newV.neighbors.add(map.get(n));
			}
			for (Vertex n : v.neighbors) {
				dfsForLinkingNeighbors(n, map);
			}
		}
	}

	public static Vertex clone(Vertex v) {
		// map from vertex in the old graph to vertex in the cloned one
		Map<Vertex, Vertex> map = new HashMap<Vertex, Vertex>();
		// first round, do DFS and construct the map
		// also create vertices for the cloned graph but not link
		dfsForConstruction(v, map);
		// set visited flags back to false
		for (Map.Entry<Vertex, Vertex> entry : map.entrySet())
			entry.getKey().visited = false;
		// second round, link the neighbors by mappings
		dfsForLinkingNeighbors(v, map);
		return map.get(v);
	}

	public static void main(String[] args) {
		Vertex v = CreateUtils.dagWithSevenVertices();
		PrintUtils.printGraphDepthFirst(v);
		System.out.println();
		PrintUtils.printGraphDepthFirst(clone(v));
	}

}
