package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 * 
 *    1
 *  /   \
 * 2     3
 *  \
 *  5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 *
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePaths(root, new ArrayList<String>(), "");    
    }
    
    public List<String> binaryTreePaths(TreeNode root, List<String> result, String temp) {
        if (root == null) return result;
        
        temp = (temp.isEmpty() ? "" : temp + "->") + root.val;
        if (root.left == null && root.right == null) {
            result.add(temp);
        } else {
            if (root.left != null) binaryTreePaths(root.left, result, temp);
            if (root.right != null) binaryTreePaths(root.right, result, temp);
        }
        return result;
    }
}
