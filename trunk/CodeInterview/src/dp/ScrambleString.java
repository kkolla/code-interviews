package dp;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

	Below is one possible representation of s1 = "great":
	
	    great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t
	To scramble the string, we may choose any non-leaf node and swap its two children.
	
	For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
	
	    rgeat
	   /    \
	  rg    eat
	 / \    /  \
	r   g  e   at
	           / \
	          a   t
	We say that "rgeat" is a scrambled string of "great".
	
	Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
	
	    rgtae
	   /    \
	  rg    tae
	 / \    /  \
	r   g  ta  e
	       / \
	      t   a
	We say that "rgtae" is a scrambled string of "great".
	
	Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 */
public class ScrambleString {
	
	public static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		if (s1.equals(s2)) return true;
		
		// pruning if s1 and s2 are not anagrams
		int[] counts = new int[26];
		for (char c : s1.toCharArray()) counts[c - 'a']++;
		for (char c : s2.toCharArray()) counts[c - 'a']--;
		for (int count: counts) 
			if (count != 0) return false;

		for (int i = 0; i < s1.length() - 1; i++) {
			int leftPartition = i + 1, rightParition = s1.length() - i - 1;
			String s11 = s1.substring(0, leftPartition);
			String s12 = s1.substring(leftPartition);
			if (isScramble(s11, s2.substring(0, leftPartition)) && isScramble(s12, s2.substring(leftPartition)) ||
				isScramble(s11, s2.substring(rightParition)) && isScramble(s12, s2.substring(0, rightParition)))
				return true;
		}
		
		return false;
    }

	public static void main(String[] args) {
		System.out.println(isScramble("rgtae", "great"));
		System.out.println(isScramble("rgtat", "great"));
		System.out.println(isScramble("a", ""));
	}

}
