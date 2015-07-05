package tree;

import utils.PrintUtils;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

	private static TreeNode buildTree(int[] inorder, int[] postorder, int startI, int endI, int startP, int endP) {
		if (startI > endI || startP > endP) return null;
		
		// root is always the last one in post order
		TreeNode root = new TreeNode(postorder[endP]);
		
		int numLeftNodes = 0;
		for (int i = startI; i <= endI; i++)
			if (inorder[i] == root.val) break;
			else numLeftNodes++;
			
		root.left = buildTree(inorder, postorder, startI, startI + numLeftNodes - 1, startP, startP + numLeftNodes - 1);
		root.right = buildTree(inorder, postorder, startI + numLeftNodes + 1, endI, startP + numLeftNodes, endP - 1);
		
		return root;
    }
	
	public static void main(String[] args) {
		//int[] inorder = {4, 2, 5, 1, 6, 7, 3, 8};
		//int[] postorder = {4, 5, 2, 6, 7, 8, 3, 1};

		int[] inorder = {2, 1, 3};
		int[] postorder = {2, 3, 1};
		PrintUtils.printBinaryTree(buildTree(inorder, postorder));
	}

}
