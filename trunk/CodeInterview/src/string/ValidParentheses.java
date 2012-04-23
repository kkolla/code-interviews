package string;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

	public static boolean isValid(String p) {
		int round = 0, brace = 0, square = 0;
		char prev = '!';
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			boolean invalid = false;
			if (c == '(') {
				round++;
			} else if (c == ')') {
				String brackets = "()]}";
				if (brackets.indexOf(prev) == -1 || round == 0)
					invalid = true;
				else
					round--;
			} else if (c == '[') {
				square++;
			} else if (c == ']') {
				String brackets = "[])}";
				if (brackets.indexOf(prev) == -1 || square == 0)
					invalid = true;
				else
					square--;
			} else if (c == '{') {
				brace++;
			} else if (c == '}') {
				String brackets = "{})]";
				if (brackets.indexOf(prev) == -1 || brace == 0)
					invalid = true;
				else
					brace--;
			}
			if (invalid)
				return false;
			prev = c;
		}
		return round == 0 && square == 0 && brace == 0;
	}

	public static void main(String[] args) {
		String[] ps = { "()", "()[]{}", "(]", "([)]" };
		for (String p : ps)
			System.out.println(p + ": " + isValid(p));
	}

}
