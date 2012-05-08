package tree;

import java.util.LinkedList;
import java.util.Queue;

import utils.CreateUtils;
import utils.PrintUtils;

public class BinaryHeightAndWidth {

	public static int height(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static int width(Node root) {
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		int currWidth = 1;
		int maxWidth = 1;
		int nextWidth = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.left != null) {
				nextWidth++;
				q.offer(n.left);
			}
			if (n.right != null) {
				nextWidth++;
				q.offer(n.right);
			}
			if (--currWidth == 0) {
				if (nextWidth > maxWidth) {
					maxWidth = nextWidth;
				}
				currWidth = nextWidth;
				nextWidth = 0;
			}
		}
		return maxWidth;
	}

	public static void main(String[] args) {
		Node root = CreateUtils.bstWithTenNodes();
		PrintUtils.printBinaryTree(root);
		System.out.println("height: " + height(root));
		System.out.println("width: " + width(root));
	}

}
