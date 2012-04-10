package tree;

import java.util.LinkedList;
import java.util.Queue;

import utils.CreateUtils;

public class LevelByLevelTraversal {

	public static void traverseByLevel(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int currLevel = 1;
		int nextLevel = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.left != null) {
				q.add(n.left);
				nextLevel++;
			}
			if (n.right != null) {
				q.add(n.right);
				nextLevel++;
			}
			System.out.print(n.value + " ");
			currLevel--;
			if (currLevel == 0) {
				System.out.println();
				currLevel = nextLevel;
				nextLevel = 0;
			}
		}
	}

	public static void main(String[] args) {
		traverseByLevel(CreateUtils.createBSTWithTenNodes());
	}

}
