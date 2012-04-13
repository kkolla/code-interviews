package datastructure;

import java.util.Iterator;
import java.util.Stack;

import tree.Node;
import utils.CreateUtils;

public class InOrderBinaryTreeTraversalIterator implements Iterator<Node> {
	private Stack<Node> s;
	private Node curr = null;

	public InOrderBinaryTreeTraversalIterator(Node root) {
		s = new Stack<Node>();
		if (root != null) {
			curr = root;
		}
	}

	@Override
	public boolean hasNext() {
		return curr != null || !s.isEmpty();
	}

	@Override
	public Node next() {
		Node t = null;
		if (!hasNext())
			return t;
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
		return t;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Node root = CreateUtils.createBSTWithTenNodes();
		InOrderBinaryTreeTraversalIterator it = new InOrderBinaryTreeTraversalIterator(
				root);
		while (it.hasNext())
			System.out.println(it.next());
	}
}
