package tree;

public class SwitchBinaryTreesToEqual {

	// assuming two trees can be switched to be equal
	public static int minSwitchTimes(TreeNode root1, TreeNode root2) {
		// roots are always both null or equal
		if (root1 == null && root2 == null)
			return 0;

		if (root1.left == null && root1.right == null)
			return 0;

		if (root1.left == null && root2.left != null || root1.left != null
				&& root2.left == null || root1.right == null
				&& root2.right != null || root1.right != null
				&& root2.right == null)
			return 1;

		if (root1.left.val == root2.left.val) {
			return minSwitchTimes(root1.left, root2.left)
					+ minSwitchTimes(root2.left, root2.right);
		} else {
			// root1.left.value == root2.right.value
			return 1 + minSwitchTimes(root1.left, root2.right)
					+ minSwitchTimes(root1.right, root2.left);
		}
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(
				5, null, null)), new TreeNode(3, null, new TreeNode(6, null, null)));
		TreeNode root2 = new TreeNode(1, new TreeNode(3, new TreeNode(6, null, null), null),
				new TreeNode(2, new TreeNode(5, null, null), new TreeNode(4, null, null)));
		System.out.println(minSwitchTimes(root1, root2));
	}

}
