package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tempLeft = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tempLeft);
        }
        return root;
    }
	
	public void invertBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            swapChildren(n);
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }
    
    private void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;    
    }
}
