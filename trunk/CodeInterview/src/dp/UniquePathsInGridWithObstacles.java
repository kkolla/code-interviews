package dp;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. 
 * How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively 
 * in the grid. For example, There is one obstacle in the middle 
 * of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 */
public class UniquePathsInGridWithObstacles {

	public static int pathsIterative(int[][] grid) {
		int m = grid.length, n = grid[0].length;

		int[][] paths = new int[m][n];
		for (int i = 0; i < m; i++)
			if (grid[i][0] == 1 || i > 0 && paths[i - 1][0] == 0)
				paths[i][0] = 0;
			else
				paths[i][0] = 1;
		for (int i = 0; i < n; i++)
			if (grid[0][i] == 1 || i > 0 && paths[0][i - 1] == 0)
				paths[0][i] = 0;
			else
				paths[0][i] = 1;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				if (grid[i][j] == 1) {
					paths[i][j] = 0;
				} else {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}
			}
		return paths[m - 1][n - 1];
	}

	// buggy!
	public static int pathsRecursive(int[][] grid, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (m == 1)
			return grid[0][n] == 1 ? 0 : 1;
		if (n == 1)
			return grid[m][0] == 1 ? 0 : 1;
		if (grid[m][n] == 1)
			return 0;
		else
			return pathsRecursive(grid, m - 1, n)
					+ pathsRecursive(grid, m, n - 1);
	}

	public static void main(String[] args) {
		int[][] grid = CreateUtils.randNonNegMatrix(10, 2, false);
		PrintUtils.print2DArray(grid);
		System.out.println(" paths: " + pathsIterative(grid) + " "
				+ pathsRecursive(grid, grid.length - 1, grid[0].length - 1));
	}
}
