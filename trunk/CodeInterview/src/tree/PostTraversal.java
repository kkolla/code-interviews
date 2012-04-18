package tree;

import java.util.Stack;

import utils.CreateUtils;

public class PostTraversal {

	public static void postTraverseIterative(Node root) {
		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		s.push(root);

		Node prev = null;
		while (!s.empty()) {
			Node curr = s.peek();
			// traverse down
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null)
					s.push(curr.left);
				else if (curr.right != null)
					s.push(curr.right);
				else { // both children null
					System.out.println(curr);
					s.pop();
				}
			} else if (curr.left == prev) { // traverse up from left
				if (curr.right != null)
					s.push(curr.right);
				else {
					System.out.println(curr);
					s.pop();
				}
			} else if (curr.right == prev) {// traverse up from right
				System.out.println(curr);
				s.pop();
			}
			prev = curr;
		}
	}

	/*
	 * void postOrderTraversalIterativeTwoStacks(BinaryTree *root) { if (!root)
	 * return; stack<BinaryTree*> s; stack<BinaryTree*> output; s.push(root);
	 * while (!s.empty()) { BinaryTree *curr = s.top(); output.push(curr);
	 * s.pop(); if (curr->left) s.push(curr->left); if (curr->right)
	 * s.push(curr->right); } while (!output.empty()) { cout <<
	 * output.top()->data << " "; output.pop(); } }
	 */

	public static void main(String[] args) {
		postTraverseIterative(CreateUtils.bstWithTenNodes());
	}

}
