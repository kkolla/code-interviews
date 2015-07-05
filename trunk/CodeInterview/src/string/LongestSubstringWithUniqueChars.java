package string;

import java.util.Arrays;

/*
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithUniqueChars {
	
	public static int lengthOfLongestSubstring(String s) {
		if (s.isEmpty()) return 0;
		
		int[] indices = new int[256];
		Arrays.fill(indices, -1);
		
		int start = 0, end = 0, currLen = 1, maxLen = 1;
		indices[s.charAt(0)] = 0;
		for (int i = 1; i < s.length(); i++) {
			int prevIndex = indices[s.charAt(i)];
			end = i;
			if (prevIndex == -1 || i - currLen > prevIndex) {
				// the current char was not seen before 
				// or it was seen before but is not part of the currently considered substr
				// in either case,  it can be added to the currently considered substr
				currLen++;
			} else {
				// the current char was seen before, and is part of the currently considered substr
				start = prevIndex + 1;
				currLen = end - start + 1;
			}
			maxLen = Math.max(maxLen, end - start + 1);
			indices[s.charAt(i)] = i;
		}
		
		return maxLen;
    }

	// O(n)?
	public static int longest(String s) {
		int start = 0, end = -1;
		int max = 0;
		int[] map = new int[26];
		Arrays.fill(map, -1);
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			end = i;
			if (map[index] != -1) {
				start = map[index] + 1;
				for (int j = 0; j < map.length; j++)
					if (map[j] < map[index])
						map[j] = -1;
			}
			map[index] = i;
			if (end - start + 1 > max)
				max = end - start + 1;
		}
		return max;
	}

	public static void main(String[] args) {
		String[] ss = { "abccba", "abcabcbb", "bbbbb", "abcddcbae", "" };
		for (String s : ss)
			System.out.println(lengthOfLongestSubstring(s));
	}

}
