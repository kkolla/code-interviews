package tree;

import java.util.Stack;

import utils.CreateUtils;

/*Printing a Binary Tree in Zig Zag Level-Order
 1                      1
 2    3          ==>    3   2
 4   5     6            4   5  6
 */
public class PrintBinaryTreeInZigzagOrder {

	public static void printTreeZigzag(Node root) {
		if (root == null)
			return;
		Stack<Node> currLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		currLevel.push(root);
		boolean isLeftToRight = true;
		while (!currLevel.isEmpty()) {
			Node n = currLevel.pop();
			System.out.print(n.value + " ");
			if (isLeftToRight) {
				if (n.left != null)
					nextLevel.push(n.left);
				if (n.right != null)
					nextLevel.push(n.right);
			} else {
				if (n.right != null)
					nextLevel.push(n.right);
				if (n.left != null)
					nextLevel.push(n.left);
			}
			if (currLevel.isEmpty()) {
				System.out.println();
				currLevel = nextLevel;
				nextLevel = new Stack<Node>();
				isLeftToRight = !isLeftToRight;
			}
		}
	}

	public static void main(String[] args) {
		LevelByLevelTraversal.traverseByLevel(CreateUtils
				.createBSTWithTenNodes());
		printTreeZigzag(CreateUtils.createBSTWithTenNodes());
	}

}
