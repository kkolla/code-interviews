package tree;

import java.util.LinkedList;
import java.util.Queue;

import utils.CreateUtils;

public class LevelByLevelTraversal {

	public static void traverseByLevel(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int currLevel = 1;
		int nextLevel = 0;
		while (!q.isEmpty()) {
			TreeNode n = q.poll();
			if (n.left != null) {
				q.add(n.left);
				nextLevel++;
			}
			if (n.right != null) {
				q.add(n.right);
				nextLevel++;
			}
			System.out.print(n.val + " ");
			currLevel--;
			if (currLevel == 0) {
				System.out.println();
				currLevel = nextLevel;
				nextLevel = 0;
			}
		}
	}

	public static void main(String[] args) {
		traverseByLevel(CreateUtils.bstWithTenNodes());
	}

}
