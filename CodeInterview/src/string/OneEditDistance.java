package string;

/**
 * company: Uber, stage: phone
 * 
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 */
public class OneEditDistance {
	
	public static boolean isOneEditDistance(String s, String t) {  
		 return isOneEditDistance(s, t, 0, 0, 0);  
	}
	
	public static boolean isOneEditDistance(String s, String t, int si, int ti, int distance) {
		if (distance > 1) return false;
		if (si < s.length() && ti < t.length()) {
			if (s.charAt(si) != t.charAt(ti)) {
				distance++;
				return isOneEditDistance(s, t, si + 1, ti, distance) || 
					isOneEditDistance(s, t, si, ti + 1, distance) ||
					isOneEditDistance(s, t, si + 1, ti + 1, distance);
			} else {
				return isOneEditDistance(s, t, si + 1, ti + 1, distance);
			}
		} else if (distance == 1) {
			// must reach to both string's ends
			return si == s.length() && ti == t.length();
		} else {
			// distance = 0
			return Math.abs(s.length() - t.length()) == 1;
		}
	}

	public static void main(String[] args) {
		System.out.println(isOneEditDistance("abcdef", "abcde"));
	}

}
