package tree;

/*
 * Given a binary tree, populate the next right pointers in each node.
 * You may assume that it is a full binary tree.
 * Each node other than the leaves has two children.
 */
public class AddRightSiblingPointersToNodes {

	public class NodeWithRightSiblingPointer extends Node {
		public NodeWithRightSiblingPointer left;
		public NodeWithRightSiblingPointer right;
		public NodeWithRightSiblingPointer rightSibling;

		public NodeWithRightSiblingPointer(int v) {
			super(v);
		}
	}

	public static void populate(NodeWithRightSiblingPointer root) {
		if (root == null)
			return;
		if (root.left != null)
			root.left.rightSibling = root.right;
		if (root.right != null && root.rightSibling != null)
			root.right.rightSibling = root.rightSibling.left;
		populate(root.left);
		populate(root.right);
	}
}
