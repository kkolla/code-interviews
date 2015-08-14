package dp;

/**
 * Give you an integer array (index from 0 to n-1, where n is the size of this array)，
 * find the longest increasing continuous subsequence in this array. 
 * (The definition of the longest increasing continuous subsequence here 
 * can be from right to left or from left to right)
 * Example
 * For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 * Note
 * O(n) time and O(1) extra space.
 *
 */
public class LongestIncreasingContinuousSubsequence {
	public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A.length == 0) return 0;
        
        int maxLenLeftToRight = 1;
        int len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                len++;
                maxLenLeftToRight = Math.max(maxLenLeftToRight, len);
            } else {
                len = 1;
            }
        }
        
        int maxLenRightToLeft = 1;
        len = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                len++;
                maxLenRightToLeft = Math.max(maxLenRightToLeft, len);
            } else {
                len = 1;
            }
        }
        
        return Math.max(maxLenLeftToRight, maxLenRightToLeft);
    }
}
