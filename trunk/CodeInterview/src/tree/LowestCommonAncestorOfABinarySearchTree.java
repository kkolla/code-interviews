package tree;

public class LowestCommonAncestorOfABinarySearchTree {
	
	// time: O(h), space: O(1)
	public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            int rootVal = root.val;
            if (p.val < rootVal && q.val < rootVal) root = root.left;
            else if (p.val > rootVal && q.val > rootVal) root = root.right;
            else break;
        }
        return root;
   }
	
	// time: O(h), space: O(h)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
}
