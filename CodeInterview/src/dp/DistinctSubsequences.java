package dp;

import java.util.Arrays;

import utils.PrintUtils;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from 
 * the original string by deleting some (can be none) of the characters 
 * without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 *
 */
public class DistinctSubsequences {
	
	// d[i][j]: number of subsequences in s(0..i-1) equal to t(0..j-1)
	// answer: d[s.length][t.length]
	// d[i][j] = 
	//     d[i - 1][j] if s(i - 1) != t(j - 1), meaning s(i - 1) needs to be deleted anyway
	//	   d[i - 1][j] + d[i - 1][j - 1] otherwise, meaning s(i - 1) can be deleted or not
	// init: d[i][0] = 1, meaning any s has one empty subsequence by deleting all
	public static int numDistinct(String s, String t) {
		int[][] d = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < d.length; i++)
			d[i][0] = 1;
		
		for (int i = 1; i < d.length; i++)
			for (int j = 1; j < d[0].length; j++) {
				d[i][j] = d[i - 1][j];
				if (s.charAt(i - 1) == t.charAt(j - 1))
					d[i][j] += d[i - 1][j - 1];
			}
				
		return d[s.length()][t.length()];
	}
	
	// O(n) space: http://fisherlei.blogspot.com/2012/12/leetcode-distinct-subsequences_19.html

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
		System.out.println();
		
		System.out.println(numDistinct("rabbbit", "r"));
		System.out.println();
		
		System.out.println(numDistinct("rabbbit", ""));
		System.out.println();

		System.out.println(numDistinct("a", "bb"));
		System.out.println();
	}

}
