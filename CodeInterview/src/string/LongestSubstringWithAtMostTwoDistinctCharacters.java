package string;

/**
 * Given a string S, find the length of the longest substring T that 
 * contains at most two distinct characters.
 * For example,
 * Given S = “eceba”,
 * T is “ece” which its length is 3.
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
	// http://www.tangjikai.com/algorithms/leetcode-159longest-substring-with-at-most-two-distinct-characters
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0; // start of the window
        int j = -1; // index of first character
        int maxLen = 0;
        
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
        
            if (j >= 0 && s.charAt(k) != s.charAt(j)) {
            	// means sliding window has more than 2 distinct chars
            	maxLen = Math.max(maxLen, k - i);
            	i = j + 1; // keep the window to have 2 distinct characters
            }
                                
            j = k - 1; // j and k are always 2 distinct chars in the window
		}
        
        return Math.max(maxLen, s.length() - i); // don't forget the last sliding window, i.e abeeeee (maxLen=2, len(s)-i=5)
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("abeeeee"));
	}

}
