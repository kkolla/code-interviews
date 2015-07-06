package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].

 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
	
	// canBeBroken[i]: if the first i characters in the string can be broken into words
	// init: canBeBroken[0] = true
	// answer: canBeBroken[s.length()]
	// canBeBroken[i] =
	//		true if any j < i, canBeBroken[j] is true and s.substring(j, i) is a word in dict
	//		false otherwise
	public static boolean wordBreak(String s, Set<String> dict) {
		boolean[] canBeBroken = new boolean[s.length() + 1];
		canBeBroken[0] = true;
		
		for (int i = 0; i < canBeBroken.length; i++)
			for (int j = 0; j < i; j++)
				if (canBeBroken[j] && dict.contains(s.substring(j, i))) {
					// e.g. for the given example
					// canBeBroken[4] = true and "leetcode".substring(4, 8) = "code"
					canBeBroken[i] = true;
					break;
				}
		
		return canBeBroken[s.length()];
    }

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak("leetcode", dict));
	}

}
