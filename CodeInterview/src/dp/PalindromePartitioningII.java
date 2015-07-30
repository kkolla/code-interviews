package dp;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 */
public class PalindromePartitioningII {
	// mc[i]: min cut for prefix s(0..i-1) of size i
    // answer: mc[s.length()]
    // mc[i] = min(mc[j]) + 1 for 0 <= j < i and s(j...i-1) is a palindrome
    // init: mc[0] = -1, to make sure mc[1] = -1 + 1 = 0
    public int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++)
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && 
                    (i + 1 > j - 1 || isPalindrome[i + 1][j - 1]);
        }
        
        int[] mc = new int[s.length() + 1];
        mc[0] = -1;
        for (int i = 1; i < mc.length; i++) {
            int min = mc[i - 1]; // s(i-1..i-1) is palindrome
            for (int j = i - 2; j >= 0; j--) {
                if (isPalindrome[j][i - 1])
                    min = Math.min(min, mc[j]);    
            }
            mc[i] = min + 1;
        }
        
        return mc[s.length()];
    }
}
