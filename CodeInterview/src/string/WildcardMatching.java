package string;

/*
 * '?' Matches any single character.
 * '*' Matches zero or more characters.
 */
public class WildcardMatching {

	// TLE
	public static boolean match(char[] s, char[] p, int i, int j) {
		// pattern characters have all been matched
		if (j == p.length)
			return i == s.length;

		if (i == s.length)
			return p[j] == '*' ? match(s, p, i, j + 1) : false;

		// if current character is not '*', must match current characters
		if (p[j] != '*') {
			// current characters don't match
			if (s[i] != p[j] && p[j] != '?')
				return false;
			// current characters match, go further for both
			else
				return match(s, p, i + 1, j + 1);
		}

		// current character is '*'
		return match(s, p, i + 1, j) || match(s, p, i, j + 1);

	}
	
	// TLE
	public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (s.isEmpty()) return p.charAt(0) == '*' ? isMatch(s, p.substring(1)) : false;
        
        if (p.charAt(0) == '*') {
            return isMatch(s.substring(1), p) || isMatch(s.substring(1), p.substring(1));
        } else {
            return (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) && isMatch(s.substring(1), p.substring(1));
        }
    }

	public static void main(String[] args) {
		String[] ss = { "", "aaaa", "a", "aa", "aa", "aa", "ab", "abcde",
				"aab", "ab" };
		String[] ps = { "*", "*a", "b", "a", "b*a", "*", "ab*", "ab?*e",
				"?a*b", "?*b" };
		for (int i = 0; i < ss.length; i++)
			System.out.println(ss[i] + ", " + ps[i] + ": " + isMatch(ss[i], ps[i]));
	}

}
