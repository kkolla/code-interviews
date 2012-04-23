package string;

/*
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, 
 * return the empty string "".
 * If there are multiple such windows, you are guaranteed that 
 * there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

	public static String findMinWindow(String s, String t) {
		if (s.length() == 0)
			return "";
		if (t.length() == 0)
			return s;
		int[] required = new int[52];
		for (int i = 0; i < t.length(); i++) {
			int index = t.charAt(i) - 'A';
			required[index]++;
		}
		int[] found = new int[26];
		int foundChars = 0;
		int minLength = s.length();
		int minBegin = -1, minEnd = -1;
		for (int begin = 0, end = 0; end < s.length(); end++) {
			int index = s.charAt(end) - 'A';
			// skip the not required ones
			if (required[index] == 0)
				continue;
			found[index]++;
			if (found[index] <= required[index])
				foundChars++;
			// a window is found
			if (foundChars == t.length()) {
				int index2 = s.charAt(begin) - 'A';
				// advance begin as far as possible
				while (required[index2] == 0
						|| found[index2] > required[index2]) {
					if (found[index2] > required[index2])
						found[index2]--;
					begin++;
					index2 = s.charAt(begin) - 'A';
				}
				// update potentially smaller window
				if (end - begin + 1 < minLength) {
					minLength = end - begin + 1;
					minBegin = begin;
					minEnd = end;
				}
			}
		}
		if (minBegin != -1)
			return s.substring(minBegin, minEnd + 1);
		else if (foundChars == t.length())
			return s;
		else
			return "";
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(findMinWindow(s, t));
	}

}
