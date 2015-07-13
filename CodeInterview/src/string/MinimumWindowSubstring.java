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
	
	public static String minWindow(String s, String t) {
        int[] required = new int[58];
        for (int i = 0; i < t.length(); i++) {
            required[t.charAt(i) - 'A']++;
        }
        
        int[] found = new int[58];
        int charsFound = 0;
        int minStart = -1, minEnd = -1;
        for (int start = 0, end = 0; end < s.length(); end++) {
            int index = s.charAt(end) - 'A';
            if (required[index] == 0) continue;
            found[index]++;
            if (found[index] <= required[index]) charsFound++;
            if (charsFound == t.length()) {
                int index2 = s.charAt(start) - 'A';
                while (required[index2] == 0 || found[index2] > required[index2]) {
                    if (required[index2] > 0) found[index2]--;
                    start++;
                    index2 = s.charAt(start) - 'A';
                }
                if (minStart == -1 || minEnd - minStart > end - start) {
                    minStart = start;
                    minEnd = end;
                }
            }
            
        }
        
        if (minStart == -1) return "";
        else return s.substring(minStart, minEnd + 1);
    }

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
		
	}

}
