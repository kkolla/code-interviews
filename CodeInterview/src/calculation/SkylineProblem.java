package calculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem {
	public static class Edge implements Comparable<Edge>{
        int pos;
        int height;
        boolean isStart;
        
        public Edge(int pos, int height, boolean isStart) {
            this.pos = pos;
            this.height = height;
            this.isStart = isStart;
        }
        
		@Override
		public int compareTo(Edge e) {
			if (this.pos != e.pos) {
				// sort by position if different
				return new Integer(this.pos).compareTo(new Integer(e.pos));
			} else if (this.isStart && e.isStart) {
				return new Integer(e.height).compareTo(new Integer(this.height));
			} else if (!this.isStart && !e.isStart) {
				return new Integer(this.height).compareTo(new Integer(e.height));
			} else {
				// one is start and one is end
				// make the start appear before
				return this.isStart ? -1 : 1;
			}
		}
    }
	
	public static List<int[]> getSkyline(int[][] buildings) {
		List<int []> result = new ArrayList<int []>();
		
		List<Edge> edges = new ArrayList<Edge>();
		for (int[] building : buildings) {
			Edge startEdge = new Edge(building[0], building[2], true);
			Edge endEdge = new Edge(building[1], building[2], false);
			edges.add(startEdge);
			edges.add(endEdge);
		}
		Collections.sort(edges);
		
		PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(20, Collections.reverseOrder());
		for (Edge edge : edges) {
            if (edge.isStart) {
                if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
                	// add a key point if there's no element in the heap
                	// or the current edge has a higher height
                    result.add(new int[] { edge.pos, edge.height });
                }
                heightHeap.add(edge.height);
            } else {
            	heightHeap.remove(edge.height);
                if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
                    result.add(heightHeap.isEmpty() ? 
                    	new int[]{ edge.pos, 0 } : new int[] { edge.pos, heightHeap.peek()});
                }
            }
        }
		return result;
    }
}
