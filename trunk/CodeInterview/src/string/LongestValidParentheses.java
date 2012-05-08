package string;

/*
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses 
 * substring. For "(()", the longest valid parentheses substring
 * is "()", which has length = 2. Another example is ")()())", 
 * where the longest valid parentheses substring is "()()", 
 * which has length = 4.
 */
public class LongestValidParentheses {

	public static int longest(String s) {
		int max = 0;
		int length = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				count++;
			else
				count--;
			length++;
			if (count == 0 && length > max) {
				max = length;
			} else if (count == -1) {
				count = 0;
				length = 0;
			}
		}
		// max is 0 for the case "(()" if no counting from right to left
		length = 0;
		count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ')')
				count++;
			else
				count--;
			length++;
			if (count == 0 && length > max) {
				max = length;
			} else if (count == -1) {
				count = 0;
				length = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longest(")()())"));
	}

}
