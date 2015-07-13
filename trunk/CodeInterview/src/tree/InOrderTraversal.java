package tree;

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

	public static void main(String[] args) {
		TreeNode root = CreateUtils.bstWithTenNodes();
		inOrderTraverseIterative(root);
	}

}
