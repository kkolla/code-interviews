package dp;

import utils.CreateUtils;

/*
 * A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below).
 * The robot can only move either down or right 
 * at any point in time. The robot is trying to reach 
 * the bottom-right corner of the grid (marked 'Finish' in 
 * the diagram below). How many possible unique paths are there?
 */
public class UniquePathsInGrid {

	public static int pathsIterative(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (m == 1 || n == 1)
			return 1;
		int[][] paths = new int[m][n];
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				int leftPaths = i - 1 == 0 ? 1 : paths[i - 1][j];
				int topPaths = j - 1 == 0 ? 1 : paths[i][j - 1];
				paths[i][j] = leftPaths + topPaths;
			}
		return paths[m - 1][n - 1];
	}

	public static int pathsRecursive(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (m == 1 || n == 1)
			return 1;
		return pathsRecursive(m - 1, n) + pathsRecursive(m, n - 1);
	}

	public static void main(String[] args) {
		int m = CreateUtils.randNonNegInt(10);
		int n = CreateUtils.randNonNegInt(10);
		System.out.println("m: " + m + " n: " + n);
		System.out.println(" paths: " + pathsIterative(m, n) + " "
				+ pathsRecursive(m, n));
	}
}
