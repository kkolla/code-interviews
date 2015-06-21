package tree;

import utils.CreateUtils;

public class ValidateBinarySearchTree {

	public static boolean validate(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		return root.val > min && root.val < max
				&& validate(root.left, min, root.val)
				&& validate(root.right, root.val, max);
	}

	public static void main(String[] args) {
		TreeNode root = CreateUtils.bstWithTenNodes();
		System.out
				.println(validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		root.val = 100;
		System.out
				.println(validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
