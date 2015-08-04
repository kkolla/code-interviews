package tree;

import utils.PrintUtils;

/**
 * Given a binary tree where all the right nodes are either 
 * leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
 * flip it upside down and turn it into a tree where the original right 
 * nodes turned into left leaf nodes. Return the new root.
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1 
 *
 */
public class BinaryTreeUpsideDown {
	
	// why infinite loop?
	public static TreeNode upsideDownBinaryTree(TreeNode root) {  
		if (root == null || root.left == null) {
			// left child is null, meaning we have reached to the last level
			// so the current node must be the new root to return
			return root;
		} else {
			// recursively upside down the left subtree
			TreeNode newRoot = upsideDownBinaryTree(root.left);
			root.left.left = root.right;
			root.left.right = root;
			root.left = null;
			root.right = null;
			return newRoot;
		}
	}
	
	public static TreeNode upsideDownBinaryTreeIterative(TreeNode root) {  
		TreeNode node = root, parent = null, right = null;
		while (node != null) {
			// save the next element to visit
			TreeNode left = node.left;
			// make the current's left child to previous right
			node.left = right;
			// update previous right
			right = node.right;
			// make the current's right child to parent
			node.right = parent;
			parent = node;
			node = left;
		}
		return parent;
	}
	
	
	// not studied yet
	private static TreeNode out = null;
	public static TreeNode upsideDownBinaryTreeByPostorderTraversal(TreeNode root) {	
		TreeNode dummy = new TreeNode(0);
		dummy.left = new TreeNode(0);
		out = dummy;
		
		postorder(root);
		return dummy.right;
	}
		
	private static void postorder(TreeNode root) {
		if (root == null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		
		if (out.left == null) {
			out.left = root;
			out.left.left = null;
			out.left.right = null;
		} else if (out.right == null) {
			out.right = root;
			out.right.left = null;
			out.right.right = null;
		}
		
		if (out.left != null && out.right != null)
			out = out.right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
		PrintUtils.printBinaryTree(root);
		TreeNode newRoot = upsideDownBinaryTree(root);
		PrintUtils.printBinaryTree(newRoot);

	}

}
