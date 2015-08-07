package string;

/**
 * Given a string you need to print longest possible substring that has exactly M unique characters. 
 * If there are more than one substring of longest possible length, then print any one of them.
 * Examples:
 * "aabbcc", k = 1
 * Max substring can be any one from {"aa" , "bb" , "cc"}.
 * "aabbcc", k = 2
 * Max substring can be any one from {"aabb" , "bbcc"}.
 * "aabbcc", k = 3
 * There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 * Max is "aabbcc" with length 6.
 * "aaabbb", k = 3
 * There are only two unique characters, thus show error message. 
 *
 */
public class LongestSubstringWithKUniqueCharacters {
	
	public static String find(String s, int k) {
		int[] counts = new int[s.length()];
		int start = 0, maxStart = 0, maxEnd = 0;
		int numChars = 0;
		for (int i = 0; i < s.length(); i++) {
			// add the current char to the current window
			if (counts[s.charAt(i) - 'a'] == 0) numChars++;
			counts[s.charAt(i) - 'a']++;
			
			while (start < s.length() && numChars > k) {
				if (--counts[s.charAt(start) - 'a'] == 0) numChars--;
				start++;
			}
			
			if (i - start + 1 > maxEnd - maxStart + 1) {
				maxStart = start;
				maxEnd = i;
			}
		}
		return s.substring(maxStart, maxEnd + 1);
	}

	public static void main(String[] args) {
		System.out.println(find("aabbcc", 1));
		System.out.println(find("aabbcc", 2));
		System.out.println(find("aabbcc", 3));
		System.out.println(find("aabbcc", 4)); // the algorithm doesn't handle this

		System.out.println(find("aabacbebebec", 3));
	}

}
