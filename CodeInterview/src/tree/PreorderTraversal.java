package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if (root != null) s.push(root);    
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            result.add(n.val);
            if (n.right != null) s.push(n.right);
            if (n.left != null) s.push(n.left);
        }
        return result;
    }
}
