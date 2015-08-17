package string;

/*
 * '?' Matches any single character.
 * '*' Matches zero or more characters.
 */
public class WildcardMatching {
	
	public boolean isMatchIterative(String s, String p) {
        int si = 0, pi = 0, star = -1, starMatched = -1;  
        while (si < s.length()) {
            if (pi == p.length()) {
               if (star != -1) {
                    // there was a star
                    // restore p's position to be after the star
                    pi = star + 1;
                    // cover one more character in s
                    starMatched++;
                    si = starMatched;
                    continue;
                } else {
                    // unmatched
                    return false;
                } 
            }
            
            char sc = s.charAt(si);
            char pc = p.charAt(pi);
            if (sc == pc || pc == '?') {
                // characters match
                si++;
                pi++;
            } else if (pc == '*') {
                // characters match, but we don't know how many characters in s to pass yet
                // save the star position and the end position matched in s
                star = pi;
                starMatched = si;
                pi++;
            } else if (star != -1) {
                // there was a star
                // restore p's position to be after the star
                pi = star + 1;
                // cover one more character in s
                starMatched++;
                si = starMatched;
            } else {
                // unmatched
                return false;
            }
        }
        // we have reached to the end of s, it's fine to have stars in p
        while (pi < p.length() && p.charAt(pi) == '*') pi++;
        return pi == p.length();
    }

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
        if (s.isEmpty()) return p.charAt(0) == '*' && isMatch(s, p.substring(1));
        
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
