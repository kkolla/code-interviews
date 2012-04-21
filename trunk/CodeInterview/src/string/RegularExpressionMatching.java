package string;

/*
 ‘.’ Matches any single character.
 ‘*’ Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Some examples:
 isMatch("aa","a")  false
 isMatch("aa","aa")  true
 isMatch("aaa","aa")  false
 isMatch("aa", "a*")  true
 isMatch("aa", ".*")  true
 isMatch("ab", ".*")  true
 isMatch("aab", "c*a*b")  true
 */
public class RegularExpressionMatching {

	// cannot pass leetcode oj
	public static boolean match(char[] s, char[] p, int i, int j) {
		// pattern characters have all been matched
		if (j == p.length)
			return i == s.length;

		// if next character is not '*', must match current characters
		if ((j == p.length - 1) || p[j + 1] != '*') {
			// current characters don't match
			if (s[i] != p[j] && p[j] != '.')
				return false;
			// current characters match, go further for both
			else
				return i != s.length && match(s, p, i + 1, j + 1);
		}

		// next character is '*'
		while (i != s.length && (p[j] == '.' || s[i] == p[j])) {
			if (match(s, p, i, j + 2))
				return true;
			else
				i++;
		}
		return match(s, p, i, j + 2);

	}

	public static void main(String[] args) {
		String[] ss = { "aaaa", "a", "aa", "aa", "aa", "ab", "ab", "aab", "ab" };
		String[] ps = { "a*", "b", "a", "b*a", ".*", "ab*", "abc*", "c*a*b",
				".*" };
		for (int i = 0; i < ss.length; i++)
			System.out.println(ss[i] + ", " + ps[i] + ": "
					+ match(ss[i].toCharArray(), ps[i].toCharArray(), 0, 0));
	}

}
