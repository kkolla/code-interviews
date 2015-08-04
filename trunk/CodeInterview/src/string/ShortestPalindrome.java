package string;

/**
 * Given a string S, you are allowed to convert it to a 
 * palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 *
 */
public class ShortestPalindrome {
	
	public static String shortestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) return s;
        
		int center = (s.length() - 1) / 2;
		int longestPalindromeWithHeadEndIndex = 0;
		for (int i = center; i >= 0; i--) {
			// consider the s.charAt(i) == s.charAt(i + 1) case first for string with even length
			if (s.charAt(i) == s.charAt(i + 1)) {
				Integer end = expandPalindromeToHead(s, i, i + 1);
				if (end != null) {
					longestPalindromeWithHeadEndIndex = end;
					break;
				}
			}
			Integer end = expandPalindromeToHead(s, i, i);
			if (end != null) {
				longestPalindromeWithHeadEndIndex = end;
				break;
			}
		}
		return constructShortestPalindrome(s, longestPalindromeWithHeadEndIndex);
    }
	
	// returns end index if s.substring(0, end + 1) is a palindrome
	private static Integer expandPalindromeToHead(String s, int start, int end) {
		assert(s.charAt(start) == s.charAt(end));
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		if (start == -1) return end - 1;
		else return null;
	}
	
	private static String constructShortestPalindrome(String s, int longestPalindromeWithHeadEndIndex) {
		String remaining = s.substring(longestPalindromeWithHeadEndIndex + 1);
		String missingLeft = new StringBuilder(remaining).reverse().toString();
		return missingLeft + s;
	}

	public static void main(String[] args) {
		System.out.println(shortestPalindrome(""));
	}

}
