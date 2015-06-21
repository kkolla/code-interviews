package datastructure;

import java.util.Iterator;
import java.util.Stack;

import tree.TreeNode;
import utils.CreateUtils;

public class InOrderBinaryTreeTraversalIterator implements Iterator<TreeNode> {
	private Stack<TreeNode> s;
	private TreeNode curr = null;

	public InOrderBinaryTreeTraversalIterator(TreeNode root) {
		s = new Stack<TreeNode>();
		if (root != null) {
			curr = root;
		}
	}

	@Override
	public boolean hasNext() {
		return curr != null || !s.isEmpty();
	}

	@Override
	public TreeNode next() {
		TreeNode t = null;
		if (hasNext()) {
			while (!s.isEmpty() || curr != null) {
				if (curr != null) {
					s.push(curr);
					curr = curr.left;
				} else {
					curr = s.pop();
					t = curr;
					curr = curr.right;
					break;
				}
			}
		}
		return t;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		TreeNode root = CreateUtils.bstWithTenNodes();
		InOrderBinaryTreeTraversalIterator it = new InOrderBinaryTreeTraversalIterator(
				root);
		while (it.hasNext())
			System.out.println(it.next());
	}
}
