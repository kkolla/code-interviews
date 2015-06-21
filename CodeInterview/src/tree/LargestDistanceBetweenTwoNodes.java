package tree;

import utils.CreateUtils;
import utils.PrintUtils;

public class LargestDistanceBetweenTwoNodes {

	public static int distance(TreeNode root) {
		return largestDistance(root)[0];
	}

	// [0]: largest distance, [1]: height of tree
	public static int[] largestDistance(TreeNode root) {
		// if tree is null, both distance and height are 0
		if (root == null)
			return new int[] { 0, 0 };
		int[] pair = largestDistance(root.left);
		int leftDistance = pair[0];
		int leftHeight = pair[1];
		pair = largestDistance(root.right);
		int rightDistance = pair[0];
		int rightHeight = pair[1];
		// 3 possibilities: left, right, or across root
		int distance = Math.max(leftDistance, rightDistance);
		int height = 1 + Math.max(leftHeight, rightHeight);
		return new int[] { Math.max(distance, leftHeight + rightHeight), height };
	}

	public static void main(String[] args) {
		TreeNode root = CreateUtils.bstWithTenNodes();
		PrintUtils.printBinaryTree(root);
		System.out.println(distance(root));
	}

}
