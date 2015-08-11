package unionfindset;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.PrintUtils;

/**
 * Given a n,m which means the row and column of the 2D matrix and an array of pair A(size k). 
 * Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
 * The list pair has k operator and each operator has two integer A[i].x, A[i].y means that 
 * you can change the grid matrix[A[i].x][A[i].y] from sea to island. 
 * Return how many island are there in the matrix after each operator.
 * 
 * Example
 * Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
 * return [1,1,2,2].
 * Note
 * 0 is represented as the sea, 1 is represented as the island. 
 * If two 1 is adjacent, we consider them in the same island. 
 * We only consider up/down/left/right adjacent.
 *
 */
public class NumberOfIslandsII {
	
	private static class Element {
		Element parent;
		// can add "rank" here to be used for balancing during union, to make it a log(n) operation
	}
	
	private static Element createIsland(Set<Element> islands) {
		Element e = new Element();
		e.parent = e;
		islands.add(e);
		return e;
	}
	
	private static Element find(Element e) {
		while (e.parent != e) e = e.parent;
		return e;
	}
	
	private static Element union(Element e1, Element e2, Set<Element> islands) {
		Element root1 = find(e1);
		Element root2 = find(e2);
		if (root1 == root2) return root1;
		else {
			root2.parent = root1;
			islands.remove(root2);
			return root1;
		}
	}
	
	public static List<Integer> numIslands2(int n, int m, Point[] operators) {
		List<Integer> result = new ArrayList<Integer>();
		if (operators == null || operators.length == 0) return result;
		
		Element[][] seaElements = new Element[n][m];
		Set<Element> islands = new HashSet<Element>(); // roots of islands
		for (Point p : operators) {
			// for each operator
			
			// first make it a single set
			Element e = createIsland(islands);
			seaElements[p.x][p.y] = e;
			
			// merge if it's neighbors are sea
			if (p.x > 0 && seaElements[p.x - 1][p.y] != null) 
				e = union(e, seaElements[p.x - 1][p.y], islands);
			if (p.x < n - 1 && seaElements[p.x + 1][p.y] != null) 
				e = union(e, seaElements[p.x + 1][p.y], islands);
			if (p.y > 0 && seaElements[p.x][p.y - 1] != null) 
				e = union(e, seaElements[p.x][p.y - 1], islands);
			if (p.y < m - 1 && seaElements[p.x][p.y + 1] != null) 
				e = union(e, seaElements[p.x][p.y + 1], islands);
			
			result.add(islands.size());
		}
		return result;
    }

	public static void main(String[] args) {
		Point[] operators = new Point[] { new Point(0, 0), new Point(0, 1), new Point(2, 2), new Point(2, 1)};
		PrintUtils.printList(numIslands2(3, 3, operators));
	}

}
