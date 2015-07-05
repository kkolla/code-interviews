package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class PathSumII {
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		return pathSum(root, sum, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
    }

	private static List<List<Integer>> pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp) {
		if (root == null) return result;
		
		temp.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			result.add(new ArrayList<Integer>(temp));
		} else {
    		pathSum(root.left, sum - root.val, result, temp);
    		pathSum(root.right, sum - root.val, result, temp);
		}
		temp.remove(temp.size() - 1);
		return result;
	}

}
