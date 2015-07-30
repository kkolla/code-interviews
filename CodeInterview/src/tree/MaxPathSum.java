package tree;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *       1
 *      / \
  *    2   3
 * @author Zli
 *
 */
public class MaxPathSum {
	
	public static int maxSum;
    
    public int maxPathSum(TreeNode root) {
    	maxSum = Integer.MIN_VALUE;
        maxPath(root);
        return maxSum;
    }
    
    // returns the max sum of path of which root is part of
    private int maxPath(TreeNode root) {
    	if (root == null) return 0;
    	int leftMax = maxPath(root.left);
    	int rightMax = maxPath(root.right);
    	int current = Math.max(root.val, Math.max(root.val + leftMax, root.val + rightMax));
	    maxSum = Math.max(maxSum, Math.max(current, leftMax + root.val + rightMax));
    	return current;
    }
    
    /* private Path maxPath(TreeNode root) {
        if (root == null) return new Path(null, 0); // 0 is fake
        
        Path maxPath = new Path(root, root.val);
        if (root.left == null && root.right == null) {
           // considered
        } else if (root.left == null || root.right == null) {
            Path childPath = root.left == null ? maxPath(root.right) : maxPath(root.left);
            if (childPath.sum > maxPath.sum) maxPath = childPath;
            if ((root.left == null ? root.right : root.left) == childPath.top && 
            	childPath.sum + root.val > maxPath.sum) maxPath = new Path(root, childPath.sum + root.val);
        } else {
        	Path leftPath = maxPath(root.left);
        	Path rightPath = maxPath(root.right);
            // the max path could be one of the following
            // (1) left max path
            if (leftPath.sum > maxPath.sum) maxPath = leftPath;
            // (2) right max path
            if (rightPath.sum > maxPath.sum) maxPath = rightPath;
            // (3) left path + root + right path if root can be connected to both paths
            if (root.left == leftPath.top && root.right == rightPath.top && 
               leftPath.sum + root.val + rightPath.sum > maxPath.sum) {
               maxPath = new Path(root, leftPath.sum + root.val + rightPath.sum);
            }
            // (4) left max path + root if root can be connected to left max path
            if (root.left == leftPath.top && leftPath.sum + root.val > maxPath.sum) {
               maxPath = new Path(root, leftPath.sum + root.val);
            }
            // (5) right max path + root if root can be connected to right max path
            if (root.right == rightPath.top && rightPath.sum + root.val > maxPath.sum) {
               maxPath = new Path(root, rightPath.sum + root.val);
            }
        }
        
        return maxPath;
    } */
    
    public static void main(String[] s) {
    	MaxPathSum mps = new MaxPathSum();
    	System.out.println(mps.maxPathSum(new TreeNode(-2, null, new TreeNode(1))));
    }
}
