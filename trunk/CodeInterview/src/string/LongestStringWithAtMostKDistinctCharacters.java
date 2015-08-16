package string;

/**
 * Given a string s, find the length of the longest substring T that 
 * contains at most k distinct characters.
 *
 * Example
 * For example, Given s = "eceba", k = 3,
 * T is "eceb" which its length is 4.
 */
public class LongestStringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] counts = new int[58];
        int numCharsFound = 0;
        int maxLen = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (++counts[c - 'A'] == 1) numCharsFound++;
            
            if (numCharsFound > k) {
                assert (numCharsFound == k + 1);
                while (start < s.length() && numCharsFound > k) {
                    char firstChar = s.charAt(start);
                    if (--counts[firstChar - 'A'] == 0) numCharsFound--;
                    start++;
                }
            } else {
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        
        return maxLen;
    }
}
