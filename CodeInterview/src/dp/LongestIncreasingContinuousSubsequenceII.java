package dp;

/**
 * Give you an integer matrix (with row size n, column size m)，
 * find the longest increasing continuous subsequence in this matrix. 
 * (The definition of the longest increasing continuous subsequence here 
 * can start at any row or column and go up/down/right/left any direction).
 * Example
 * Given a matrix:
 * 
 * [
 *   [1 ,2 ,3 ,4 ,5],
 *   [16,17,24,23,6],
 *   [15,18,25,22,7],
 *   [14,19,20,21,8],
 *   [13,12,11,10,9]
 * ]
 * return 25
 * Challenge
 * O(nm) time and memory.
 *
 */
public class LongestIncreasingContinuousSubsequenceII {
	public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        int maxLen = 0;
        int[][] len = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
        	for (int j = 0; j < A[0].length; j++) {
        		// find the longest subsequence starting from A[i][j]
        		maxLen = Math.max(maxLen, dfs(A, i, j, len));
        	}
        return maxLen;
    }
	
	private int dfs(int[][] A, int i, int j, int[][] len) {
		if (len[i][j] == 0) { // memorization
			int[][] deltas = { {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
			for (int[] delta : deltas) {
				int x = i + delta[0];
				int y = j + delta[1];
				if (x >= 0 && x < A.length && y >= 0 && y < A[0].length && A[i][j] < A[x][y]) {
					len[i][j] = Math.max(len[i][j], dfs(A, x, y, len));
				}
			}
		}
		return len[i][j];
	}
}
