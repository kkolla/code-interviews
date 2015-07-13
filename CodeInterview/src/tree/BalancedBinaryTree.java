package tree;

public class BalancedBinaryTree {
	
	// O(n)
    public boolean isBalanced(TreeNode root) {
    	return heightForBalanced(root) != -1;
    }
    
    // returns height if balanced, or -1 if not
    public int heightForBalanced(TreeNode root) {
    	if (root == null) return 0;
    	
    	int leftHeight = heightForBalanced(root.left);
    	if (leftHeight == -1) return -1;
    	int rightHeight = heightForBalanced(root.right);
    	if (rightHeight == -1) return -1;
    	   	
    	if (Math.abs(leftHeight - rightHeight) > 1)
    		return -1;
    	else
    		return 1 + Math.max(leftHeight, rightHeight);
    }
	
	
	// O(hn), because each node may be visited at most h times
	public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && 
        		isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left),  height(root.right));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
