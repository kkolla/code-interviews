package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, n, new ArrayList<String>(), "");   
    }
    
    private List<String> generateParenthesis(int left, int right, List<String> result, String s) {
        if (left == 0 && right == 0) {
            result.add(s);
        } else {
            // can always place a left parenthesis 
            if (left > 0) generateParenthesis(left - 1, right, result, s + "(");
            // cannot place a right parenthesis if left parenthesis are greater than or equal to right ones
            if (left < right) generateParenthesis(left, right - 1, result, s + ")");
        }
        return result;
    }
}
