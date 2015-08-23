package tree;

import java.util.Stack;

public class MaxTree {
	
	public TreeNode maxTree(int[] A) {
        // maintain a stack whose elements are in descending order
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        for (int num : A) {
            TreeNode node = new TreeNode(num);
            // pop if the current element is greater than stack top
            while (!s.isEmpty() && s.peek().val < num) {
                // make the largest element (smaller than current) in the stack a left child
                node.left = s.pop();
            }
            
            // if the stack is not empty, it means the top is larger than current
            // so we make the current a right child of the top
            if (!s.isEmpty()) s.peek().right = node;
            
            // push the current element in the right position
            s.push(node);
        }
        
        // root is the lowest element in the stack
        TreeNode root = null;
        while (!s.isEmpty()) root = s.pop();
        return root;
    }
	
	public TreeNode maxTreeRecursive(int[] A) {
        return maxTreeRecursive(A, 0, A.length - 1);
    }
    
    private TreeNode maxTreeRecursive(int[] A, int i, int j) {
        if (i > j) return null;
        int max = i;
        for (int k = i; k <= j; k++)
            if (A[max] < A[k]) max = k;
        TreeNode root = new TreeNode(A[max]);
        root.left = maxTreeRecursive(A, i, max - 1);
        root.right = maxTreeRecursive(A, max + 1, j);
        return root;
    }
}
