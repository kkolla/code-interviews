package tree;

/**
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, 
 * is completely filled, and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2^h nodes inclusive at the last level h.
 *
 */
public class CountCompleteTreeNodes {
	
	// O(log(n)*log(n))
	public static int countNodesIterative(TreeNode root) {
		if (root == null) return 0;
		
		int height = height(root), nodes = 0;
		while (root != null) {
			nodes += 1; // root
			if (height(root.right) == height - 1) {
				// left tree (of height - 1) is full
				nodes += (1 << height - 1) - 1; // number of nodes on the left tree
				// left tree nodes are counted, now recursively count the right tree
				root = root.right;
			} else {
				// right tree must be full and of height - 2
				nodes += (1 << height - 2) - 1; // number of nodes on the right tree
				// right tree nodes are counted, now recursively count the left tree
				root = root.left;
			}
			height--;
		}
		return nodes;
	}
	
	private static int height(TreeNode root) {
		if (root == null) return 0;
		int height = 0;
		while (root != null) {
			root = root.left;
			height++;
		}
		return height;
	}
	
	// O(log(n)*log(n))
	public static int countNodes(TreeNode root) {
		if (root == null) return 0;
		
		int leftHeight = 0;
		TreeNode n = root.left;
		while (n != null) {
			n = n.left;
			leftHeight++;
		}
		
		int rightHeight = 0;
		n = root.right;
		while (n != null) {
			n = n.right;
			rightHeight++;
		}
		
		if (leftHeight == rightHeight)
			return (1 << (leftHeight + 1)) - 1;
		else
			return 1 + countNodes(root.left) + countNodes(root.right);
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3),  new TreeNode(4)), new TreeNode(5));
		System.out.println(countNodes(root));
		System.out.println(countNodesIterative(root));
	}

}
