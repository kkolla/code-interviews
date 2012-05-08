package string;

public class LongestPalindrome {

	static public String expand(String s, int c1, int c2) {
		if (c1 > c2)
			return null;
		int left = c1, right = c2;
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	// O(n^2)
	static public String longestPalindrome(String s) {
		if (s == null)
			return null;
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {
			String palindrome = expand(s, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			palindrome = expand(s, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("dbaaabccccccbaaabeee"));
	}

}
