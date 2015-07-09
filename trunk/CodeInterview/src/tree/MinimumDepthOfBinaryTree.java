package tree;

public class MinimumDepthOfBinaryTree {
	
	public int minDepth(TreeNode root) {
        return minDepth(root, 0);    
    }
    
    public int minDepth(TreeNode root, int depth) {
    	if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else if (root.left != null && root.right != null) 
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        else
            return 1 + minDepth(root.left == null ? root.right : root.left);
    }
    
    // by level traversal: http://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
