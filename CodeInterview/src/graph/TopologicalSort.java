package graph;

import java.util.ArrayList;
import java.util.List;

import utils.CreateUtils;
import utils.PrintUtils;

public class TopologicalSort {

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
