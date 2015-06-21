package tree;

import java.util.Stack;

import utils.CreateUtils;

/*Printing a Binary Tree in Zig Zag Level-Order
 1                      1
 2    3          ==>    3   2
 4   5     6            4   5  6
 */
public class PrintBinaryTreeInZigzagOrder {

	public static void printTreeZigzag(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> currLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		currLevel.push(root);
		boolean isLeftToRight = true;
		while (!currLevel.isEmpty()) {
			TreeNode n = currLevel.pop();
			System.out.print(n.val + " ");
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
				nextLevel = new Stack<TreeNode>();
				isLeftToRight = !isLeftToRight;
			}
		}
	}

	public static void main(String[] args) {
		LevelByLevelTraversal.traverseByLevel(CreateUtils
				.bstWithTenNodes());
		printTreeZigzag(CreateUtils.bstWithTenNodes());
	}

}
