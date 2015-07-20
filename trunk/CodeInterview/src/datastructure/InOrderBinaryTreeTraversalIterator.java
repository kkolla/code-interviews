package datastructure;

import java.util.Iterator;
import java.util.Stack;

import tree.TreeNode;
import utils.CreateUtils;

public class InOrderBinaryTreeTraversalIterator implements Iterator<TreeNode> {
	private Stack<TreeNode> s = new Stack<TreeNode>();
	private TreeNode n = null;

	public InOrderBinaryTreeTraversalIterator(TreeNode root) {
		this.n = root;
	}

	@Override
	public boolean hasNext() {
        return n != null || !s.isEmpty();
	}

	@Override
	public TreeNode next() {
		while (hasNext()) {
            if (n != null) {
                s.push(n);
                n = n.left;
            } else {
                TreeNode next = this.s.pop();
                n = next.right;
                return next;
            }   
        }
		return null;
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
