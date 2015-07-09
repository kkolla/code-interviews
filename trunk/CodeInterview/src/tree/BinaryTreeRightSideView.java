package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.PrintUtils;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.

 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 *
 */
public class BinaryTreeRightSideView {
	
    private static int maxLevel = -1;
	
	public static List<Integer> rightSideView(TreeNode root) {
		return rightSideView(root, 0, new ArrayList<Integer>());
	}
	
	public static List<Integer> rightSideView(TreeNode root, int currLevel, List<Integer> result) {
		if (root == null) return result;

		// if the current level is greater than the previously found max level,
		// add the node to result as it must be the rightmost one
		if (currLevel > maxLevel) {
			maxLevel = currLevel;
			result.add(root.val);
		}
		
		rightSideView(root.right, currLevel + 1, result);
		rightSideView(root.left, currLevel + 1, result);
		
		return result;
	}
	
	public List<Integer> rightSideViewIterative(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) return result;
	
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int nodesInCurrLevel = 1, nodesInNextLevel = 0;
		while (!q.isEmpty()) {
			TreeNode n = q.poll();
			nodesInCurrLevel--;
			if (n.left != null) {
				q.add(n.left);
				nodesInNextLevel++;
			}
			if (n.right != null) {
				q.add(n.right);
				nodesInNextLevel++;
			}
			if (nodesInCurrLevel == 0) {
				result.add(n.val);
				nodesInCurrLevel = nodesInNextLevel;
				nodesInNextLevel = 0;
			}

		}
		return result;
    }

	public static void main(String[] args) {
		PrintUtils.printList(rightSideView(new TreeNode(1, null, new TreeNode(2))));
	}

}
