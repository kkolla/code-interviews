package dp;

/*
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

	public static int minSum(int[][] m) {
		int rows = m.length, cols = m[0].length;
		if (rows == 0 || cols == 0)
			return 0;
		int[][] sum = new int[rows][cols];
		sum[0][0] = m[0][0];
		for (int i = 1; i < cols; i++)
			sum[0][i] = sum[0][i - 1] + m[0][i];
		for (int i = 1; i < rows; i++)
			sum[i][0] = sum[i - 1][0] + m[i][0];
		for (int i = 1; i < rows; i++)
			for (int j = 1; j < cols; j++)
				sum[i][j] = m[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
		return sum[rows - 1][cols - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
