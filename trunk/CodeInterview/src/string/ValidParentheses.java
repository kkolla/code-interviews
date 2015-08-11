package string;

import java.util.Stack;

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
			if (c == '(') {
				round++;
			} else if (c == ')') {
				String brackets = "()]}";
				if (brackets.indexOf(prev) == -1 || round == 0)
					break;
				else
					round--;
			} else if (c == '[') {
				square++;
			} else if (c == ']') {
				String brackets = "[])}";
				if (brackets.indexOf(prev) == -1 || square == 0)
					break;
				else
					square--;
			} else if (c == '{') {
				brace++;
			} else if (c == '}') {
				String brackets = "{})]";
				if (brackets.indexOf(prev) == -1 || brace == 0)
					break;
				else
					brace--;
			}
			prev = c;
		}
		return round == 0 && square == 0 && brace == 0;
	}
	
	public boolean isValidParentheses(String s) {
		String lefts = "([{", rights = ")]}";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lefts.indexOf(c) != -1) stack.push(c);
            else {
                if (!stack.isEmpty() && rights.charAt(lefts.indexOf(stack.peek())) == c) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

	public static void main(String[] args) {
		String[] ps = { "()", "()[]{}", "(]", "([)]" };
		for (String p : ps)
			System.out.println(p + ": " + isValid(p));
	}

}
