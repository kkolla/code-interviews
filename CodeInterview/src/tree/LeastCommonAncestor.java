package tree;

public class LeastCommonAncestor {

	// assuming n1 n2 are null or exist in the tree
	public static TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null || root == n1 || root == n2)
			return root;
		TreeNode left = lca(root.left, n1, n2);
		TreeNode right = lca(root.right, n1, n2);
		if (left != null && right != null)
			return root;
		else
			return left != null ? left : right;
	}

	public static void main(String[] args) {
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2, n4, n5);
		TreeNode n3 = new TreeNode(3);
		TreeNode root = new TreeNode(1, n2, n3);
		TreeNode ancestor = lca(root, n5, n4);
		System.out.println("LCA's value: " + ancestor.val);
	}

}
