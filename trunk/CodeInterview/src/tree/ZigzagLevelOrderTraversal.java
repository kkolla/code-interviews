package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.CreateUtils;

/*Printing a Binary Tree in Zig Zag Level-Order
 1                      1
 2    3          ==>    3   2
 4   5     6            4   5  6
 */
public class ZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        currLevel.push(root);
        boolean fromLeftToRight = false;
        List<Integer> l = new ArrayList<Integer>();
        
        while (!currLevel.isEmpty()) {
            TreeNode n = currLevel.pop();
            l.add(n.val);

            if (fromLeftToRight) {
                if (n.right != null) nextLevel.push(n.right);
                if (n.left != null) nextLevel.push(n.left);
            } else {
                if (n.left != null) nextLevel.push(n.left);
                if (n.right != null) nextLevel.push(n.right);
            }
            
            if (currLevel.isEmpty()) {
                currLevel = nextLevel;
                nextLevel = new Stack<TreeNode>();
                fromLeftToRight = !fromLeftToRight;
                result.add(l);
                l = new ArrayList<Integer>();
            }
        }
        return result;
    }

}
