package string;

import java.util.Arrays;

/*
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithUniqueChars {

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
		String[] ss = { "abcabcbb", "bbbbb", "abcddcbae", "" };
		for (String s : ss)
			System.out.println(longest(s));
	}

}
