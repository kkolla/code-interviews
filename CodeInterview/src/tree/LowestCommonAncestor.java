package tree;

public class LowestCommonAncestor {

	// assuming p and q both are null or exist in the tree
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else return left != null ? left : right;
    }

	public static void main(String[] args) {
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2, n4, n5);
		TreeNode n3 = new TreeNode(3);
		TreeNode root = new TreeNode(1, n2, n3);
		TreeNode ancestor = lowestCommonAncestor(root, n5, n4);
		System.out.println("LCA's value: " + ancestor.val);
	}

}
