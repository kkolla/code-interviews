package tree;

import java.util.ArrayList;
import java.util.List;

import utils.CreateUtils;
import utils.PrintUtils;

public class FindPathFromOneNodeToAnotherInBST {

	public static void findPath(TreeNode root, TreeNode start, TreeNode end) {
		if (root == null)
			return;
		TreeNode lca = LowestCommonAncestor.lowestCommonAncestor(root, start, end);
		List<Integer> firstHalfPath = new ArrayList<Integer>();
		List<Integer> secondHalfPath = new ArrayList<Integer>();
		TreeNode n = lca;
		while (n != null) {
			if (n == start) {
				if (n != lca)
					firstHalfPath.add(n.val);
				break;
			} else {
				if (n != lca)
					firstHalfPath.add(n.val);
				if (n.val > start.val)
					n = n.left;
				else
					n = n.right;
			}
		}
		n = lca;
		while (n != null) {
			if (n == end) {
				if (n != lca)
					secondHalfPath.add(n.val);
				break;
			} else {
				if (n != lca)
					secondHalfPath.add(n.val);
				if (n.val > end.val)
					n = n.left;
				else
					n = n.right;
			}
		}
		for (int i = firstHalfPath.size() - 1; i >= 0; i--)
			System.out.println(firstHalfPath.get(i));
		System.out.println(lca.val);
		for (int i = 0; i < secondHalfPath.size(); i++)
			System.out.println(secondHalfPath.get(i));
	}

	public static void main(String[] args) {
		TreeNode root = CreateUtils.bstWithTenNodes();
		PrintUtils.printBinaryTree(root);
		System.out.println();
		TreeNode n1 = root.left.right;
		TreeNode n2 = root.right.left;
		findPath(root, n1, n2);
		System.out.println();
		findPath(root, n2, n1);
	}

}
