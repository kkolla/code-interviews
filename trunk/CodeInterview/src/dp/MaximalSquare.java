package dp;

/**
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest square containing all 1's and return its area.
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 *
 */
public class MaximalSquare {
	// m[i][j]: width of maximum square ending matrix[i][j]
    // answer: max(m[i][j] ^ 2)
    // m[i][j] = 0 if matrix[i][j] == '0'
    //         = 1 + min(m[i - 1][j], m[i][j - 1], m[i - 1][j - 1]) if matrix[i][j] == '1'
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = 0;
        int[][] m = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') m[i][j] = 0;
                else {
                    int left = i > 0 ? m[i - 1][j] : 0;
                    int top = j > 0 ? m[i][j - 1] : 0;
                    int leftTop = i > 0 && j > 0 ? m[i - 1][j - 1] : 0;
                    m[i][j] = 1 + Math.min(left, Math.min(top, leftTop));
                }
                maxArea = Math.max(maxArea, m[i][j] * m[i][j]);
            }
        return maxArea;
    }
}
