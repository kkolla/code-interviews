package recursion;

import java.util.ArrayList;
import java.util.List;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * You have a matrix that can have two values black or white. 
 * When adjacent cells in the matrix are black they make up 
 * a connected component. Write a function that prints out 
 * how many component are there in the matrix. 
 * Extension: say the matrix is vary large. How can you use 
 * multiple core of the processor to solve this problem.
 */
public class FindAndStoreConnectedComponentsInBinaryMatrix {

	// represent a component as a list of point coordinates string
	public static List<String> findComponent(int[][] m, int i, int j) {
		if (i < 0 || i > m.length - 1 || j < 0 || j > m[0].length - 1
				|| m[i][j] == 0)
			return null;
		List<String> component = new ArrayList<String>();
		component.add("(" + i + "," + j + ")");
		m[i][j] = 0;
		List<String> l = null;
		l = findComponent(m, i - 1, j);
		if (l != null)
			component.addAll(l);
		l = findComponent(m, i, j - 1);
		if (l != null)
			component.addAll(l);
		l = findComponent(m, i + 1, j);
		if (l != null)
			component.addAll(l);
		l = findComponent(m, i, j + 1);
		if (l != null)
			component.addAll(l);
		return component;
	}

	public static List<List<String>> findComponents(int[][] m) {
		List<List<String>> components = new ArrayList<List<String>>();
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[i].length; j++)
				if (m[i][j] == 1)
					components.add(findComponent(m, i, j));
		return components;
	}

	public static void main(String[] args) {
		int[][] m = CreateUtils.randNonNegMatrix(10, 2, false);
		PrintUtils.print2DArray(m);
		List<List<String>> components = findComponents(m);
		System.out.println("number of components: " + components.size());
		for (List<String> c : components) {
			PrintUtils.printList(c);
		}
	}

}
