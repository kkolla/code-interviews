package calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import string.EvaluateReversePolishNotation;
import utils.PrintUtils;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 *
 */
public class BasicCalculator {
	
	public static int calculate(String s) {
		String[] tokens = generateRPN(s);
		PrintUtils.printArray(tokens);
		return EvaluateReversePolishNotation.evalRPN(tokens);
    }

	private static String[] generateRPN(String s) {
		Stack<Character> operators = new Stack<Character>();
		List<String> rpn = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') continue;
			else if (Character.isDigit(c)) {
				String num = "";
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num += s.charAt(i);
					i++;
				}
				i--;
				rpn.add(String.valueOf(num));
			} else if (c == '(') {
				operators.push(c);
			} else if (c == ')') {
				// push the operators in the stack to the rpn, until we see a (
				while (!operators.isEmpty() && operators.peek() != '(') {
					rpn.add(String.valueOf(operators.pop()));
				}
				// pop the (
				operators.pop();
			} else {
				// c is +, -, *, /
				while (!operators.isEmpty() && operators.peek() != '(' && getPriority(c) <= getPriority(operators.peek()))
					rpn.add(String.valueOf(operators.pop()));
				operators.push(c);
			}
		}
		
		while (!operators.isEmpty()) 
			rpn.add(String.valueOf(operators.pop()));
		
		return rpn.toArray(new String[rpn.size()]);
	}
	
	private static int getPriority(char operator) {
		switch(operator) {
			case '+':
			case '-': return 1;
			case '/':
			case '*': return 2;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(calculate("2147483647"));
	}

}
