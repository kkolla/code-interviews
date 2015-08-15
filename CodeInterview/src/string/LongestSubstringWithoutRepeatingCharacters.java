package string;

import java.util.Arrays;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		int[] indices = new int[256];
		Arrays.fill(indices, -1);
		
		int maxLen = 0;
		for (int i = 0, start = 0, currLen = 0; i < s.length(); i++) {
			int prevIndex = indices[s.charAt(i)];
			if (prevIndex == -1 || prevIndex < i - currLen) {
			    // the curr char hasn't appeared before, or the previous appearance is not part of the considered substring
				currLen++;
			} else {
				// the current char was seen before, and is part of the currently considered substring
				start = prevIndex + 1;
				currLen = i - start + 1;
			}
			maxLen = Math.max(maxLen, currLen);
			indices[s.charAt(i)] = i;
		}
		
		return maxLen;
    }
}
