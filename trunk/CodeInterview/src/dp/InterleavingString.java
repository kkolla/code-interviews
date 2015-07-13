package dp;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 */
public class InterleavingString {
	
	// a[i][j]: true if s3(1..i+j) can be formed, assuming the index starts with 1
	// answer: a[s1.length()][s2.length()]
	// init: a[0][0] = true (empty s3 can be formed by empty s1 and s2)
	//		 a[i][0] = s3(i) == s1(i) && a[i - 1][0] for 1 <= i <= s1.length()
	//		 a[0][j] = s3(i) == s2(j) && a[0][j - 1] for 1 <= j <= s2.length()
	// a[i][j] = s1(i) == s3(i + j) && a[i - 1][j] || s2(j) == s3(i + j) && a[i][j - 1]
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s2.length() + s1.length()) return false;
        boolean[][] a = new boolean[s1.length() + 1][s2.length() + 1];
    	a[0][0] = true;
    	for (int i = 1; i < a.length; i++)
    		a[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && a[i - 1][0];
    	for (int j = 1; j < a[0].length; j++)
    		a[0][j] = s3.charAt(j - 1) == s2.charAt(j - 1) && a[0][j - 1];
    	for (int i = 1; i < a.length; i++)
    		for (int j = 1; j < a[0].length; j++) {
    			char c = s3.charAt(i + j - 1);
    			a[i][j] = s1.charAt(i - 1) == c && a[i - 1][j] || s2.charAt(j - 1) == c && a[i][j - 1];
    		}
    	return a[s1.length()][s2.length()];
    }

	
    public static boolean isInterleaveRecursive(String s1, String s2, String s3) {
    	if (s3.isEmpty()) return s1.isEmpty() && s2.isEmpty();
        return !s1.isEmpty() && s3.charAt(0) == s1.charAt(0) && isInterleaveRecursive(s1.substring(1), s2, s3.substring(1)) ||
        	!s2.isEmpty() && s3.charAt(0) == s2.charAt(0) && isInterleaveRecursive(s1, s2.substring(1), s3.substring(1));
    }

	public static void main(String[] args) {
		System.out.println(isInterleaveRecursive("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(isInterleaveRecursive("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
