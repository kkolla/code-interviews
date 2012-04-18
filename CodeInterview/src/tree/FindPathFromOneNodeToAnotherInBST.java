package tree;

import java.util.ArrayList;
import java.util.List;

import utils.CreateUtils;
import utils.PrintUtils;

public class FindPathFromOneNodeToAnotherInBST {

	public static void findPath(Node root, Node start, Node end) {
		if (root == null)
			return;
		Node lca = LeastCommonAncestor.lca(root, start, end);
		List<Integer> firstHalfPath = new ArrayList<Integer>();
		List<Integer> secondHalfPath = new ArrayList<Integer>();
		Node n = lca;
		while (n != null) {
			if (n == start) {
				if (n != lca)
					firstHalfPath.add(n.value);
				break;
			} else {
				if (n != lca)
					firstHalfPath.add(n.value);
				if (n.value > start.value)
					n = n.left;
				else
					n = n.right;
			}
		}
		n = lca;
		while (n != null) {
			if (n == end) {
				if (n != lca)
					secondHalfPath.add(n.value);
				break;
			} else {
				if (n != lca)
					secondHalfPath.add(n.value);
				if (n.value > end.value)
					n = n.left;
				else
					n = n.right;
			}
		}
		for (int i = firstHalfPath.size() - 1; i >= 0; i--)
			System.out.println(firstHalfPath.get(i));
		System.out.println(lca.value);
		for (int i = 0; i < secondHalfPath.size(); i++)
			System.out.println(secondHalfPath.get(i));
	}

	public static void main(String[] args) {
		Node root = CreateUtils.bstWithTenNodes();
		PrintUtils.printBinaryTree(root);
		System.out.println();
		Node n1 = root.left.right;
		Node n2 = root.right.left;
		findPath(root, n1, n2);
		System.out.println();
		findPath(root, n2, n1);
	}

}
