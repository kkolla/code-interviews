package tree;

import utils.CreateUtils;

public class FindTheNthLargestNodeInBST {

	public static int find(TreeNode root, int n, int rank) {
		if (root == null)
			return rank;
		rank = find(root.right, n, rank);
		rank++;
		if (rank == n) {
			System.out.println(root.val);
			return rank;
		}
		return find(root.left, n, rank);
	}

	public static void main(String[] args) {
		TreeNode root = CreateUtils.bstWithTenNodes();
		for (int i = 10; i >= 1; i--)
			find(root, i, 0);
	}

}
