package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 != null && root2 == null || root1 == null && root2 != null) return false; 
        else return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
    
    public boolean isSymmetricIterative(TreeNode root1, TreeNode root2) {
    	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    	Queue<TreeNode> q2 = new LinkedList<TreeNode>();
    	if (root1 != null) q1.offer(root1);
    	if (root2 != null) q2.offer(root2);
    	
    	while (!q1.isEmpty() && !q2.isEmpty()) {
    		TreeNode n1 = q1.poll();
    		TreeNode n2 = q2.poll();
    		if (n1.val != n2.val) return false;
    		if (n1.left != null && n2.right != null) {
    			q1.offer(n1.left);
    			q2.offer(n2.right);
    		} else if (n1.left != null && n2.right == null || n1.left == null && n2.right != null) {
    			return false;
    		}

    		if (n1.right != null && n2.left != null) {
    			q1.offer(n1.right);
    			q2.offer(n2.left);
    		} else if (n1.right != null && n2.left == null || n1.right == null && n2.left != null) {
    			return false;
    		}
    	}
    	
    	return q1.isEmpty() && q2.isEmpty();
    }
}
