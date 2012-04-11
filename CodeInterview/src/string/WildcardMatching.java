package string;

/*
 ‘?’ Matches any single character.
 ‘*’ Matches zero or more characters.
 */
public class WildcardMatching {

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

	public static void main(String[] args) {
		String[] ss = { "", "aaaa", "a", "aa", "aa", "aa", "ab", "abcde",
				"aab", "ab" };
		String[] ps = { "*", "*a", "b", "a", "b*a", "*", "ab*", "ab?*e",
				"?a*b", "?*b" };
		for (int i = 0; i < ss.length; i++)
			System.out.println(ss[i] + ", " + ps[i] + ": "
					+ match(ss[i].toCharArray(), ps[i].toCharArray(), 0, 0));
	}

}
