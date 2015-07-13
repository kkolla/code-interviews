package tree;

import java.util.Stack;

import utils.CreateUtils;

public class KthSmallestElementInBST {
	
	public static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode n = root;
		int rank = 0;
		while (n != null || !s.isEmpty()) {
			if (n != null) {
				s.push(n);
				n = n.left;
			} else {
				TreeNode poped = s.pop();
				if (++rank == k) return poped.val;
				n = poped.right;
			}
		}
		// unreachable for leetcode
		return -1;
	}

	public static void main(String[] args) {
		TreeNode root = CreateUtils.bstWithTenNodes();

		for (int i = 1; i <= 10; i++)
			System.out.println(kthSmallest(root, i));
	}

}
