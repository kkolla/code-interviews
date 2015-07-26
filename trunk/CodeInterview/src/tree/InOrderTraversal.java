package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.CreateUtils;

public class InOrderTraversal {
	
	public static void inOrderTraverseIterative(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode n = root;
		while (n != null || !s.isEmpty()) {
			if (n != null) {
				s.push(n);
				n = n.left;
			} else {
				TreeNode poped = s.pop();
				System.out.println(poped);
				n = poped.right;
			}
		}
	}
	
	// time: O(n), space: O(1)
	// https://en.wikipedia.org/wiki/Threaded_binary_tree
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                // if the left child doesn't exist, we should output the current and go to right
                result.add(curr.val);
                curr = curr.right;
            } else {
                // find the rightmost node on the left subtree, which is the predecessor of current
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) pre = pre.right;
                if (pre.right == null) {
                    // first time visting here
                    // construct threaded tree
                    pre.right = curr;
                    // predecessor is connected, we can go visit the left subtree now
                    curr = curr.left;
                } else {
                    // pre.right == curr, second time visting here, current's predecessor has been visited
                    result.add(curr.val);
                    // destruct the threaded tree
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
    
        return result;
    }

	public static void main(String[] args) {
		TreeNode root = CreateUtils.bstWithTenNodes();
		inOrderTraverseIterative(root);
	}

}
