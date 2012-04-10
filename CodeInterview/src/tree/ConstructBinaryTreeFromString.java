package tree;

import java.util.Stack;

/*
 * Consider this string representation for binary trees. Each node is of the form (lr), 
 * where l represents the left child and r represents the right child. 
 * If l is the character 0, then there is no left child. Similarly, 
 * if r is the character 0, then there is no right child. Otherwise, 
 * the child can be a node of the form (lr), and the representation continues recursively.
 * For example: (00) is a tree that consists of one node. 
 * ((00)0) is a two-node tree in which the root has a left child, 
 * and the left child is a leaf. And ((00)(00)) is a three-node tree, 
 * with a root, a left and a right child.
 * Write a function that takes as input such a string, and returns -1 if the string is malformed, 
 * and the depth of the tree if the string is well-formed.
 */
public class ConstructBinaryTreeFromString {
	public enum State {
		EXPECT_LEFT_CHILD, EXPECT_RIGHT_CHILD, EXPECT_RIGHT_BRACKET
	}

	public static int findDepth(char[] s) {
		if (s.length == 0 || s[0] != '(')
			return -1;
		Stack<Character> stack = new Stack<Character>();
		Stack<State> states = new Stack<State>();
		int i = 0;
		int maxDepth = 1;
		stack.push(s[i++]);
		states.push(State.EXPECT_LEFT_CHILD);
		while (!stack.isEmpty() && !states.isEmpty() && i != s.length) {
			State state = states.peek();
			char c = s[i++];
			switch (state) {
			case EXPECT_LEFT_CHILD:
			case EXPECT_RIGHT_CHILD:
				if (c != '(' && c != '0')
					return -1;
				stack.push(c);
				if (c == '(') {
					states.push(State.EXPECT_LEFT_CHILD);
					maxDepth = Math.max(maxDepth, states.size());
				} else if (c == '0') {
					states.pop();
					states.push(state == State.EXPECT_LEFT_CHILD ? State.EXPECT_RIGHT_CHILD
							: State.EXPECT_RIGHT_BRACKET);
				}
				break;
			case EXPECT_RIGHT_BRACKET:
				if (c != ')')
					return -1;
				states.pop();
				char t = stack.peek();
				while (t != '(')
					t = stack.pop();
				if (states.size() > 0) {
					states.push(states.pop() == State.EXPECT_LEFT_CHILD ? State.EXPECT_RIGHT_CHILD
							: State.EXPECT_RIGHT_BRACKET);
				}
				break;
			}
		}

		return i == s.length ? maxDepth - 1 : -1;
	}

	public static void main(String[] args) {
		String[] ss = { "(00)", "((00)0)", "((00)(00))", "((00)(0(00)))",
				"((00)(0(0(00))))", "x", "0", "()", "(0)", "(00)x", "(0p)",
				"((00)(0(00))))", "((00)(0(000)))", "((00)(0((00)0)))" };
		for (String s : ss) {
			int depth = findDepth(s.toCharArray());
			System.out.println(s + ": " + depth);
		}
	}

}
