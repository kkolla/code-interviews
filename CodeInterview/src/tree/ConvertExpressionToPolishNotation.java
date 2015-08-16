package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * Given an expression string array, return the Polish notation of this expression. (remove the parentheses)
 * For the expression [(5 − 6) * 7] (which represented by ["(", "5", "−", "6", ")", "*", "7"]), the corresponding polish notation is [* - 5 6 7] 
 * (which the return value should be ["*", "−", "5", "6", "7"]).
 */
public class ConvertExpressionToPolishNotation {
	public static ArrayList<String> convertToPN(String[] expression) {
        ArrayList<String> rpn = new ArrayList<String>();
        Stack<String> ops = new Stack<String>();
        for (int i = expression.length - 1; i >= 0; i--) {
            String expr = expression[i];
            switch (expr) {
                case "(": 
                    while (!ops.isEmpty() && !ops.peek().equals(")"))
                        rpn.add(ops.pop());
                    ops.pop();
                    break;
                case ")":
                    ops.push(expr);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!ops.isEmpty() && getPriority(expr) < getPriority(ops.peek()))
                        rpn.add(ops.pop());
                    ops.add(expr);
                    break;
                default: rpn.add(expr);
            }
        }
        while (!ops.isEmpty()) rpn.add(ops.pop());
        Collections.reverse(rpn);
        return rpn;
    }
    
    private static int getPriority(String op) {
        switch (op) {
            case "+":
            case "-": return 1;
            case "*":
            case "/": return 2;
            default: return 0;
        }
    }
}
