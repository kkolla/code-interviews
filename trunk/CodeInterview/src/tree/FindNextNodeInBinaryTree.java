package tree;

import utils.CreateUtils;

public class FindNextNodeInBinaryTree {

	public static TreeNode nextNode(TreeNode n) {
		if (n == null)
			return null;
		if (n.right != null) {
			TreeNode t = n.right;
			while (t.left != null)
				t = t.left;
			return t;
		} else {
			TreeNode t = n;
			while (t.parent != null) {
				if (t.parent.left == t)
					return t.parent;
				t = t.parent;
			}
			// for the case where n is the right most node
			return null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = CreateUtils.bstWithTenNodes();
		TreeNode first = root;
		while (first.left != null)
			first = first.left;
		while (first != null) {
			System.out.println(first.val);
			first = nextNode(first);
		}
	}

}
