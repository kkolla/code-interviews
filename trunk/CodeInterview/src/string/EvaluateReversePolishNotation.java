package string;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int o2 = s.pop();
                int o1 = s.pop();
                int res;
                if (token.equals("+")) res = o1 + o2;
                else if (token.equals("-")) res = o1 - o2;
                else if (token.equals("*")) res = o1 * o2;
                else res = o1 / o2;
                s.push(res);
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}
